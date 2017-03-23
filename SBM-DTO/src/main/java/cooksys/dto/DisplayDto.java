package cooksys.dto;

import java.util.Date;

public class DisplayDto {
	
	private Long id;
	
	private UsersDto author;
	
	private Date timestamp;
	
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
