package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.TRIAL_ROW;

public class TrialStatistic extends Statistic {

  public TrialStatistic(int value, int total) {
    super(TRIAL_ROW);
    formatted = format(value, total);
  }

  protected String format(int value, int total) {
    return Integer.toString(value) + " / " + Integer.toString(total);
  }
}
