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
package com.google.cognistats.shared.dtos;

/**
 * DTO for UserAccount.
 *
 * @author Arjun Satyapal
 */
public class UserAccountDto implements AbstractDto {
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

  @Override
  public StringBuilder getStringBuilder() {
    return new StringBuilder("email:").append(email);
  }

  @Override
  public String toString() {
    return getStringBuilder().toString();
  }

  @Override
  public String validate() {
    //TODO(arjuns) : implement this.
    throw new UnsupportedOperationException();
  }
}
