package cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cooksys.dto.DisplayDto;
import cooksys.dto.TweetDto;
import cooksys.entity.Tweet;

@Mapper(componentModel = "spring", uses = {TweetMapper.class, UsersMapper.class})
public interface DisplayMapper {
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "posted", target = "timestamp"),
		@Mapping(source = "content", target = "content")
	})
	DisplayDto toDisplayDto(Tweet tweet);
	
	@Mappings({
		@Mapping(source = "content", target = "content")
	})
	DisplayDto fromTweetDto(TweetDto tweetDto);
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "timestamp", target = "posted"),
		@Mapping(source = "content", target = "content")
	})
	Tweet toTweet(DisplayDto displayDto);
}
