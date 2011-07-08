package com.google.cognistats.client.gwtui.tests.choicereactiontime.statisticswidget;

import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.CorrectStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.ReactionTimeStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.ReactionTimeStdDevStatistic;

public class ChoiceReactionTimeStatisticsPresenter extends
    BaseStatisticWidgetPresenter {

  public ChoiceReactionTimeStatisticsPresenter() {
    addRow(new ReactionTimeStatistic(1234.1234));
    addRow(new ReactionTimeStdDevStatistic(1234.1234));
//    addRow(new ReadyGridRow());
    addRow(new CorrectStatistic(true));
  }
}
