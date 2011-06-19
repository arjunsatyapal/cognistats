package com.google.cognistats.server.domain;

import com.google.cognistats.shared.dtos.CommonDSDto;


public class CommonDSDao {
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

	private CommonDSDao() {
	}
	
	public static CommonDSDao fromDto(CommonDSDto dto) {
		CommonDSDao dao = new CommonDSDao();
		dao.seed = dto.getSeed();
		dao.sessionId = dto.getSessionId();
		dao.userAgent = dto.getUserAgent();
		
		return dao;
	}
	
	public CommonDSDto toDto() {
		return new CommonDSDto.Builder()
			.setSeed(getSeed())
			.setSessionId(sessionId)
			.setUserAgent(userAgent)
			.build();
	}
}
