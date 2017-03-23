package cooksys.mapper;

import org.mapstruct.Mapper;

import cooksys.dto.TweetDto;
import cooksys.entity.Tweet;

@Mapper(componentModel = "spring", uses = {ReferenceMapper.class})
public interface TweetMapper {
	
	TweetDto toTweetDto(Tweet tweet);
	
	Tweet toTweet(TweetDto tweetDto);
}
