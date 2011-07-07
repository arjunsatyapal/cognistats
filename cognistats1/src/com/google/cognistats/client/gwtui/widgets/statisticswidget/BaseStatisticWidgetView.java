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
package com.google.cognistats.client.gwtui.widgets.statisticswidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * StatisticWidget which generates statistic view dynamically. -- we don't even
 * need this?
 *
 * @author Arjun Satyapal
 */
public class BaseStatisticWidgetView extends View implements BaseStatisticWidgetDisplay {
  @UiField
  AbsolutePanel statContainer;

  private static BaseStatisticWidgetViewUiBinder uiBinder = GWT
    .create(BaseStatisticWidgetViewUiBinder.class);

  interface BaseStatisticWidgetViewUiBinder extends
      UiBinder<Widget, BaseStatisticWidgetView> {
  }

  public BaseStatisticWidgetView() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setEnabled(
    boolean enabled) {
    // Nothing to do here.
  }

  @Override
  public AbsolutePanel getStatContainer() {
    return statContainer;
  }
}
