package com.project.moviepop.reviewboard.mapper;

import com.project.moviepop.reviewboard.dto.ReviewBoardDto;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import com.project.moviepop.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring")
public interface ReviewBoardMapper {
    ReviewBoard PostToReviewBoard(ReviewBoardDto.Post post);
    ReviewBoard PatchToReviewBoard(ReviewBoardDto.Patch patch);

    default ReviewBoardDto.Response reviewBoardToResponse(ReviewBoard reviewBoard) {
        UserDto.ReviewBoardResponse userResponse = new UserDto.ReviewBoardResponse(
                reviewBoard.getUser().getUserId(),
                reviewBoard.getUser().getNickname(),
                reviewBoard.getUser().getProfileImage()
        );

        ReviewBoardDto.Response response = ReviewBoardDto.Response.builder()
                .reviewBoardId(reviewBoard.getReviewBoardId())
                .title(reviewBoard.getTitle())
                .review(reviewBoard.getReview())
                .wish(reviewBoard.getWish())
                .thumbnail(reviewBoard.getThumbnail())
                .createdAt(reviewBoard.getCreatedAt())
                .user(userResponse)
                .build();

        return response;
    }
}
