package com.project.moviepop.user.controller;


import com.project.moviepop.user.dto.UserDto;
import com.project.moviepop.user.entity.User;
import com.project.moviepop.user.mapper.UserMapper;
import com.project.moviepop.user.service.UserService;
import com.project.moviepop.utils.UriComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/users")
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final static String  USER_DEFAULT_URI = "/users";
    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping //회원가입
    public ResponseEntity postUser(@Valid @RequestBody UserDto.Post userPostDto) {
        //User를 userPostDto에서 받아온 정보를 통해서 user를 생성한다
        User user = userMapper.userPostDtoToUser(userPostDto);

        //user를 만드는 서비스가 필요하다
        User createUser = userService.creatUser(user);

        //사용자를 나타내는 URI를 생성
        URI uri = UriComponent.createUri(USER_DEFAULT_URI, createUser.getUserId());

        return null;
    }

    @PatchMapping("/{user-id}") //회원정보 수정
    public ResponseEntity patchUser(@PathVariable ("user-id") @Positive long userId,
                                    @Valid @RequestBody UserDto.Patch userPatchDto) {
        return null;
    }

    @PatchMapping("/{user-id}/password") //비밀번호 수정
    public ResponseEntity patchUserPassword(@PathVariable("user-id") @Positive long userId,
                                            @Valid @RequestBody UserDto.PatchPassword userPatchPasswordDto) {
        return null;
    }

    @GetMapping("/{user-id}") //특정 회원정보 조회
    public ResponseEntity getOtherUser(@PathVariable("user-id") @Positive long userId) {
        return null;
    }

    @DeleteMapping("{user-id}") //회원 삭제
    public ResponseEntity deleteUser(@PathVariable("user-id") @Positive long userId) {
        return null;
    }
}
