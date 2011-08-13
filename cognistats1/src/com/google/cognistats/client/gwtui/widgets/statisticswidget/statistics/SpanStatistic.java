package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.SPAN_ROW;

import com.google.gwt.i18n.client.NumberFormat;

public class SpanStatistic extends BaseStatisticGridRow {

  public SpanStatistic() {
    super(SPAN_ROW);
    setCurrentTrialColumn("");
    setCurrentTestColumn("");
  }
  
  public void setTrialSpan(int trialSpan) {
	  setCurrentTrialColumn(new Integer(trialSpan).toString());
  }
  
  public void setTestSpan(double testSpan) {
	  setCurrentTestColumn(NumberFormat.getDecimalFormat().format(testSpan));
  }
}
