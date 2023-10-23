package com.project.moviepop.reviewboard.mapper;

import com.project.moviepop.reviewboard.dto.ReviewBoardDto;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring")
public interface ReviewBoardMapper {
    ReviewBoard PostToReviewBoard(ReviewBoardDto.Post post);
}
