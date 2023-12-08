package com.project.moviepop.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userTagId;
}
