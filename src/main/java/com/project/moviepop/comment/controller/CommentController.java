package com.project.moviepop.comment.controller;

import com.project.moviepop.comment.dto.CommentDto;
import com.project.moviepop.comment.entity.Comment;
import com.project.moviepop.comment.mapper.CommentMapper;
import com.project.moviepop.comment.service.CommentService;
import com.project.moviepop.dto.ResponseDto;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import com.project.moviepop.reviewboard.service.ReviewBoardService;
import com.project.moviepop.user.entity.User;
import com.project.moviepop.user.service.UserService;
import com.project.moviepop.utils.UriComponent;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/comments")
@Validated
@AllArgsConstructor
public class CommentController {
    public static final String COMMENT_DEFAULT_URL = "/comments";
    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final UserService userService;
    private final ReviewBoardService reviewBoardService;

    @PostMapping("/{review-id}/users/{user-id}/comments") // 댓글 작성
    public ResponseEntity postComment(@PathVariable("review-id") @Positive long reviewId,
                                      @PathVariable("user-id") @Positive long userId,
                                      @RequestBody @Valid CommentDto.Post requestBody) {
        User user = userService.findUser(userId);
        ReviewBoard reviewBoard = reviewBoardService.findReviewBoard(reviewId);

        Comment comment = commentService.createComment(reviewBoard, user, commentMapper.commentPostDtoToComment(requestBody));

        URI location = UriComponent.createUri(COMMENT_DEFAULT_URL, comment.getCommentId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{comment-id}/users/{user-id}")
    public ResponseEntity patchComment(@PathVariable("comment-id") @Positive long commentId,
                                       @PathVariable("user-id") @Positive long userId,
                                       @RequestBody @Valid CommentDto.Patch requestBody) {
        requestBody.setCommentId(commentId);
        Comment comment = commentService.updateComment(userId, mapper.commentPatchDtoToComment(requestBody));

        return new ResponseEntity (
                new ResponseDto.SingleResponseDto(commentMapper.commentToCommentPatchResponseDto(comment)),
                HttpStatus.OK
        );
    }
}
