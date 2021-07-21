package cooksys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.dto.DisplayDto;
import cooksys.dto.ReplyDto;
import cooksys.dto.RepostDto;
import cooksys.dto.TagsDto;
import cooksys.dto.TweetDto;
import cooksys.dto.UsersDto;
import cooksys.entity.Tags;
import cooksys.entity.Tweet;
import cooksys.entity.Users;
import cooksys.entity.embeddable.Credentials;
import cooksys.mapper.TweetMapper;
import cooksys.mapper.UsersMapper;
import cooksys.repository.TagsRepository;
import cooksys.repository.TweetRepository;
import cooksys.repository.UsersRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TweetService {
	
	TagsRepository tagRepository;
	UsersRepository userRepository;
	TweetRepository tweetRepository;
	TweetMapper tweetMapper;
	UsersMapper userMapper;
	
	public TweetService(TagsRepository tagRepository, UsersRepository userRepository, TweetRepository tweetRepository,
			TweetMapper tweetMapper, UsersMapper userMapper) {
		super();
		this.tagRepository = tagRepository;
		this.userRepository = userRepository;
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
		this.userMapper = userMapper;
	}

	public List<DisplayDto> index() {
		return tweetRepository
				.findByDeletedTweet(false)
				.stream()
				.map(tweetMapper::toDisplayDto)
				.collect(Collectors.toList());
	}

	public DisplayDto get(Long id) {
		return tweetMapper.toDisplayDto(tweetRepository.findOne(id));
	}

	@Transactional
	public DisplayDto post(TweetDto tweetDto) {
		
		Tweet newTweet = tweetMapper.toTweet(tweetDto);
		newTweet.setDeletedTweet(false);
		
		String[] parts = tweetDto.getContent().split(" ");
		Tags newLabel = new Tags();
		String username = new String();
		
		for(String words : parts) {
			
			
			if(words.charAt(0) == '#') {
				newLabel.setLabel(words.substring(1));
				System.out.println(newLabel.getLabel());
				tagRepository.save(newLabel);
				
			} else if (words.charAt(0) == '@') {
				username = words.substring(1);
				System.out.println(username);
				Users mentioned = userRepository.findByUserCredsName(username);
				System.out.println(username);
				System.out.println(mentioned);
				if(mentioned != null && newTweet.getUsersMentionedInTweet() != null) {
					newTweet.getUsersMentionedInTweet().add(mentioned);
					mentioned.getUserMentioned().add(newTweet);
					userRepository.save(mentioned);
				}		
			}
		}
		return tweetMapper.toDisplayDto(tweetRepository.saveAndFlush(newTweet));
	}

	@Transactional
	public DisplayDto delete(Long id) {
		Tweet newTweet = tweetRepository.findOne(id);
		newTweet.setDeletedTweet(true);
		return tweetMapper.toDisplayDto(tweetRepository.saveAndFlush(newTweet));

	}

	public void likeTweet(Long id, Credentials cred) {
		Users likedUser = userRepository.findByUserCredsName(cred.getName());
		Tweet likedTweet = tweetRepository.findOne(id);
		likedTweet.getUsersLiked().add(likedUser);
		
	}

	@Transactional
	public ReplyDto replyTweet(Long id, TweetDto tweetDto) {
		
		Tweet oldTweet = tweetRepository.findOne(id);
		Tweet newTweet = tweetMapper.toTweet(tweetDto);
		newTweet.setInReplyTo(oldTweet);
		oldTweet.getAllReplies().add(newTweet);
		tweetRepository.saveAndFlush(oldTweet);
		
		String[] parts = tweetDto.getContent().split(" ");
		
		for(String words : parts) {
			Tags newLabel = new Tags();
			String username = new String();
			
			if(words.charAt(0) == '#') {
				newLabel.setLabel(words.substring(1));
				newLabel.getTweetedTags().add(newTweet);
				tagRepository.save(newLabel);
				
			} else if (words.charAt(0) == '@') {
				username = words.substring(1);
				Users mentioned = userRepository.findByUserCredsName(username);
				
				if(mentioned != null) {
					mentioned.getUserMentioned().add(newTweet);
					userRepository.save(mentioned);
				}		
			}
		}
		
		return tweetMapper.toReplyDto(tweetRepository.saveAndFlush(newTweet));
	}

	@Transactional
	public RepostDto repostTweet(Long id, TweetDto tweetDto) {
		
		Tweet oldTweet = tweetRepository.findOne(id);
		Tweet newTweet = tweetMapper.toTweet(tweetDto);
		newTweet.setRepostOf(oldTweet);
		oldTweet.getAllReposts().add(oldTweet);
		tweetRepository.saveAndFlush(oldTweet);
		return tweetMapper.toRepostDto(tweetRepository.saveAndFlush(newTweet));
	}

	public List<TagsDto> getTagsOfTweet(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsersDto> getUsersOfLikes(Long id) {
		Tweet noLongerThinknStraight = tweetRepository.findOne(id);
		List<Users> usersLiked = noLongerThinknStraight.getUsersLiked();
		List<UsersDto> userDisp = new ArrayList<>();
		for(Users user : usersLiked) {
			userDisp.add(userMapper.toUsersDto(user));
		}
		return userDisp;
	}

	public List<TweetDto> getContext(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TweetDto> getTweetReplies(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TweetDto> getTweetReposts(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsersDto> getTweetMentions(Long id) {
		Tweet tweetMention = tweetRepository.findOne(id);
		List<UsersDto> tweetList = new ArrayList<>();
		List<Users> userTweetList = tweetMention.getUsersMentionedInTweet();
		for(Users user : userTweetList) {
			tweetList.add(userMapper.toUsersDto(user));
		}
		
		return tweetList;
		
	}

}
