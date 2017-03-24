package cooksys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.dto.TagsDto;
import cooksys.dto.TweetDto;
import cooksys.entity.Tags;
import cooksys.entity.Tweet;
import cooksys.mapper.TagsMapper;
import cooksys.mapper.TweetMapper;
import cooksys.repository.TagsRepository;

@Service
public class TagsService {
	
	TagsRepository tagRepository;
	TagsMapper tagMapper;
	TweetMapper tweetMapper;
	
	public TagsService(TweetMapper tweetMapper, TagsRepository tagRepository, TagsMapper tagMapper){
		this.tagRepository = tagRepository;
		this.tagMapper = tagMapper;
		this.tweetMapper = tweetMapper;
	}

	public List<TagsDto> index() {
		return tagRepository
				.findAll()
				.stream()
				.map(tagMapper::toTagDto)
				.collect(Collectors.toList());
	}

	public List<TweetDto> getTweetsWTag(String label) {
		Tags sgat = tagRepository.findByLabel(label);
		List<TweetDto> taggedList = new ArrayList<>();
		List<Tweet> tweetList = sgat.getTweetedTags();
		for(Tweet tweet : tweetList) {
			taggedList.add(tweetMapper.toTweetDto(tweet));
		}
		return taggedList; 
	}
	
	
}
