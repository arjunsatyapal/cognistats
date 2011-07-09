package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.TRIAL_ROW;

public class TrialStatistic extends BaseStatisticGridRow {
  private int currTrialCount;
  private int numTrialInTest;
  private int numSessions;

  public TrialStatistic(int numTrialInTest, int numSessions) {
    super(TRIAL_ROW);

    this.currTrialCount = 0;
    setCurrentTrialColumn("");

    this.numTrialInTest = numTrialInTest;
    setCurrentTestColumn(this.currTrialCount + "/" + this.numTrialInTest);

    this.numSessions = numSessions;
    setAllTimeColumn(this.numSessions + " sessions");
  }

  public void increaseTrialCount() {
    currTrialCount++;
    setCurrentTestColumn(currTrialCount + "/" + this.numTrialInTest);
  }
}
