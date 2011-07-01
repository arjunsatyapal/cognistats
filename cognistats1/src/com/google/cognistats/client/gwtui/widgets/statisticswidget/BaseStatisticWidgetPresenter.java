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

import static com.google.cognistats.client.resources.GlobalResources.RESOURCE;

import java.util.ArrayList;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.BaseStatisticGridRow;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.CellFormatter;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Presenter for Base Statistic widget.
 *
 * @author Arjun Satyapal
 */
public class BaseStatisticWidgetPresenter implements Presenter {
  private final ArrayList<BaseStatisticGridRow> listOfRows;

  public BaseStatisticWidgetPresenter(ArrayList<BaseStatisticGridRow> listOfRows) {
    this.listOfRows = listOfRows;
  }

  @Override
  public void go(
    HasWidgets container) {

    container.clear();
    Grid grid = new Grid(listOfRows.size(), BaseStatisticGridRow.numColumn);
    grid.setStyleName(RESOURCE.globalStyle().statGridCell());

    for (int rowCount = 0; rowCount < listOfRows.size(); rowCount++) {
      BaseStatisticGridRow currRow = listOfRows.get(rowCount);

      CellFormatter cellFormatter = grid.getCellFormatter();
      
      grid.setWidget(rowCount, 0, currRow.getRowTitle());
      cellFormatter.addStyleName(rowCount, 0,
        RESOURCE.globalStyle().statGridRowTitle());

      grid.setWidget(rowCount, 1, currRow.getTrialColumn());
      cellFormatter.setStyleName(rowCount, 1,
        RESOURCE.globalStyle().statGridTrial());

      grid.setWidget(rowCount, 2, currRow.getTestColumn());
      cellFormatter.setStyleName(rowCount, 2,
        RESOURCE.globalStyle().statGridTest());

      grid.setWidget(rowCount, 3, currRow.getAllTimeColumn());
      cellFormatter.setStyleName(rowCount, 3,
        RESOURCE.globalStyle().statGridAllTime());
    }

    container.add(grid);
  }

  @Override
  public void bind() {
    // TODO Auto-generated method stub

  }
}
