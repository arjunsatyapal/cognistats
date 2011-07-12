package com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics;

import static com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum.REACTION_TIME_ROW;

public class ReactionTimeStatistic extends BaseStatisticGridRow {

  public ReactionTimeStatistic() {
    super(REACTION_TIME_ROW);
    setCurrentTrialColumn("");
    setCurrentTestColumn("");
  }
  
  public void setTrialReactionTime(long reactionTime) {
	  setCurrentTrialColumn(new Long(reactionTime).toString());
  }
  
  public void setTestReactionTime(double mean, double variance) {
	  setCurrentTestColumn(new Long(Math.round(mean)).toString() + "\u00b1" + 
			  new Long(Math.round(Math.sqrt(variance))).toString());
  }
}
