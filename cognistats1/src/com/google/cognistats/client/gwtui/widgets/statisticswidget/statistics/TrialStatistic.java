package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.TRIAL_ROW;

public class TrialStatistic extends BaseStatisticGridRow {

  public TrialStatistic() {
    super(TRIAL_ROW);
    setCurrentTrialColumn("");
    setCurrentTestColumn("");
  }
  
  public void setTestTrialCount(int testTrialCount) {
	  setCurrentTestColumn(new Integer(testTrialCount).toString());
  }
  
  public void setTestTrialAndTotalCount(int testTrialCount, int totalTrialCount) {
	  setCurrentTestColumn(new Integer(testTrialCount).toString() +
			  " / " + new Integer(totalTrialCount).toString());
  }
}
