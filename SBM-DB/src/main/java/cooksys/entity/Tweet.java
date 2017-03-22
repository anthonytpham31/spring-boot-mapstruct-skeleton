package cooksys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue
	private Long id;
}
