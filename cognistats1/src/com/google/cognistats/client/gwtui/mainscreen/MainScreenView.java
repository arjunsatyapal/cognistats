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

import static com.google.cognistats.shared.enums.ServletPaths.LOGIN_GOOGLE;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

public class MainScreenView extends Composite {
  @UiField
  MenuItem menuItemLogin;

  private static MainScreenUiBinder uiBinder =
      GWT.create(MainScreenUiBinder.class);

  interface MainScreenUiBinder extends UiBinder<Widget, MainScreenView> {
  }

  public MainScreenView() {
    initWidget(uiBinder.createAndBindUi(this));
    menuItemLogin.setCommand(new Command() {
      @Override
      public void execute() {
        Window.Location.assign(LOGIN_GOOGLE.getRelativePath());
      }
    });
  }
}
