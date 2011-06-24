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

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Arjun Satyapal
 */
public class MainScreenView extends View implements MainScreenDisplay {
  @UiField
  FocusPanel focusPanel;
  @UiField
  Label labelUserId;
  @UiField
  MenuItem menuItemLoginLogout;
  @UiField
  MenuItem menuItemTestSelector;
  @UiField
  LayoutPanel workspace;
  @UiField
  Button buttonTestSelector;

  private static MainScreenViewUiBinder uiBinder =
      GWT.create(MainScreenViewUiBinder.class);

  interface MainScreenViewUiBinder extends UiBinder<Widget, MainScreenView> {
  }

  public MainScreenView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setEnabled(boolean enabled) {
    menuItemLoginLogout.setEnabled(enabled);
  }

  @Override
  public Label getLabelUserId() {
    return labelUserId;
  }

  @Override
  public MenuItem getMenuItemLoginLogout() {
    return menuItemLoginLogout;
  }

  @Override
  public LayoutPanel getWorkspace() {
    return workspace;
  }

  @Override
  public Button getButtonTestSelector() {
    return buttonTestSelector;
  }

  @Override
  public FocusPanel getFocusPanel() {
    return focusPanel;
  }

  @Override
  public MenuItem getMenuItemTestSelector() {
    return menuItemTestSelector;
  }
}
