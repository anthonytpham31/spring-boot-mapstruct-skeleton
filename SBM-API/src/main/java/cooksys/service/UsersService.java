package cooksys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.dto.CredentialsDto;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersCreationDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Users;
import cooksys.entity.embeddable.Credentials;
import cooksys.entity.embeddable.Profile;
import cooksys.mapper.UsersMapper;
import cooksys.repository.UsersRepository;

@Service
public class UsersService {

	private final UsersRepository userRepository;
	private final UsersMapper userMapper;
	private final ServiceUtilities serviceUtilities;
	private final IdChecker idChecker;
	
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

	public UsersDto patchUser(Credentials creds, Profile profile) {
		
		Users newUser = userRepository.findByUserCredsName(creds.getName());
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
