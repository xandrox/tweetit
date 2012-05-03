package de.adorsys.tweetit.server.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class User implements java.io.Serializable {


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Column
	@Id
	private String userId;

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<User> followUsers = new HashSet<User>();

	public Collection<User> getFollowUsers() {
		return followUsers;
	}

	public void setFollowUsers(Collection<User> followUser) {
		this.followUsers = followUser;
	}

	@Column
	private String nickname;

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(final String nickname) {
		this.nickname = nickname;
	}

	public String toString() {
		String result = "";
		if (userId != null && !userId.trim().isEmpty())
			result += userId;
		if (nickname != null && !nickname.trim().isEmpty())
			result += " " + nickname;
		return result;
	}
}