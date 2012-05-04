package de.adorsys.tweetitgui.model;

public class User {
	
	private String userId;
	
	private String nickname;
	
	private Boolean followUser;
	
	

	public User(String userId, String nickname, Boolean followUser) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.followUser = followUser;
	}
	
	

	public User() {
		super();
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getFollowUser() {
		return followUser;
	}

	public void setFollowUser(Boolean followUser) {
		this.followUser = followUser;
	}


	
	

}
