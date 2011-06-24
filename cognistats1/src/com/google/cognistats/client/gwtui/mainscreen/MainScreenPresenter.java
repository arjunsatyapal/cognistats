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
package com.google.cognistats.client.gwtui.mainscreen;

import static com.google.cognistats.client.rpc.ServiceProvider.getServiceProvider;
import static com.google.cognistats.shared.enums.ServletPaths.LOGIN_GOOGLE;
import static com.google.cognistats.shared.enums.ServletPaths.LOGOUT;

import com.google.cognistats.client.enums.MenuNames;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.testselector.TestSelectorPresenter;
import com.google.cognistats.client.gwtui.testselector.TestSelectorView;
import com.google.cognistats.shared.dtos.UserAccountDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.MenuItem;

/**
 * Presenter for the Main Screen.
 *
 * @author Arjun Satyapal
 */
public class MainScreenPresenter implements Presenter {
  // This class is singleton.
  private static MainScreenDisplay display;

  //TODO(arjuns) : Put following accessors in a good place.
  public static LayoutPanel getWorkspace() {
    return display.getWorkspace();
  }

  public static FocusPanel getFocusPanel() {
    return display.getFocusPanel();
  }

  private Command loginCommand = new Command() {
    @Override
    public void execute() {
      Window.Location.assign(LOGIN_GOOGLE.getRelativePath());
    }
  };

  private Command logoutCommand = new Command() {
    @Override
    public void execute() {
      Window.Location.assign(LOGOUT.getRelativePath());
    }
  };

  public MainScreenPresenter(MainScreenDisplay newDisplay) {
    if (display == null) {
      display = newDisplay;
    }
  }

  @Override
  public void go(HasWidgets container) {
    container.clear();
    container.add(display.asWidget());
    bind();
  }

  @Override
  public void bind() {
    refreshMainScreen();

    display.getButtonTestSelector().addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        TestSelectorPresenter presenter = new TestSelectorPresenter(new TestSelectorView());
        presenter.go(display.getWorkspace());
      }
    });
  }

  private void updateLoginLogoutMenuItem(boolean isUserLoggedIn) {
    MenuItem loginLogout = display.getMenuItemLoginLogout();
    if (isUserLoggedIn) {
      loginLogout.setText(MenuNames.LOGOUT.getString());
      loginLogout.setCommand(logoutCommand);
    } else {
      loginLogout.setText(MenuNames.LOGIN.getString());
      loginLogout.setCommand(loginCommand);
    }
  }

  private void refreshMainScreen() {
    getServiceProvider().getLoginService().getUserAccountDto(new AsyncCallback<UserAccountDto>() {
      @Override
      public void onSuccess(UserAccountDto result) {
        if (result != null) {
          // user is logged in.
          display.getLabelUserId().setText(result.getEmail());
          updateLoginLogoutMenuItem(true);
        } else {
          // User is not logged in.
          display.getLabelUserId().setText("");
          updateLoginLogoutMenuItem(false);
        }
      }

      @Override
      public void onFailure(Throwable caught) {
        // TODO(arjuns) : Handle alerts in a better way.
        Window.alert("Could not get LoginStatus from Server because : " + caught.getLocalizedMessage());
      }
    });
  }
}
