package cooksys.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.dto.HashTagDto;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersDto;
import cooksys.service.TweetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("tweet")
@Api(tags = {"public", "tweets"})
public class TweetController {
	
	private TweetService tweetService;
	
	public TweetController(TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}
	
	@GetMapping
	@ApiOperation(value = "", nickname = "getAllTweets")
	public List<TweetDto> index() {
		return TweetService.index();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "", nickname = "findTweet")
	public TweetDto get(@PathVariable Long id) {
		return tweetService.get(id);
	}
	
	@PostMapping("post")
	@ApiOperation(value = "", nickname = "postTweet")
	public Long post(@RequestBody @Validated TweetDto tweetDto, HttpServletResponse httpResponse) {
		Long id = tweetService.post(tweetDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		return id;
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "", nickname = "deleteTweet")
	public void delete(@PathVariable Long id, HttpServletResponse httpResponse) {
		tweetService.delete(id);
	}
	
	@PostMapping("{id}/like")
	@ApiOperation(value = "", nickname = "likeTweet")
	public void likeTweet(@PathVariable Long id, HttpServletResponse httpResponse) {
		tweetService.likeTweet(id);
	}
	
	@PostMapping("{id}/reply")
	@ApiOperation(value = "", nickname = "replyTweet")
	public void replyTweet(@PathVariable Long id, HttpServletResponse httpResponse) {
		tweetService.replyTweet(id);
	}
	
	@PostMapping("{id}/repost")
	@ApiOperation(value = "", nickname = "repostTweet")
	public void repostTweet(@PathVariable Long id, HttpServletResponse httpResponse) {
		tweetService.repostTweet(id);
	}
	
	@GetMapping("{id}/tags") // TODO needs fixing
	@ApiOperation(value = "", nickname = "tagsInTweets")
	public List<HashTagDto> getTagsOfTweet(Long id) {
		return tweetService.getTagsOfTweet(id);
	}
	
	@GetMapping("{id}/likes") // TODO needs fixing
	@ApiOperation(value = "", nickname = "likesOfTweets")
	public List<UsersDto> getUsersOfLikes(Long id) {
		return tweetService.getUsersOfLikes(id);
	}
	
	
}
