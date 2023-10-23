package com.project.moviepop.user.entity;


import com.project.moviepop.reviewboard.entity.ReviewBoard;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //매핑
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReviewBoard> reviewBoards = new ArrayList<>();
}
