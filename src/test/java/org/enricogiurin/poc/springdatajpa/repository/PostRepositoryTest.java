package org.enricogiurin.poc.springdatajpa.repository;

import org.enricogiurin.poc.springdatajpa.entity.CommentEntity;
import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql({"/sql/cleanup.sql", "/sql/populate.sql"})
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById(){
        PostEntity postEntity = postRepository.findById(1L).orElseThrow(RuntimeException::new);
        assertThat(postEntity).isNotNull();
        assertThat(postEntity.getContent()).isEqualTo("Italians Do It Better");
        assertThat(postEntity.getComments()).hasSize(2);
    }

    @Test
    void deletePost(){
        postRepository.deleteAll();
        List<CommentEntity> list = commentRepository.findByPost_Id(1L);
        assertThat(list).isEmpty();
    }
}