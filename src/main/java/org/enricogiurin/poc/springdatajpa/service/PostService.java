package org.enricogiurin.poc.springdatajpa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.enricogiurin.poc.springdatajpa.dto.Post;
import org.enricogiurin.poc.springdatajpa.entity.CommentEntity;
import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.enricogiurin.poc.springdatajpa.mapper.PostMapper;
import org.enricogiurin.poc.springdatajpa.repository.CommentRepository;
import org.enricogiurin.poc.springdatajpa.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    private final PostMapper postMapper;

    public Long addPost(String contents){
        PostEntity post = PostEntity.builder()
                .content(contents)
                .build();
        PostEntity save = postRepository.save(post);
        log.info("Created a new post with id: {}", save.getId());
        return save.getId();
    }


    public Long addComment(String content, Long postId){
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("no post with id: " + postId));
        CommentEntity commentEntity = CommentEntity.builder()
                .content(content)
                .post(postEntity)
                .build();
        CommentEntity save = commentRepository.save(commentEntity);
        log.info("Created a new comment with id: {}", save.getId());
        return save.getId();
    }


    public Post find(Long id){
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id " + id + " not present"));
        return postMapper.map(postEntity);
    }
}
