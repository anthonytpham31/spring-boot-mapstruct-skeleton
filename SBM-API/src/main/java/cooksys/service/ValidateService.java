package cooksys.service;

import org.springframework.stereotype.Service;

import cooksys.entity.Users;
import cooksys.repository.TagsRepository;
import cooksys.repository.TweetRepository;
import cooksys.repository.UsersRepository;

@Service
public class ValidateService {
	
	TagsRepository tagRepository; 
	TweetRepository tweetRepository;
	UsersRepository userRepository;
	
	public ValidateService(TagsRepository tagRepository, TweetRepository tweetRepository, UsersRepository userRepository) {
		super();
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
		this.tagRepository = tagRepository;
	}
	
	public boolean checkTag(String label) {
		if(tagRepository.findByLabel(label) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkUserExist(String username) {
		if(userRepository.findByUserCredsName(username) != null){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean checkUserAvailable(String username) {
		Users newUser = userRepository.findByUserCredsName(username);
		if(newUser != null && newUser.getDeletedUsers()) {
			return false;
		} else {
			return true;
		}
	}
}
