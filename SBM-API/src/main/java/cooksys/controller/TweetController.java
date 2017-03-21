package cooksys.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Validated
@RequestMapping("tweet")
@Api(tags = {"public", "tweets"})
public class TweetController {

}
