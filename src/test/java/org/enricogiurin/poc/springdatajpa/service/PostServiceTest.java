package org.enricogiurin.poc.springdatajpa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.enricogiurin.poc.springdatajpa.entity.CommentEntity;
import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.enricogiurin.poc.springdatajpa.repository.CommentRepository;
import org.enricogiurin.poc.springdatajpa.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.StopWatch;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataJpaTest(excludeAutoConfiguration = TestDatabaseAutoConfiguration.class)
@Import({PostService.class})
class PostServiceTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostService postService;

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
        .withDatabaseName("testdb")
        .withUsername("test")
        .withPassword("test");

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    void setUp() {
        this.postService = new PostService(postRepository, commentRepository);
    }

    @Test
    @Sql({  "/sql/cleanup.sql"
    })
    void addPost() {

        //when
        Long id = postService.addPost("hello");
        //then
        assertThat(id).isEqualTo(1L);
    }

    @Test
    @Sql({  "/sql/cleanup.sql", "/sql/populate-post.sql"})
    void addComments() {
        final int size = 1_000;
        PostEntity postEntity = postRepository.findById(1L).orElseThrow();
        List<CommentEntity> commentsList = IntStream.rangeClosed(1, size)
            .mapToObj(j -> CommentEntity.builder()
                .content("comment: " + j)
                .post(postEntity)
                .build())
            .toList();
        StopWatch sw = new StopWatch();
        sw.start();
        postService.addComments(commentsList, postEntity.getId());
        sw.stop();
        System.out.println("Time taken: " + sw.getTotalTimeMillis() + " ms");
        PostEntity result = postRepository.findById(1L).orElseThrow();
        assertThat(result.getComments()).hasSize(size);
        List<CommentEntity> allComments = commentRepository.findAll();
        assertThat(allComments).hasSize(size);
    }
}