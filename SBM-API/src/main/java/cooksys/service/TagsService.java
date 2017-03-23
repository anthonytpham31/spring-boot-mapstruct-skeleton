package cooksys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cooksys.component.ServiceUtilities;
import cooksys.component.ServiceUtilities.IdChecker;
import cooksys.dto.TagsDto;
import cooksys.dto.TweetDto;
import cooksys.entity.Tags;
import cooksys.mapper.TagsMapper;
import cooksys.repository.TagsRepository;

@Service
public class TagsService {
	
	// Probably will have to import tweets to add to tags as well as users
	TagsRepository tagRepository;
	TagsMapper tagMapper;
	ServiceUtilities serviceUtilities;
	IdChecker idChecker;
	
	public TagsService(TagsRepository tagRepository, TagsMapper tagMapper, ServiceUtilities serviceUtilities) {
		super();
		this.tagRepository = tagRepository;
		this.tagMapper = tagMapper;
		this.serviceUtilities = serviceUtilities;
		this.idChecker = serviceUtilities.buildIdChecker(Tags.class, this::has);
	}
	
	public boolean has(Long id) {
		if(id != null)
			return tagRepository.exists(id);
		return false;
	}

	public static List<TagsDto> index() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TweetDto> getTweetsWTag(TagsDto tag) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
