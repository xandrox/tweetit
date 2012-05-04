package de.adorsys.tweetitgui.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TweetDTO {
	
	private String cdat;
	
	private String userId;
	
	@NotNull
	@Length(min=3, max=140)
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

	@Override
	public String toString() {
		return "TweetDTO [cdat=" + cdat + ", userId=" + userId + ", message="
				+ message + "]";
	}

}
