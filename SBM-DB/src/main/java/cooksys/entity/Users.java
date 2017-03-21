package cooksys.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cooksys.entity.embeddable.Credentials;
import cooksys.entity.embeddable.Profile;
import cooksys.entity.superclass.BaseEntity;

@Entity
@Table(name = "people")
public class Users implements BaseEntity<Long> {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String username;
	
	@NotNull
	private Profile userProfile;
	
	@Column(name = "Date Created")
	private Timestamp timestamp;
	
	private Credentials userCreds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
		
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

	
}
