package com.project.moviepop.reviewboard.controller;

import com.project.moviepop.reviewboard.dto.ReviewBoardDto;
import com.project.moviepop.reviewboard.entity.ReviewBoard;
import com.project.moviepop.reviewboard.mapper.ReviewBoardMapper;
import com.project.moviepop.reviewboard.service.ReviewBoardService;
import com.project.moviepop.user.entity.User;
import com.project.moviepop.user.service.UserService;
import com.project.moviepop.utils.UriComponent;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RequestMapping("/reviewBoards")
@RestController
@Validated
@AllArgsConstructor
public class ReviewBoardController {
    private final static String REVIEW_BOARD_DEFAULT_URI = "/reviewBoards";
    private final ReviewBoardService reviewBoardService;
    private final ReviewBoardMapper reviewBoardMapper;
    private final UserService userService;

    @PostMapping("/{user-id}")
    public ResponseEntity postReviewBoard(@PathVariable("/user-id") @Positive long userId,
                                          @Valid @RequestBody ReviewBoardDto.Post post) {
        //유저에 대한 정보를 가져온다
        User user = userService.findUser(userId);
        //게시할 리뷰보드 생성
        ReviewBoard reviewBoard = reviewBoardService.createReviewBoard(post);
        //유저와의 매핑작업
        userService.addReviewBoard(user, reviewBoard);
        //URI 작업
        URI uri = UriComponent.createUri(REVIEW_BOARD_DEFAULT_URI, reviewBoard.getReviewBoardId());

        return ResponseEntity.created(uri).build();
    }

    @PatchMapping("/{review-id}/users/{user-id}")
    public ResponseEntity patchReviewBoard(@PathVariable("user-id") @Positive long userId,
                                           @PathVariable("review-id") @Positive long reviewId,
                                           @Valid @RequestBody ReviewBoardDto.Patch patch) {
        //수정할 리뷰보드 아이디를 set해준다
        patch.setReviewBoardId(reviewId);
        //수정할 리뷰보드 생성
        ReviewBoard reviewBoard = reviewBoardService.updateReviewBoard(userId, reviewBoardMapper.PatchToReviewBoard(patch));
        //리뷰보드 정보를 리턴할 Response를 Mapper를 통해서 생성해준다
        ReviewBoardDto.Response response = reviewBoardMapper.reviewBoardToResponse(reviewBoard);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getReviewBoard(@PathVariable("review-id") @Positive long reviewId) {
        return null;
    }

    @DeleteMapping("/{review-id}/users/{user-id}")
    public ResponseEntity deleteReviewBoard(@PathVariable("user-id") @Positive long userId,
                                            @PathVariable("review-id") @Positive long reviewId) {
        reviewBoardService.deleteReviewBoard(userId, reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
