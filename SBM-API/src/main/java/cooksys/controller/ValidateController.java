package cooksys.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.service.TagsService;
import cooksys.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("validate")
@Api(tags = {"public", "validate"})
public class ValidateController {
	
	private UsersService userService;
	
	private TagsService tagService;

	public ValidateController(UsersService userService, TagsService tagService) {
		super();
		this.userService = userService;
		this.tagService = tagService;
	}
	
	@GetMapping("tag/exists/{label}")
	@ApiOperation(value = "", nickname = "tagExist")
	public boolean checkTag(Long id) {
		if(tagService.has(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("username/exists/@{username}")
	@ApiOperation(value = "", nickname = "tagExist")
	public boolean checkUserExist(Long id) {
		if(userService.has(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("username/available/@{username}") //TODO Might have a second table to show
	@ApiOperation(value = "", nickname = "tagExist")
	public boolean checkUserAvailable(Long id) {
		if(userService.has(id)) {
			return true;
		} else {
			return false;
		}
	}
}
