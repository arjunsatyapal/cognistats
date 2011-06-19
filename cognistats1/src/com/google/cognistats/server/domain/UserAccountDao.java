package com.google.cognistats.server.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.cognistats.shared.dtos.UserAccountDto;

@PersistenceCapable
public class UserAccountDao {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	private String email;

	public String getEmail() {
		return email;
	}
	
	private UserAccountDao() {
	}
	
	public UserAccountDto getDto() {
		return new UserAccountDto.Builder()
			.setEmail(email)
			.build();
	}
}
