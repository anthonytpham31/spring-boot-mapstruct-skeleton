package cooksys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cooksys.dto.TagsDto;
import cooksys.dto.TweetDto;
import cooksys.mapper.TagsMapper;
import cooksys.repository.TagsRepository;

@Service
public class TagsService {
	
	// Probably will have to import tweets to add to tags as well as users
	TagsRepository tagRepository;
	TagsMapper tagMapper;
	
	public TagsService(TagsRepository tagRepository, TagsMapper tagMapper){
		this.tagRepository = tagRepository;
		this.tagMapper = tagMapper;
	}

	public List<TagsDto> index() {
		return tagRepository
				.findAll()
				.stream()
				.map(tagMapper::toTagDto)
				.collect(Collectors.toList());
	}

	public List<TweetDto> getTweetsWTag(String label) {
		return null; 
	}
	
	
}
