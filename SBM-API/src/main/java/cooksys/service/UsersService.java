package cooksys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Users;
import cooksys.mapper.UsersMapper;
import cooksys.repository.UsersRepository;

@Service
public class UsersService {

	UsersRepository userRepository;
	UsersMapper userMapper;
	ServiceUtilities serviceUtilities;
	IdChecker idChecker;
	
	public UsersService(UsersRepository userRepository, UsersMapper userMapper, ServiceUtilities serviceUtilities) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.serviceUtilities = serviceUtilities;
		this.idChecker = serviceUtilities.buildIdChecker(Users.class, this::has);
	}
	
	public boolean has(Long id) {
		if(id != null)
			return userRepository.exists(id);
		return false;
	}

	public static List<UsersDto> index() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long post(UsersDto usersDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long patchUser(UsersDto usersDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void followUser(UsersDto userDto) {
		// TODO Auto-generated method stub
		
	}

	public void unfollowUser(UsersDto userDto) {
		// TODO Auto-generated method stub
		
	}

	public List<TweetDto> getUserFeed(UsersDto userDto) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public List<TweetDto> getUserTweets(UsersDto userDto) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public List<TweetDto> getUserMentions(UsersDto userDto) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public List<UsersDto> getUserFollowers(UsersDto userDto) {
		return null;
		// TODO Auto-generated method stub
		
	}

	public List<UsersDto> getUserFollowing(UsersDto userDto) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
}
