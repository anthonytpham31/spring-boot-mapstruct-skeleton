package cooksys.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Validated
@RequestMapping("users")
@Api(tags = {"public", "users"})
public class UsersController {

}
