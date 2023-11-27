package com.project.moviepop.user.repository;

import com.project.moviepop.user.entity.MoviePartyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePartyUserRepository extends JpaRepository<MoviePartyUser, Long> {
}
