package com.project.moviepop.tag.mapper;

import com.project.moviepop.tag.dto.TagDto;
import com.project.moviepop.tag.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    List<TagDto.response> tagsToResponse(List<Tag> tags);
}
