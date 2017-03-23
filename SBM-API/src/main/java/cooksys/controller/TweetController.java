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

import cooksys.dto.DisplayDto;
import cooksys.dto.TagsDto;
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
		return tweetService.index();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "", nickname = "findTweet")
	public TweetDto get(@PathVariable Long id) {
		return tweetService.get(id);
	}
	
	@PostMapping
	@ApiOperation(value = "", nickname = "postTweet")
	public DisplayDto post(@RequestBody @Validated TweetDto tweetDto, HttpServletResponse httpResponse) {
		tweetService.post(tweetDto);
		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
		 
		return null;
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "", nickname = "deleteTweet")
	public Long delete(@PathVariable Long id, HttpServletResponse httpResponse) {
		return tweetService.delete(id);
	}
	
	@PostMapping("{id}/like")
	@ApiOperation(value = "", nickname = "likeTweet")
	public void likeTweet(@PathVariable Long id, HttpServletResponse httpResponse) {
		tweetService.likeTweet(id);
	}
	
	@PostMapping("{id}/reply")
	@ApiOperation(value = "", nickname = "replyTweet")
	public Long replyTweet(@PathVariable Long id, HttpServletResponse httpResponse) {
		return tweetService.replyTweet(id);
	}
	
	@PostMapping("{id}/repost")
	@ApiOperation(value = "", nickname = "repostTweet")
	public Long repostTweet(@PathVariable Long id, HttpServletResponse httpResponse) {
		return tweetService.repostTweet(id);
	}
	
	@GetMapping("{id}/tags") // TODO needs fixing
	@ApiOperation(value = "", nickname = "tagsInTweets")
	public List<TagsDto> getTagsOfTweet(@PathVariable Long id) {
		return tweetService.getTagsOfTweet(id);
	}
	
	@GetMapping("{id}/likes") // TODO needs fixing
	@ApiOperation(value = "", nickname = "likesOfTweets")
	public List<UsersDto> getUsersOfLikes(@PathVariable Long id) {
		return tweetService.getUsersOfLikes(id);
	}
	
	@GetMapping("{id}/context") // TODO
	@ApiOperation(value = "", nickname = "tweetContext")
	public List<TweetDto> getContext(@PathVariable Long id) {
		return tweetService.getContext(id);
	}
	
	@GetMapping("{id}/replies") //TODO
	@ApiOperation(value = "", nickname = "tweetReplies")
	public List<TweetDto> getTweetReplies(@PathVariable Long id) {
		return tweetService.getTweetReplies(id);
	}
	
	@GetMapping("{id}/reposts") //TODO
	@ApiOperation(value = "", nickname = "tweetReposts")
	public List<TweetDto> getTweetReposts(@PathVariable Long id) {
		return tweetService.getTweetReposts(id);
	}
	
	@GetMapping("{id}/mentions") //TODO
	@ApiOperation(value = "", nickname = "tweetMentions")
	public List<UsersDto> getTweetMentions(@PathVariable Long id) {
		return tweetService.getTweetMentions(id);
	}
}
