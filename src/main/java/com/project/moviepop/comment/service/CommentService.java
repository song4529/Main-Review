package com.project.moviepop.comment.service;

import com.project.moviepop.comment.entity.Comment;
import com.project.moviepop.comment.repository.CommentRepository;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import com.project.moviepop.reviewboard.service.ReviewBoardService;
import com.project.moviepop.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
