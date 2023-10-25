package com.project.moviepop.tag.controller;

import com.project.moviepop.dto.ResponseDto;
import com.project.moviepop.tag.mapper.TagMapper;
import com.project.moviepop.tag.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
@Validated
@AllArgsConstructor
public class TagController {
    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity getAllTags() {
        return new ResponseEntity<>(new ResponseDto.SingleResponseDto(tagMapper.tagsToResponse(tagService.getTags())), HttpStatus.OK);
    }
}
