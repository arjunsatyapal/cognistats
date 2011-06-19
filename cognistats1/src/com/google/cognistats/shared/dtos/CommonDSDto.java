package com.google.cognistats.shared.dtos;

public class CommonDSDto {
	private long seed;
	private String sessionId;
	private String userAgent;

	public long getSeed() {
		return seed;
	}

	public String getSessionId() {
		return sessionId;
	}

	public String getUserAgent() {
		return userAgent;
	}

	private CommonDSDto() {
	}

	public static class Builder {
		private long seed;
		private String sessionId;
		private String userAgent;

		public Builder setSeed(long seed) {
			this.seed = seed;
			return this;
		}

		public Builder setSessionId(String sessionId) {
			this.sessionId = sessionId;
			return this;
		}

		public Builder setUserAgent(String userAgent) {
			this.userAgent = userAgent;
			return this;
		}

		public CommonDSDto build() {
			CommonDSDto commonDto = new CommonDSDto();
			commonDto.seed = this.seed;
			commonDto.sessionId = this.sessionId;
			commonDto.userAgent = this.userAgent;

			return commonDto;
		}
	}
}
