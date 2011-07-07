package com.google.cognistats.client.gwtui.tests.simplereactiontime.statisticswidget;

import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.RowNamesEnum;

public class SimpleReactionTimeStatisticsPresenter extends
    BaseStatisticWidgetPresenter {

  public SimpleReactionTimeStatisticsPresenter() {
    // TODO(arjuns) : Fix this.
    removeRow(RowNamesEnum.CORRECT_ROW);
  }

}
