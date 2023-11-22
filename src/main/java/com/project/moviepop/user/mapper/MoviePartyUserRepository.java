package com.project.moviepop.user.mapper;

import com.project.moviepop.user.entity.MoviePartyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePartyUserRepository extends JpaRepository<MoviePartyUser, Long> {
}
