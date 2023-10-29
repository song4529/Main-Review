package com.project.moviepop.comment.service;

import com.project.moviepop.comment.entity.Comment;
import com.project.moviepop.comment.repository.CommentRepository;
import com.project.moviepop.exception.BusinessLogicException;
import com.project.moviepop.exception.ExceptionCode;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import com.project.moviepop.reviewboard.service.ReviewBoardService;
import com.project.moviepop.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(ReviewBoard reviewBoard, User user, Comment comment) {
        //유저 정보를 가져와서 comment에 넣어준다
        comment.setUser(user);
        //게시글 정보를 가져와서 comment에 넣어준다
        comment.setReviewBoard(reviewBoard);

        return commentRepository.save(comment);
    }

    public Comment updateComment(long userId, Comment comment) {
        Comment findComment = findComment(comment.getCommentId());
        if(findComment.getUser().getUserId() != userId)
            throw new BusinessLogicException(ExceptionCode.CANNOT_UPDATE_COMMENT);

        Optional.ofNullable(comment.getContent())
                .ifPresent(content -> findComment.setContent(content));

        return commentRepository.save(findComment);
    }


    public Comment findComment(long commentId) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        Comment comment = optionalComment.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));

        return comment;
    }

    public Page<Comment> findComments(int page, int size) {
        return commentRepository.findAll(PageRequest.of(
                page - 1, size, Sort.by("commentId").descending())
        );
    }
}
