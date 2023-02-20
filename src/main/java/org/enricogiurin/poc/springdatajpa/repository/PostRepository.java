package org.enricogiurin.poc.springdatajpa.repository;

import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<PostEntity, Long> {


}
