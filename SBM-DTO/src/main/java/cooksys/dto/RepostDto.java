package cooksys.dto;

import java.util.Date;

import cooksys.entity.Users;

public class RepostDto {
	
	private Long id;
	
	private UsersDto author;
	
	private Date timestamp;
	
	private TweetDto repost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsersDto getAuthor() {
		return author;
	}

	public void setAuthor(UsersDto author) {
		this.author = author;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public TweetDto getRepost() {
		return repost;
	}

	public void setRepost(TweetDto repost) {
		this.repost = repost;
	}
	
}
