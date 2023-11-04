package com.project.moviepop.movie.db;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MovieApi {
    public static Set<String> getMovieList() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Set<String> movieCodeSet = new HashSet<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5); // 동시 요청 수

        return null;
    }
}
