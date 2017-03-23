package cooksys.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tags {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String label;
	
	private Timestamp firstUsed;
	
	private Timestamp lastUsed;
}
