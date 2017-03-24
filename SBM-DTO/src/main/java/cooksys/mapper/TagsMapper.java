package cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cooksys.dto.TagsDto;
import cooksys.entity.Tags;

@Mapper(componentModel = "spring")
public interface TagsMapper {
	
	@Mappings({
		@Mapping(source = "label", target = "label"),
		@Mapping(source = "firstUsed", target = "firstUsed"),
		@Mapping(source = "lastUsed", target = "lastUsed")
	})
	TagsDto toTagDto(Tags tags);
	
	@Mappings({
		@Mapping(source = "label", target = "label"),
		@Mapping(source = "firstUsed", target = "firstUsed"),
		@Mapping(source = "lastUsed", target = "lastUsed")
	})
	Tags toTag(TagsDto tagsDto);
}
