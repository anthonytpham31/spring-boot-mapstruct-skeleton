package cooksys.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.dto.TagsDto;
import cooksys.dto.TweetDto;
import cooksys.service.TagsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("tags")
@Api(tags = {"public", "Tags"})
public class TagsController {
	
	private TagsService tagsService;

	public TagsController(TagsService tagsService) {
		super();
		this.tagsService = tagsService;
	}
	
	@GetMapping
	@ApiOperation(value = "", nickname = "getTags")
	public List<TagsDto> index() {
		return tagsService.index();
	}
	
	@GetMapping("{label}")
	@ApiOperation(value = "", nickname = "getTweetsOfTag")
	public List<TweetDto> getTweetsWTag(@PathVariable String label) {
		return tagsService.getTweetsWTag(label);
	}
}
