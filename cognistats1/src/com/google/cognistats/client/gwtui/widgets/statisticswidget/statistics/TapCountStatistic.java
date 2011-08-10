package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.TAP_COUNT_ROW;

public class TapCountStatistic extends BaseStatisticGridRow {

  public TapCountStatistic() {
    super(TAP_COUNT_ROW);
    setCurrentTrialColumn("");
    setCurrentTestColumn("");
  }
  
  public void setTrialTapCount(int tapCount) {
	  setCurrentTrialColumn(Integer.toString(tapCount));
  }
  
  public void setTestTapCount(double mean, double variance) {
	  setCurrentTestColumn(new Long(Math.round(mean)).toString() + "\u00b1" + 
			  new Long(Math.round(Math.sqrt(variance))).toString());
  }
}
