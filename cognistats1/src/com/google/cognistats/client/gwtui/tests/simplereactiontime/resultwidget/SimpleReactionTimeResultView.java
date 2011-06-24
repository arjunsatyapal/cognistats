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
package com.google.cognistats.client.gwtui.tests.simplereactiontime.resultwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SimpleReactionTimeResultView extends View implements
    SimpleReactionTimeResultDisplay {
  @UiField
  TextBox textAttempts;
  @UiField
  TextBox textSuccessRatio;
  @UiField
  TextBox textFailureCount;
  @UiField
  TextBox textAverageTime;
  @UiField
  TextBox textStdDev;
  @UiField
  TextArea textAreaHistory;

  private static SimpleReactionTimeViewUiBinder uiBinder =
      GWT.create(SimpleReactionTimeViewUiBinder.class);

  interface SimpleReactionTimeViewUiBinder extends
      UiBinder<Widget, SimpleReactionTimeResultView> {
  }

  public SimpleReactionTimeResultView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setEnabled(boolean enabled) {
    // Text areas are already disabled in the ui.xml. So need to handler here.
  }

  @Override
  public TextBox getTextAttempts() {
    return textAttempts;
  }

  @Override
  public TextBox getTextSuccessRatio() {
    return textSuccessRatio;
  }

  @Override
  public TextBox getTextFailureCount() {
    return textFailureCount;
  }

  @Override
  public TextBox getTextAvgTime() {
    return textAverageTime;
  }

  @Override
  public TextBox getTextStdDev() {
    return textStdDev;
  }

  @Override
  public TextArea getTextAreaHistory() {
    return textAreaHistory;
  }
}
