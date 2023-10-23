package com.project.moviepop.reviewboard.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.moviepop.tag.dto.TagDto;
import com.project.moviepop.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewBoardDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "내용을 채우세요")
        private String title;
        @NotBlank(message = "내용을 채우세요")
        private String review;
        @NotNull
        private Long movieId;
        @NotNull
        private List<TagDto.ReviewBoardRequest> tags;
    }


    @Getter
    @Setter
    public static  class Patch {
        private long reviewBoardId;
        @NotBlank(message = "내용을 채우세요")
        private String title;
        @NotBlank(message = "내용을 채우세요")
        private String movieTitle;
        @NotBlank(message = "내용을 채우세요")
        private String review;
        private List<TagDto.ReviewBoardRequest> tags;
    }

    @Getter
    @Builder
    public static class Response {
        private long reviewBoardId;
        private String title;
        private String review;
        private int wish;
        private String thumbnail;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        private LocalDateTime createdAt;

        private List<TagDto.response> tags;

        private UserDto.ReviewBoardResponse user;
        //추후 추가
    }
}
