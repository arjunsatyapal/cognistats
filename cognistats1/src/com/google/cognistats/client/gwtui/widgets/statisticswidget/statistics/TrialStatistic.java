package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.TRIAL_ROW;

public class TrialStatistic extends BaseStatisticGridRow {

  public TrialStatistic() {
    super(TRIAL_ROW);
    setCurrentTrial("");
    setCurrentTest("");
  }
  
  public void setTestTrialCount(int testTrialCount) {
	  setCurrentTest(new Integer(testTrialCount).toString());
  }
  
  public void setTestTrialAndTotalCount(int testTrialCount, int totalTrialCount) {
	  setCurrentTest(new Integer(testTrialCount).toString() +
			  "/" + new Integer(totalTrialCount).toString());
  }
}
