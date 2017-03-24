package cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cooksys.dto.DisplayDto;
import cooksys.dto.ReplyDto;
import cooksys.dto.RepostDto;
import cooksys.dto.TweetDto;
import cooksys.entity.Tweet;

@Mapper(componentModel = "spring", uses = {UsersMapper.class, CredentialsMapper.class})
public interface TweetMapper {
	
	@Mappings({
		@Mapping(source = "content", target = "content")
	})
	TweetDto toTweetDto(Tweet tweet);
	
	@Mappings({
		@Mapping(source = "content", target = "content")
	})
	Tweet toTweet(TweetDto tweetDto);
	
	
	// DisplayDto
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "posted", target = "timestamp"),
		@Mapping(source = "content", target = "content")
	})
	DisplayDto toDisplayDto(Tweet tweet);
	
	@Mappings({
		@Mapping(source = "content", target = "content")
		//@Mapping(source = "credentials.username", target = "author")
	})
	DisplayDto fromTweetDto(TweetDto tweetDto);
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "timestamp", target = "posted"),
		@Mapping(source = "content", target = "content")
	})
	Tweet fromDisplayDto(DisplayDto displayDto);
	
	// ReplyDto
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "posted", target = "timestamp"),
		@Mapping(source = "content", target = "content"),
		@Mapping(source = "inReplyTo", target = "reply")
	})
	ReplyDto toReplyDto(Tweet tweet);
	
	// RepostDto
	
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "author", target = "author"),
		@Mapping(source = "posted", target = "timestamp"),
		@Mapping(source = "repostOf", target = "repost")
	})
	RepostDto toRepostDto(Tweet tweet);
}
