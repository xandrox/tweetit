package de.adorsys.tweetitgui.model;

public class FollowingUser {
	
	private String userId;
	
	private String nickname;
	
	private Boolean followUser;
	
	

	public FollowingUser(String userId, String nickname, Boolean followUser) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.followUser = followUser;
	}
	
	

	public FollowingUser() {
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
