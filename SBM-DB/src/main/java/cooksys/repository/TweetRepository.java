package cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.entity.Tweet;
import cooksys.entity.Users;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
	
	List<Tweet> findByDeletedTweet(boolean tracker);
}
