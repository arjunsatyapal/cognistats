package com.google.cognistats.client.gwtui.tests.choicereactiontime.statisticswidget;

import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.CorrectGridRow;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.ReactionTimeGridRow;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.ReactionTimeStdDevGridRow;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.rows.ReadyGridRow;

public class ChoiceReactionTimeStatisticsPresenter extends
    BaseStatisticWidgetPresenter {

  public ChoiceReactionTimeStatisticsPresenter() {
    addRow(new ReactionTimeGridRow());
    addRow(new ReactionTimeStdDevGridRow());
    addRow(new ReadyGridRow());
    addRow(new CorrectGridRow());
  }
}
