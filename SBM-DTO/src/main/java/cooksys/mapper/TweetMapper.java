package cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cooksys.dto.DisplayDto;
import cooksys.dto.ReplyDto;
import cooksys.dto.RepostDto;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersDto;
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
	Tweet fromDisplayDto(DisplayDto displayDto);
	
	@Mappings({
		@Mapping(source = "id", target = "reply.id"),
		@Mapping(source = "author", target = "reply.author"),
		//@Mapping(source = "posted", target = "reply.posted"),
		@Mapping(source = "content", target = "reply.content")
	})
	ReplyDto toReplyDto(Tweet tweet);
	
	@Mappings({
		@Mapping(source = "id", target = "repost.id"),
		@Mapping(source = "author", target = "repost.author"),
		//@Mapping(source = "posted", target = "repost.posted"),
		@Mapping(source = "content", target = "repost.content")
	})
	RepostDto toRepostDto(Tweet tweet);
}
