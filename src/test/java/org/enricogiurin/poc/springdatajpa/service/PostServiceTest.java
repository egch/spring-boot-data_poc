package org.enricogiurin.poc.springdatajpa.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.enricogiurin.poc.springdatajpa.repository.CommentRepository;
import org.enricogiurin.poc.springdatajpa.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    PostRepository postRepository;

    @Mock
    CommentRepository commentRepository;

    PostService postService;

    @BeforeEach
    void setUp() {
        this.postService = new PostService(postRepository, commentRepository);
    }

    @Test
    void addPost() {
        //given
        PostEntity postEntity = PostEntity.builder()
                .id(1L)
                .content("hello")
                .build();
        when(postRepository.save(any())).thenReturn(postEntity);
        //when
        Long id = postService.addPost("hello");
        //then
        assertThat(id).isEqualTo(1L);

    }
}