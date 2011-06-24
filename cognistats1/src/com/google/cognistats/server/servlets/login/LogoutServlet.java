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
package com.google.cognistats.server.servlets.login;


import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.cognistats.server.enums.OAuthProviderEnum;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This acts as a single-signout servlet.
 *
 * @author Arjun Satyapal
 */
public class LogoutServlet  extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws IOException {
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
      // Get user by email.
//      UserAccountDao userAccountDao =
//          getUserAccountPersistenceProvider().getUserAccountDaoByEmail(
//              user.getEmail());

//      if (userAccountDao == null) {
//        throw new IllegalArgumentException(
//            "Server did not find user : " + user.getEmail() + ".");
//      }

      OAuthProviderEnum oAuthProvider = LoginHelper.logout(request.getSession());
      String redirectUrl = LoginHelper.getLogoutUrl(request, oAuthProvider);
      response.sendRedirect(redirectUrl);
    }
  }
}