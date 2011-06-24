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

import com.google.cognistats.shared.dtos.UserAccountDto;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * DAO for UserAccounts.
 *
 * @author arjuns@google.com (Arjun Satyapal)
 */
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
    return new UserAccountDto.Builder().setEmail(email).build();
  }
}
