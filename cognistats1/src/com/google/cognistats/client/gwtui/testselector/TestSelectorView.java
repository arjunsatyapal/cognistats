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
package com.google.cognistats.client.gwtui.testselector;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

/**
 * View for Test Selector.
 *
 * @author Arjun Satyapal
 */
public class TestSelectorView extends View implements TestSelectorDisplay {
  @UiField Button buttonSRTT;
  @UiField Button buttonCRTT;
  @UiField Button buttonSimpleReactionTime;
  @UiField Button buttonBase;

  private static TestSelectorViewUiBinder uiBinder =
      GWT.create(TestSelectorViewUiBinder.class);

  interface TestSelectorViewUiBinder extends UiBinder<Widget, TestSelectorView> {
  }

  /**
   * Because this class has a default constructor, it can
   * be used as a binder template. In other words, it can be used in other
   * *.ui.xml files as follows:
   * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
   *   xmlns:g="urn:import:**user's package**">
   *  <g:**UserClassName**>Hello!</g:**UserClassName>
   * </ui:UiBinder>
   * Note that depending on the widget that is used, it may be necessary to
   * implement HasHTML instead of HasText.
   */
  public TestSelectorView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public Button getButtonSRTT() {
    return buttonSRTT;
  }

  @Override
  public void setEnabled(boolean enabled) {
    Window.alert(getClass().getName() + ".setEnabled should not be called. See exception.");
    throw new UnsupportedOperationException("Not sure when this gets called.");
  }
  
  @Override
  public Button getButtonCRTT() {
	  return buttonCRTT;
  }
  
  @Override
  public Button getButtonSimpleReactionTime() {
	  return buttonSimpleReactionTime;
  }

  @Override
  public Button getButtonBase() {
	  return buttonBase;
  }

}
