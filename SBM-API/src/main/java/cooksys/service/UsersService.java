package cooksys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersCreationDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Users;
import cooksys.mapper.UsersCreationMapper;
import cooksys.mapper.UsersMapper;
import cooksys.repository.UsersRepository;

@Service
public class UsersService {

	private final UsersRepository userRepository;
	private final UsersMapper userMapper;
	private final UsersCreationMapper userCreationMapper;
	private final ServiceUtilities serviceUtilities;
	private final IdChecker idChecker;
	
	public UsersService(UsersRepository userRepository, UsersMapper userMapper, UsersCreationMapper userCreationMapper, ServiceUtilities serviceUtilities) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.userCreationMapper = userCreationMapper;
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
				.findByDeletedUsers(0)
				.stream()
				.map(userMapper::toUsersDto)
				.collect(Collectors.toList());
	}

	public Long post(UsersCreationDto usersDto) {
		Users newUser = userCreationMapper.toUsers(usersDto);
		newUser.setDeletedUsers(0);
		return userRepository.saveAndFlush(newUser).getId();
	}

	public UsersDto getUser(String username) {
		return userMapper.toUsersDto(userRepository.findByUserCredsName(username));
		
	}

	public UsersDto patchUser(UsersCreationDto usersDto) {
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
