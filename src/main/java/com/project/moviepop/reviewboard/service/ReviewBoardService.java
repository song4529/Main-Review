package com.project.moviepop.reviewboard.service;

import com.project.moviepop.reviewboard.dto.ReviewBoardDto;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import com.project.moviepop.reviewboard.mapper.ReviewBoardMapper;
import com.project.moviepop.reviewboard.repository.ReviewBoardRepository;
import com.project.moviepop.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ReviewBoardService {
    private final ReviewBoardRepository reviewBoardRepository;
    private final ReviewBoardMapper reviewBoardMapper;

    public ReviewBoard createReviewBoard(ReviewBoardDto.Post post) {
        ReviewBoard newReviewBoard = reviewBoardMapper.PostToReviewBoard(post);
        return newReviewBoard;
    }
}
