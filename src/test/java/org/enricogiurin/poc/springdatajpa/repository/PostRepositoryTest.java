package org.enricogiurin.poc.springdatajpa.repository;

import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Sql({"/sql/cleanup.sql", "/sql/populate.sql"})
    void findById(){
        PostEntity postEntity = postRepository.findById(1L).orElseThrow(RuntimeException::new);
        assertThat(postEntity).isNotNull();
        assertThat(postEntity.getContent()).isEqualTo("Hello World");
    }
}