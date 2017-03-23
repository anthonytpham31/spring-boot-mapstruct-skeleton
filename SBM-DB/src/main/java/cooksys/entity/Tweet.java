package cooksys.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import cooksys.entity.superclass.BaseEntity;

@Entity
public class Tweet implements BaseEntity<Long>{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Users author;
	
	private Date posted;
	
	private String content;
	
	@OneToOne
	private Tweet inReplyTo;
	
	@OneToOne
	private Tweet repostOf;
	
	@OneToMany
	private List<Users> usersLiked;
	
	@OneToMany
	private List<Tweet> allReplies;
	
	@OneToMany
	private List<Tweet> allReposts;
	
	@ManyToMany(mappedBy = "userMentioned")
	private List<Users> usersMentionedInTweet;
	
	private boolean deletedTweet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public Tweet getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Tweet repostOf) {
		this.repostOf = repostOf;
	}

	public Tweet getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(Tweet inReplyTo) {
		this.inReplyTo = inReplyTo;
	}
	
	public List<Tweet> getAllReplies() {
		return allReplies;
	}

	public void setAllReplies(List<Tweet> allReplies) {
		this.allReplies = allReplies;
	}

	public List<Tweet> getAllReposts() {
		return allReposts;
	}

	public void setAllReposts(List<Tweet> allReposts) {
		this.allReposts = allReposts;
	}

	public boolean isDeletedTweet() {
		return deletedTweet;
	}

	public void setDeletedTweet(boolean deletedTweet) {
		this.deletedTweet = deletedTweet;
	}

	public List<Users> getUsersMentionedInTweet() {
		return usersMentionedInTweet;
	}

	public void setUsersMentionedInTweet(List<Users> usersMentionedInTweet) {
		this.usersMentionedInTweet = usersMentionedInTweet;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public List<Users> getUsersLiked() {
		return usersLiked;
	}

	public void setUsersLiked(List<Users> usersLiked) {
		this.usersLiked = usersLiked;
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
		Tweet other = (Tweet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}
	
	@PrePersist
	protected void onCreate() {
		posted = new Date();
	}
}
