package cooksys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.dto.CredentialsDto;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersCreationDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Tweet;
import cooksys.entity.Users;
import cooksys.entity.embeddable.Credentials;
import cooksys.entity.embeddable.Profile;
import cooksys.mapper.TweetMapper;
import cooksys.mapper.UsersMapper;
import cooksys.repository.UsersRepository;

@Service
public class UsersService {
	
	private final ValidateService valid;
	private final UsersRepository userRepository;
	private final UsersMapper userMapper;
	private final TweetMapper tweetMapper;
	
	
	public UsersService(TweetMapper tweetMapper, ValidateService valid, UsersRepository userRepository, UsersMapper userMapper) {
		super();
		this.valid = valid;
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.tweetMapper = tweetMapper;
	}

	public boolean has(Long id) {
		if(id != null)
			return userRepository.exists(id);
		return false;
	}

	public List<UsersDto> index() {
		return userRepository
				.findByDeletedUsers(false)
				.stream()
				.map(userMapper::toUsersDto)
				.collect(Collectors.toList());
	}

	public UsersDto post(UsersCreationDto usersDto) {
		Users newUser = userMapper.fromCreation(usersDto);
		newUser.setDeletedUsers(false);
		return userMapper.toUsersDto(userRepository.saveAndFlush(newUser));
	}

	public UsersDto getUser(String username) {
		return userMapper.toUsersDto(userRepository.findByUserCredsName(username));
		
	}

	public UsersDto patchUser(CredentialsDto creds, Profile profile) {
		
		Users newUser = userRepository.findByUserCredsName(creds.getUsername());
		if(newUser != null){
			newUser.setUserProfile(profile);
			return userMapper.toUsersDto(userRepository.saveAndFlush(newUser));
		} else {
			return null;
		}
			
	}

	public UsersDto delete(String userName) {
		Users newUser = userRepository.findByUserCredsName(userName);
		newUser.setDeletedUsers(true);
		return userMapper.toUsersDto(userRepository.saveAndFlush(newUser));
	}

	public void followUser(Credentials cred, String username) {
		
		Users followingUser = userRepository.findByUserCredsName(cred.getName());
		Users userFollowed = userRepository.findByUserCredsName(username);
		
		if(followingUser != null && valid.checkUserExist(username)) {
			followingUser.getUsersFollowed().add(userFollowed);
			userFollowed.getFollowingUser().add(followingUser);
		}
	}

	public void unfollowUser(Credentials cred, String username) {
		
		Users followingUser = userRepository.findByUserCredsName(cred.getName());
		Users userFollowed = userRepository.findByUserCredsName(username);
		
		if(followingUser != null && valid.checkUserExist(username)) {
			followingUser.getUsersFollowed().remove(userFollowed);
			userFollowed.getFollowingUser().remove(followingUser);
		}	
	}

	public List<TweetDto> getUserFeed(String username) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public List<TweetDto> getUserTweets(String username) {
		Users user = userRepository.findByUserCredsName(username);
		List<TweetDto> tweetList = new ArrayList<>();
		List<Tweet> userTweetList = user.getUserTweets();
		for(Tweet tweet : userTweetList) {
			tweetList.add(tweetMapper.toTweetDto(tweet));
		}
		
		return tweetList;
	}

	public List<TweetDto> getUserMentions(String username) {
		Users user = userRepository.findByUserCredsName(username);
		List<TweetDto> tweetList = new ArrayList<>();
		List<Tweet> userTweetList = user.getUserMentioned();
		for(Tweet tweet : userTweetList) {
			tweetList.add(tweetMapper.toTweetDto(tweet));
		}
		
		return tweetList;
		
	}

	public List<UsersDto> getUserFollowers(String username) {
		
		Users userList = userRepository.findByUserCredsName(username);
		List<Users> list = userList.getFollowingUser();
		List<UsersDto> addedList = new ArrayList<>();
		for(Users user : list) {
			if(!user.getDeletedUsers()){
				addedList.add(userMapper.toUsersDto(user));
			}
		}
		return addedList;
	}

	public List<UsersDto> getUserFollowing(String username) {
		
		Users userList = userRepository.findByUserCredsName(username);
		List<Users> list = userList.getUsersFollowed();
		List<UsersDto> addedList = new ArrayList<>();
		for(Users user : list) {
			if(!user.getDeletedUsers()){
				addedList.add(userMapper.toUsersDto(user));
			}
		}
		return addedList;
	}
	
}
