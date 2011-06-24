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
package com.google.cognistats.client.gwtui.tests.simplereactiontime.stimuluswidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class SimpleReactionTimeStimulusView extends View implements
    SimpleReactionTimeStimulusDisplay {
  @UiField
  FocusPanel focusPanel;
  @UiField
  Image image;

  private static SimpleReactionTimeStimulusViewUiBinder uiBinder =
      GWT.create(SimpleReactionTimeStimulusViewUiBinder.class);

  interface SimpleReactionTimeStimulusViewUiBinder extends
      UiBinder<Widget, SimpleReactionTimeStimulusView> {
  }

  public SimpleReactionTimeStimulusView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setEnabled(boolean enabled) {
    // Nothing to disable here. So noop.
  }

  @Override
  public Image getImage() {
    return image;
  }

  @Override
  public FocusPanel getFocusPanel() {
    return focusPanel;
  }
}
