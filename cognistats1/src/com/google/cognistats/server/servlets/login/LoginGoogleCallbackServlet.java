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
import com.google.cognistats.server.domain.UserAccountDao;
import com.google.cognistats.server.enums.OAuthProviderEnum;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Callback servlet for users who are using Google as OAuthProvider.
 *
 * @author Arjun Satyapal
 */
@SuppressWarnings("serial")
public class LoginGoogleCallbackServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
      String email = user.getEmail();
      UserAccountDao dao = LoginHelper.getUserAccountDaoFromEmail(email);
      LoginHelper.loginStarts(request.getSession(), dao,
          OAuthProviderEnum.GOOGLE);
    }
    String redirectURL = LoginHelper.getApplicationURL(request);

    response.sendRedirect(redirectURL);
  }
}
