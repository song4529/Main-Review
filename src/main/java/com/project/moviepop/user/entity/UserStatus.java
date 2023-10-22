package com.project.moviepop.user.entity;

import lombok.Getter;

public enum UserStatus {
    USER_ACTIVE ("활동중인 계정"),
    USER_SLEEP ("휴면 계정"),
    USER_WITHDRAW("탈퇴한 계정");

    @Getter
    private String status;

    UserStatus(String status) {
        this.status = status;
    }
}