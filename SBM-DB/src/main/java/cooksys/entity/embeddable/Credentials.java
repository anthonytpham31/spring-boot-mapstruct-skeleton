package cooksys.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Credentials {
	
	@NotNull
	@Column(unique = true, nullable = false)
	private String name;

	@NotNull
	@Column(nullable = false)
	private String pass;

	public Credentials() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
