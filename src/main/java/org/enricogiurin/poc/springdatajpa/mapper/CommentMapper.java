package org.enricogiurin.poc.springdatajpa.mapper;


import org.enricogiurin.poc.springdatajpa.dto.Comment;
import org.enricogiurin.poc.springdatajpa.entity.CommentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {

    Comment map(CommentEntity commentEntity);

    CommentEntity map(Comment post);

}
