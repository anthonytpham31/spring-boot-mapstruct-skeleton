package cooksys.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import cooksys.entity.embeddable.Credentials;
import cooksys.entity.embeddable.Profile;
import cooksys.entity.superclass.BaseEntity;

@Entity
@Table(name = "people")
public class Users implements BaseEntity<Long> {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Profile userProfile;
	
	private Date dateCreated;
	
	private Credentials userCreds;
	
	@OneToMany
	private List<Tweet> userTweets;
	
	@ManyToMany
	private List<Users> followingUser;
	
	@ManyToMany (mappedBy = "followingUser")
	private List<Users> usersFollowed;
	
	@ManyToMany
	private List<Tweet> userMentioned;
	
	private boolean deletedUsers;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		
	}
	
	public Profile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}

	public Credentials getUserCreds() {
		return userCreds;
	}

	public void setUserCreds(Credentials userCreds) {
		this.userCreds = userCreds;
	}

	public List<Tweet> getUserTweets() {
		return userTweets;
	}

	public void setUserTweets(List<Tweet> userTweets) {
		this.userTweets = userTweets;
	}

	public List<Users> getFollowingUser() {
		return followingUser;
	}

	public void setFollowingUser(List<Users> followingUser) {
		this.followingUser = followingUser;
	}

	public List<Users> getUsersFollowed() {
		return usersFollowed;
	}

	public void setUsersFollowed(List<Users> usersFollowed) {
		this.usersFollowed = usersFollowed;
	}

	public List<Tweet> getUserMentioned() {
		return userMentioned;
	}

	public void setUserMentioned(List<Tweet> userMentioned) {
		this.userMentioned = userMentioned;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Users other = (Users) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean getDeletedUsers() {
		return deletedUsers;
	}

	public void setDeletedUsers(boolean deletedUsers) {
		this.deletedUsers = deletedUsers;
	}

	@PrePersist
	protected void onCreate() {
		dateCreated = new Date();
	}

}
