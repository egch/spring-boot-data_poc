package org.enricogiurin.poc.springdatajpa.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.enricogiurin.poc.springdatajpa.dto.Post;
import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.enricogiurin.poc.springdatajpa.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public Long addPost(String contents){
        PostEntity post = PostEntity.builder()
                .content(contents)
                .build();
        PostEntity save = postRepository.save(post);
        log.info("Created a new post with id: {}", save.getId());
        return save.getId();
    }

    public Post find(Long id){
        PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id " + id + " not present"));
        return Post.builder()
                .content(postEntity.getContent())
                .build();
    }
}
