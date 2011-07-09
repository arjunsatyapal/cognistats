//package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;
//
//import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.TRIAL_ROW;
//
//public class TimeStatistic extends BaseStatisticGridRow {
//  private int currTrialTimeInMillis;
//  private int testTimeInMillis;
//  private int allTimeInMillis;
//  private int numSessions;
//
//  public TimeStatistic(int allTimeInMillis, int numSessions) {
//    super(TRIAL_ROW);
//    setCurrentTrial("");
//
//    currTrialCount = 0;
//    this.numTrialInTest = numTrialInTest;
//    setCurrentTest(currTrialCount + "/" + this.numTrialInTest);
//
//    this.numSessions = numSessions;
//    setAllTime(this.numSessions + " sessions");
//  }
//
//  public void increaseTrialCount() {
//    currTrialCount++;
//    setCurrentTest(currTrialCount + "/" + this.numTrialInTest);
//  }
//}
