package cooksys.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.dto.TweetDto;
import cooksys.dto.UsersCreationDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Users;
import cooksys.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("users")
@Api(tags = {"public", "users"})
public class UsersController {
	
	private UsersService userService;
	
	public UsersController(UsersService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	@ApiOperation(value = "", nickname = "getAllUsers")
	public List<UsersDto> index() {
		return userService.index();
	}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postUser")
	public Long post(@RequestBody UsersCreationDto usersDto, HttpServletResponse httpResponse) {
		Long id = userService.post(usersDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return id;
	}
	
	@GetMapping("@{username}")
	@ApiOperation(value = "", nickname = "findUser")
	public UsersDto getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	@PatchMapping("@{username}") // TODO
	@ApiOperation(value = "", nickname = "patchUser")
	public UsersDto patchUser(@RequestBody @Validated UsersCreationDto usersDto, HttpServletResponse httpResponse) {
		UsersDto patched = userService.patchUser(usersDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return patched;
	}
	
	@DeleteMapping("@{username}") //TODO
	@ApiOperation(value = "", nickname = "deleteUser")
	public Long delete(@PathVariable Long id, HttpServletResponse httpResponse) {
		return userService.delete(id);
	}
	
	@PostMapping("@{username}/follow") //TODO
	@ApiOperation(value = "", nickname = "followUser")
	public void followUser(@PathVariable @Validated UsersDto userDto, HttpServletResponse httpResponse) {
		userService.followUser(userDto);
	}
	
	@PostMapping("@{username}/unfollow") //TODO
	@ApiOperation(value = "", nickname = "unfollowUser")
	public void unfollowUser(@PathVariable @Validated UsersDto userDto, HttpServletResponse httpResponse) {
		userService.unfollowUser(userDto);
	}
	
	@GetMapping("@{username}/feed") //TODO
	@ApiOperation(value = "", nickname = "UserFeed")
	public List<TweetDto> getUserFeed(@PathVariable UsersDto userDto) {
		return userService.getUserFeed(userDto);
	}
	
	@GetMapping("@{username}/tweets") //TODO
	@ApiOperation(value = "", nickname = "UserTweets")
	public List<TweetDto> getUserTweets(@PathVariable UsersDto userDto) {
		return userService.getUserTweets(userDto);
	}
	
	@GetMapping("@{username}/mentions") //TODO
	@ApiOperation(value = "", nickname = "UserMentions")
	public List<TweetDto> getUserMentions(@PathVariable UsersDto userDto) {
		return userService.getUserMentions(userDto);
	}
	
	@GetMapping("@{username}/followers") //TODO
	@ApiOperation(value = "", nickname = "Userfollowers")
	public List<UsersDto> getUserFollowers(@PathVariable UsersDto userDto) {
		return userService.getUserFollowers(userDto);
	}
	
	@GetMapping("@{username}/following") //TODO
	@ApiOperation(value = "", nickname = "UserFollowing")
	public List<UsersDto> getUserFollowing(@PathVariable UsersDto userDto) {
		return userService.getUserFollowing(userDto);
	}
}
