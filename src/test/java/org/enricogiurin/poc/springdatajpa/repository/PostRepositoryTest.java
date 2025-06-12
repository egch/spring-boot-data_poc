package org.enricogiurin.poc.springdatajpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.enricogiurin.poc.springdatajpa.entity.CommentEntity;
import org.enricogiurin.poc.springdatajpa.entity.PostEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.StopWatch;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataJpaTest(excludeAutoConfiguration = TestDatabaseAutoConfiguration.class)

class PostRepositoryTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
        .withDatabaseName("testdb")
        .withUsername("test")
        .withPassword("test");

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Sql({  "/sql/cleanup.sql",
        "/sql/populate.sql"
    })
    @Test
    void findById(){
        PostEntity postEntity = postRepository.findById(1L).orElseThrow(RuntimeException::new);
        assertThat(postEntity).isNotNull();
        assertThat(postEntity.getContent()).isEqualTo("Red is the best color");
        assertThat(postEntity.getComments()).hasSize(2);
    }

    @Test
    @Sql({  "/sql/cleanup.sql",
        "/sql/populate.sql"
    })
    void deletePost(){
        postRepository.deleteAll();
        List<CommentEntity> list = commentRepository.findByPost_Id(1L);
        assertThat(list).isEmpty();
    }

    @Test
    @Sql({  "/sql/cleanup.sql"})
    void insert200Posts() {
        List<PostEntity> posts = IntStream.rangeClosed(1, 200)
            .mapToObj(i -> PostEntity.builder()
                .content("Post content #" + i)
                .comments(Collections.emptySet())
                .build())
            .collect(Collectors.toList());
        StopWatch sw = new StopWatch();
        sw.start();
        postRepository.saveAll(posts);
        sw.stop();
        System.out.println("Time taken: " + sw.getTotalTimeMillis() + " ms");
        assertThat(postRepository.count()).isEqualTo(200L);
    }
}