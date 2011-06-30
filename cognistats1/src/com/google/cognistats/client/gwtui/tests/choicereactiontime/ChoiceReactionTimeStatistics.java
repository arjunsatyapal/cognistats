package com.google.cognistats.client.gwtui.tests.choicereactiontime;

public class ChoiceReactionTimeStatistics {
  protected int totalTrials = 0;
  protected int correctTrials = 0, tooEarlyTrials = 0, wrongTrials = 0;
  protected int sumCorrectReactionTimes = 0;
  protected int sumCorrectReactionTimesSquared = 0;

  public void updateStatistics(ChoiceReactionTimeTrialResult trialResult) {
    ++totalTrials;
    if (trialResult.clickedTooEarly) {
      ++tooEarlyTrials;
    } else {
      if (trialResult.userAnswer == trialResult.correctAnswer) {
        ++correctTrials;
        sumCorrectReactionTimes += trialResult.userReactionTime;
        sumCorrectReactionTimesSquared +=
            (trialResult.userReactionTime) * (trialResult.userReactionTime);
      } else {
        ++wrongTrials;
      }
    }
  }

  public double getCorrectFraction() {
    return ((double) correctTrials) / totalTrials;
  }

  public double getTooEarlyFraction() {
    return ((double) tooEarlyTrials) / totalTrials;
  }

  public int getTotalTrials() {
    return totalTrials;
  }

  public int getCorrectTrials() {
    return correctTrials;
  }

  public int getTooEarlyTrials() {
    return tooEarlyTrials;
  }

  public int getWrongTrials() {
    return wrongTrials;
  }

  public double getMeanReactionTime() {
    if (correctTrials == 0) {
      return 0.0;
    }
    return ((double) sumCorrectReactionTimes) / correctTrials;
  }

  public double getStdDevReactionTime() {
    if (correctTrials < 2) {
      return 0.0;
    }
    return Math.sqrt(((double) (sumCorrectReactionTimesSquared - sumCorrectReactionTimes
        * (double) (sumCorrectReactionTimes) / correctTrials))
        / (correctTrials - 1.0));
  }
}
