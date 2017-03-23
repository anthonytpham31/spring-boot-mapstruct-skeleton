package cooksys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.dto.DisplayDto;
import cooksys.dto.TagsDto;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Tweet;
import cooksys.mapper.TweetMapper;
import cooksys.repository.TweetRepository;

@Service
public class TweetService {

	TweetRepository tweetRepository;
	TweetMapper tweetMapper;
	ServiceUtilities serviceUtilities;
	IdChecker idChecker;
	
	public TweetService(TweetRepository tweetRepository, TweetMapper tweetMapper, ServiceUtilities serviceUtilities) {
		super();
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
		this.serviceUtilities = serviceUtilities;
		this.idChecker = serviceUtilities.buildIdChecker(Tweet.class, this::has);
	}
	
	public boolean has(Long id) {
		if(id != null)
			return tweetRepository.exists(id);
		return false;
	}
	
	public List<TweetDto> index() {
		return tweetRepository
				.findAll()
				.stream()
				.map(tweetMapper::toTweetDto)
				.collect(Collectors.toList());
	}

	public TweetDto get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public DisplayDto post(TweetDto tweetDto) {
		Tweet newTweet = tweetMapper.toTweet(tweetDto);
		// TODO Mentions & Hashtags (insert in constructor)
		tweetRepository.saveAndFlush(newTweet);
		return null;
	}

	public Long delete(Long id) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public void likeTweet(Long id) {
		// TODO Auto-generated method stub
		// Redo variables
		
	}

	public Long replyTweet(Long id) {
		return null;
		// TODO Auto-generated method stub
		// Redo variables
	}

	public Long repostTweet(Long id) {
		return null;
		// TODO Auto-generated method stub
		// Redo variables
	}

	public List<TagsDto> getTagsOfTweet(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsersDto> getUsersOfLikes(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TweetDto> getContext(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TweetDto> getTweetReplies(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TweetDto> getTweetReposts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsersDto> getTweetMentions(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
