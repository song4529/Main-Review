package com.project.moviepop.security.filter;

import com.project.moviepop.security.jwt.JwtTokenizer;
import com.project.moviepop.security.redis.repository.LogoutAccessTokenRedisRepository;
import com.project.moviepop.security.userdetails.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenizer jwtTokenizer;
    private final CustomUserDetailService customUserDetailService;
    private final LogoutAccessTokenRedisRepository logoutAccessTokenRedisRepository;
}
