package de.adorsys.tweetit.server.model;

import java.util.Date;

public class TweetDTO {
	
	private String cdat;
	
	private String userId;
	
	private String message;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCdat() {
		return cdat;
	}

	public void setCdat(String cdat) {
		this.cdat = cdat;
	}
	
	
	
	

}
