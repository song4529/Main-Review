package com.project.moviepop.comment.mapper;

import com.project.moviepop.comment.dto.CommentDto;
import com.project.moviepop.comment.entity.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment commentPostDtoToComment(CommentDto.Post postDto);
    Comment commentPatchDtoToComment(CommentDto.Patch patchDto);
    CommentDto.PatchResponse commentToCommentPatchResponseDto(Comment comment);
    CommentDto.Response commentToCommentResponseDto(Comment comment);
    List<CommentDto.Response> commentsToCommentResponseDtos(List<Comment> comments);
    CommentDto.likeResponse commentToCommentLikeResponse(Comment comment);
}
