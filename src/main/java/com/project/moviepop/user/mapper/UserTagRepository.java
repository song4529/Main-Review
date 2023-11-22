package com.project.moviepop.user.mapper;

import com.project.moviepop.user.entity.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTagRepository extends JpaRepository<UserTag, Long> {
}
