/**
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cognistats.server.domain;

import com.google.cognistats.shared.dtos.CommonDSDto;

/**
 * @author Arjun Satyapal
 */
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
    return new CommonDSDto.Builder().setSeed(getSeed())
        .setSessionId(sessionId)
        .setUserAgent(userAgent)
        .build();
  }
}
