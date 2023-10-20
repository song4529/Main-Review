package com.project.moviepop.user.mapper;

import com.project.moviepop.user.dto.UserDto;
import com.project.moviepop.user.entity.User;

public interface UserMapper {
    User userPostDtoToUser(UserDto.Post userPostDto);
}