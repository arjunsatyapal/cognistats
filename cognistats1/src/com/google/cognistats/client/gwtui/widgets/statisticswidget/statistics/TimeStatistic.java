package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.TIME_ROW;

public class TimeStatistic extends BaseStatisticGridRow {
//  private long currTrialTimeInMillis;
//  private long testTimeInMillis;
//  private long allTimeInMillis;
//  private int numSessions;

  public TimeStatistic() {
	  super(TIME_ROW);
  }
  
//
//  long allTimeInMillis, int numSessions) {
//    this.currTrialTimeInMillis = 0;
//    setCurrentTrialColumn("");
//
//    this.testTimeInMillis = 0;
//    setCurrentTestColumn("");
//
//    this.allTimeInMillis = allTimeInMillis;
//    this.numSessions = numSessions;
//    setAllTimeColumn(allTimeInMillis / numSessions + " ms");
//  }

  public void setCurrTrialTimeInMillis(long currTrialTimeInMillis) {
    //this.currTrialTimeInMillis = currTrialTimeInMillis;
    if (currTrialTimeInMillis == 0) {
      setCurrentTrialColumn("");
    } else {
      setCurrentTrialColumn(currTrialTimeInMillis + " ms");
    }
  }

  public void setTestTimeInMillis(long testTimeInMillis) {
    //this.testTimeInMillis = testTimeInMillis;
    if (testTimeInMillis == 0) {
      setCurrentTestColumn("");
    } else {
      setCurrentTestColumn(testTimeInMillis + " ms");
    }
  }
}
