package cooksys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cooksys.dto.HashTagDto;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersDto;

@Service
public class TweetService {

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

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void likeTweet(Long id) {
		// TODO Auto-generated method stub
		// Redo variables
		
	}

	public void replyTweet(Long id) {
		// TODO Auto-generated method stub
		// Redo variables
	}

	public void repostTweet(Long id) {
		// TODO Auto-generated method stub
		// Redo variables
	}

	public List<HashTagDto> getTagsOfTweet(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsersDto> getUsersOfLikes(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
