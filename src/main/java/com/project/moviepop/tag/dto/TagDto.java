package com.project.moviepop.tag.dto;

import lombok.Getter;

public class TagDto {

    @Getter
    public static class response {
        private long tagId;
        private String tagName;
    }

    @Getter
    public static class ReviewBoardRequest {
        private long tagId;
    }

    @Getter
    public static class UserRequest {
        private long tagId;
    }
}