package com.project.moviepop.comment.mapper;

import com.project.moviepop.comment.dto.CommentDto;
import com.project.moviepop.comment.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment commentPostDtoToComment(CommentDto.Post postDto);
}
