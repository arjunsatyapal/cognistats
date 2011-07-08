package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.i18n.client.NumberFormat;

public class ReactionTimeStdDevStatistic extends Statistic {

  public ReactionTimeStdDevStatistic(double value) {
    super(RowNamesEnum.REACTION_TIME_STD_DEV_ROW);
    numberFormat = NumberFormat.getDecimalFormat();
    formatted = format(value);
  }

  protected String format(double value) {
    return numberFormat.format(value) + " ms";
  }

}
