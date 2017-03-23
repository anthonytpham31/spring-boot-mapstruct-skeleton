package cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cooksys.dto.RepostDto;
import cooksys.entity.Tweet;

@Mapper(componentModel = "spring", uses = {TweetMapper.class, UsersMapper.class})
public interface RepostMapper {
	
	@Mappings({
		@Mapping(source = "id", target = "repost.id"),
		@Mapping(source = "author", target = "repost.author"),
		//@Mapping(source = "posted", target = "repost.posted"),
		@Mapping(source = "content", target = "repost.content")
	})
	RepostDto toRepostDto(Tweet tweet);
}
