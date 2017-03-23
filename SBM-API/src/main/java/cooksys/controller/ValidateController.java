package cooksys.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cooksys.service.ValidateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@RequestMapping("validate")
@Api(tags = {"public", "validate"})
public class ValidateController {
	
	private ValidateService validateService;
	
	public ValidateController(ValidateService validateService) {
		super();
		this.validateService = validateService;
	}

	@GetMapping("tag/exists/{label}")
	@ApiOperation(value = "", nickname = "tagExist")
	public boolean checkTag(@PathVariable Long id) {
		return false;
	}
	
	@GetMapping("username/exists/@{username}")
	@ApiOperation(value = "", nickname = "tagExist")
	public boolean checkUserExist(@PathVariable String username) {
		return validateService.checkUserExist(username);
	}
	
	@GetMapping("username/available/@{username}")
	@ApiOperation(value = "", nickname = "tagExist")
	public boolean checkUserAvailable(@PathVariable String username) {
		return validateService.checkUserAvailable(username);
	}
}
