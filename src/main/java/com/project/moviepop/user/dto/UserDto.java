package com.project.moviepop.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {
    @Getter
    @AllArgsConstructor
    public static class Post{
        @NotBlank
        @Email
        private String email;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch{
    }

    @Getter
    @AllArgsConstructor
    public static class PatchPassword{
    }

    @Getter
    @AllArgsConstructor
    public static class Response{
    }
}
