package com.project.moviepop.reviewboard.service;

import com.project.moviepop.exception.BusinessLogicException;
import com.project.moviepop.exception.ExceptionCode;
import com.project.moviepop.reviewboard.dto.ReviewBoardDto;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import com.project.moviepop.reviewboard.mapper.ReviewBoardMapper;
import com.project.moviepop.reviewboard.repository.ReviewBoardRepository;
import com.project.moviepop.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

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

    public ReviewBoard updateReviewBoard(long userId, ReviewBoard reviewBoard) {
        ReviewBoard getReviewBoard = findReviewBoard(reviewBoard.getReviewBoardId());
        if(getReviewBoard.getUser().getUserId() != userId)
            throw new BusinessLogicException(ExceptionCode.INVALID_USER);

        Optional.ofNullable(reviewBoard.getTitle())
                .ifPresent(title -> getReviewBoard.setTitle(title));
        Optional.ofNullable(reviewBoard.getReview())
                .ifPresent(review -> getReviewBoard.setReview(review));

        return reviewBoardRepository.save(getReviewBoard);
    }

    //추가적인 매서드
    @Transactional(readOnly = true)
    public ReviewBoard findReviewBoard(long reviewBoardId) {
        Optional<ReviewBoard> optionalReviewBoard = reviewBoardRepository.findById(reviewBoardId);
        ReviewBoard findReviewBoard =
                optionalReviewBoard.orElseThrow(() -> new BusinessLogicException(ExceptionCode.REVIEW_BOARD_NOT_FOUND));
        return findReviewBoard;
    }
}
