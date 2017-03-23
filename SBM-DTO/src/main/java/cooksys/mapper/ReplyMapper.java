package cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cooksys.dto.ReplyDto;
import cooksys.dto.TweetDto;
import cooksys.entity.Tweet;

@Mapper(componentModel = "spring", uses = {TweetMapper.class, UsersMapper.class})
public interface ReplyMapper {
	
	@Mappings({
		@Mapping(source = "id", target = "reply.id"),
		@Mapping(source = "author", target = "reply.author"),
		//@Mapping(source = "posted", target = "reply.posted"),
		@Mapping(source = "content", target = "reply.content")
	})
	ReplyDto toReplyDto(Tweet tweet);
	
	TweetDto toTweetDto(ReplyDto replyDto);
}
