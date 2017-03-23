package cooksys.dto;

import java.util.Date;

import cooksys.entity.Users;

public class TweetDto {
	
	private CredentialsDto credentials;
	
	private String content;

	public CredentialsDto getCredentials() {
		return credentials;
	}

	public void setCredentials(CredentialsDto credentials) {
		this.credentials = credentials;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
