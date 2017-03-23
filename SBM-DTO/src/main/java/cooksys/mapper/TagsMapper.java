package cooksys.mapper;

import org.mapstruct.Mapper;

import cooksys.dto.TagsDto;
import cooksys.entity.Tags;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface TagsMapper {
	
	TagsDto toTagDto(Tags tags);
	
	Tags toTag(TagsDto tagsDto);
}
