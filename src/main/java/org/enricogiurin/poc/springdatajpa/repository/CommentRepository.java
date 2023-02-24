package org.enricogiurin.poc.springdatajpa.repository;

import org.enricogiurin.poc.springdatajpa.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPost_Id(Long postId);

}
