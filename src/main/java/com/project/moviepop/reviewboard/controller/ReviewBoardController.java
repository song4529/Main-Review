package com.project.moviepop.reviewboard.controller;

import com.project.moviepop.reviewboard.mapper.ReviewBoardMapper;
import com.project.moviepop.reviewboard.service.ReviewBoardService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reviewBoards")
@RestController
@Validated
@AllArgsConstructor
public class ReviewBoardController {
    private final static String REVIEW_BOARD_DEFAULT_URI = "/reviewBoards";
    private final ReviewBoardService reviewBoardService;
    private final ReviewBoardMapper reviewBoardMapper;
}
