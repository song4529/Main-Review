package com.project.moviepop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class ResponseDto {
    @Getter
    @AllArgsConstructor
    public static class SingleResponseDto<T> {
        private T data;
    }

    @Getter
    public static class MultipleResponseDto<T> {
        private List<T> data;
        private PageInfo pageInfo;

        public MultipleResponseDto(List<T> data, PageInfo pageInfo) {
            this.data = data;
            this.pageInfo = pageInfo;
        }
    }
}
