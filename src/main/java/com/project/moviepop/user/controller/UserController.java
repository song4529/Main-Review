package com.project.moviepop.user.controller;


import com.project.moviepop.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/users")
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserController {

    @PostMapping //회원가입
    public ResponseEntity postUser(@Valid @RequestBody UserDto.Post userPostDto) {
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
