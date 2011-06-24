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
package com.google.cognistats.shared.enums;

/**
 * Enum listing out paths to different servlets.
 * This should be kept in sync with Web.xml.
 * Ideally a Build file will autogenerate the web.xml.
 * But leaving that for the future developers.
 *
 * @author Arjun Satyapal
 */
public enum ServletPaths {
  // Error Urls.
  UserNotLoggedIn("/userNotLoggedIn"),

  // Admin Urls.

  // Login URLs.
  LOGIN_GOOGLE("/loginGoogle"),
  LOGIN_GOOGLE_CALLBACK("/loginGoogleCallback"),
  LOGIN_YAHOO("/loginYahoo"),
  LOGIN_YAHOO_CALLBACK("/loginYahooCallback"),

  // Logout URL.
  LOGOUT("/logout"),

  // GWT Services.
  LOGIN_SERVICE("/cognistats/loginService"),

  // Servlets for TaskQueues
  NO_OP("/noOp"),
  SEND_EMAIL("/tasks/sendEmail");

  private final String relativePath;

  public final String getRelativePath() {
    return relativePath;
  }

  private ServletPaths(String relativePath) {
    this.relativePath = relativePath;
  }
}