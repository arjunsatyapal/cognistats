package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import com.google.gwt.i18n.client.NumberFormat;

public abstract class Statistic extends BaseStatisticGridRow {
  protected Statistic(RowNamesEnum name, String formattedTrial,
      String formattedTest, String formattedAllTime) {
    super(name);
  }

  protected String formatted;
  protected NumberFormat numberFormat;

  public String getFormatted() {
    return formatted;
  }

  protected String format(String value) {
    return value;
  }

}
