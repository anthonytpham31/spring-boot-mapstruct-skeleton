package cooksys.entity.embeddable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class Credentials {
	
	@NotNull
	@Column(unique = true, nullable = false)
	private String username;

	@NotNull
	@Column(nullable = false)
	private String password;
}
