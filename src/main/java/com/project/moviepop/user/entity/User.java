package com.project.moviepop.user.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = false, length = 100)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String password;

    private String profileImage;

    @Column(nullable = false)
    private String name;

    private String birth;

    private float star = 0;

    private UserStatus userStatus = UserStatus.USER_ACTIVE;

    //매핑 필요한 것들 보류
}
