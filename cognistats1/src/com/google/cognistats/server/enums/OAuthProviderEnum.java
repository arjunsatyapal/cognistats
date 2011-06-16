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
package com.google.cognistats.server.enums;

/**
 * List of Supported OAuthProvider.
 * Currently support for Google and Yahoo are implemented.
 * Future developers can experiment with AOL and MyOpenId.
 *
 * @author Arjun Satyapal
 */
public enum OAuthProviderEnum {
  /*
   * TODO : Future authors can practice same thing with AOL and MyOpenId.
   */
  GOOGLE(2, "google.com/accounts/o8/id", "https://www.google.com/accounts/Logout"),
  YAHOO(4, "yahoo.com", "https://login.yahoo.com/config/login?logout=1");

  private int providerId;
  private String providerUrl;
  private String logOutUrl;

  public int getProviderId() {
    return providerId;
  }

  public String getProviderUrl() {
    return providerUrl;
  }

  public String getLogOutUrl() {
    return logOutUrl;
  }

  public static OAuthProviderEnum getByOrdinalId(int ordinalId) {
    OAuthProviderEnum[] providers = OAuthProviderEnum.values();
    if (ordinalId < 0 || ordinalId > providers.length) {
      return null;
    }
    return (OAuthProviderEnum.values())[ordinalId];
  }

  private OAuthProviderEnum(int providerId,
    String providerUrl, String logOutUrl) {
    this.providerId = providerId;
    this.providerUrl = providerUrl;
    this.logOutUrl = logOutUrl;
  }
}