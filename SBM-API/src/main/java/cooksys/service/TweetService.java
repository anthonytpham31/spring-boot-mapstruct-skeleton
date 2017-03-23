package cooksys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
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
	
	public static List<TweetDto> index() {
		// TODO Auto-generated method stub
		return null;
	}

	public TweetDto get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long post(TweetDto tweetDto) {
		// TODO Auto-generated method stub
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
