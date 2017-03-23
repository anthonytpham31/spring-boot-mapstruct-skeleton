package cooksys.dto;

import java.util.Date;

import cooksys.entity.Users;

public class RepostDto {
	
	private Long id;
	
	private UsersDto author;
	
	private Date timestamp;
	
	private TweetDto repost;
}
