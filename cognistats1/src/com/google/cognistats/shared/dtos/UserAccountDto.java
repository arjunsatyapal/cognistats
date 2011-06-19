package com.google.cognistats.shared.dtos;

public class UserAccountDto {
	private String email;

	public String getEmail() {
		return email;
	}
	
	private UserAccountDto() {
	}
	
	public static class Builder {
		private String email;
		
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public UserAccountDto build() {
			UserAccountDto dto = new UserAccountDto();
			dto.email = email;
			return dto;
		}
	}
}
