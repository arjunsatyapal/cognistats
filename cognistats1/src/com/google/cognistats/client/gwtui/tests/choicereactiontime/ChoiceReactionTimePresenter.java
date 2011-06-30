package com.google.cognistats.client.gwtui.tests.choicereactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultDisplay;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusDisplay;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasWidgets;

import java.util.LinkedList;
import java.util.Random;

public class ChoiceReactionTimePresenter implements TestPresenter {

  protected int nTrials;
  protected static int totalNumTrials = 50;
  protected static int randomSeed = 0;
  protected static int numChoices = 3;
  protected static int delayLambda = 500;
  protected static int constantDelay = 250;
  protected int currentDelay;
  protected ChoiceReactionTimeStimulusDisplay testWidget;
  protected ChoiceReactionTimeResultDisplay statisticsWidget;
  protected Random generator = new Random();
  protected int currentChoice;
  protected long t0, t1, t2;
  protected boolean stimulusDisplayed;
  protected int numCorrect;
  protected String lastReactionTimeMessage;
  protected LinkedList<ChoiceReactionTimeTrialResult> trialResults;
  // protected LinkedList<>
  protected ChoiceReactionTimeTrialResult currentTrialResult;
  protected ChoiceReactionTimeStatistics statistics;
  NumberFormat numberFormat;
  private long testStartTime;

  public ChoiceReactionTimePresenter(
      ChoiceReactionTimeStimulusDisplay stimulusWidget,
      ChoiceReactionTimeResultDisplay resultWidget) {
    this.testWidget = stimulusWidget;
    this.statisticsWidget = resultWidget;
    this.numberFormat = NumberFormat.getDecimalFormat();
  }

  @Override
  public void go(HasWidgets container) {
    // TODO Auto-generated method stub

  }

  @Override
  public void bind() {
    // TODO Auto-generated method stub
  }

  @Override
  public Display getTestView() {
    return testWidget;
  }

  @Override
  public Display getStatisticsView() {
    // TODO Auto-generated method stub
    return statisticsWidget;
  }

  protected void handleReaction(int userChoice) {
    t2 = System.currentTimeMillis();
    currentTrialResult.userAnswer = userChoice;
    currentTrialResult.clickedTooEarly = !stimulusDisplayed;
    if (stimulusDisplayed) {
      if (userChoice == currentChoice) {
        correctClick();
      } else {
        wrongClick();
      }
    } else {
      clickedTooEarly();
    }
    endTrial();
  }

  protected void endTrial() {
    trialResults.add(currentTrialResult);
    statistics.updateStatistics(currentTrialResult);
    if (checkStoppingCondition()) {
      endTest();
    } else {
      startTrial();
    }
  }

  protected boolean checkStoppingCondition() {
    return (nTrials >= totalNumTrials);
  }

  protected void correctClick() {
    currentTrialResult.userReactionTime = t2 - t1;
    lastReactionTimeMessage = numberFormat.format(t2 - t1).toString();
  }

  protected void wrongClick() {
    currentTrialResult.userReactionTime = t2 - t1;
    lastReactionTimeMessage = "Wrong choice!";
  }

  protected void clickedTooEarly() {
    currentTrialResult.userReactionTime = t2 - t0;
    lastReactionTimeMessage = "Too early!";

  }

  @Override
  public KeyPressHandler getFocusPanelKeyPressHandler() {
    KeyPressHandler myHandler = new KeyPressHandler() {
      @Override
      public void onKeyPress(KeyPressEvent event) {
        char code = event.getCharCode();
        if ((code >= '1') && (code < '1' + numChoices)) {
          handleReaction(code - '1');
        }
      }
    };
    return myHandler;
  }

  @Override
  public TouchStartHandler getFocusPanelTouchStartHandler() {
    TouchStartHandler myTouchHandler = new TouchStartHandler() {
      @Override
      public void onTouchStart(TouchStartEvent event) {
        handleReaction(currentChoice); // TODO: figure out if they tapped the
                                       // right one
      }
    };
    return myTouchHandler;
  }

  @Override
  public void start() {
    initialize();
    testTimer.scheduleRepeating(1000);
    startTrial();
  }

  @Override
  public void stop() {
    endTest();
    // TODO(arjuns) : Figure out what needs to be done when a test is stopped.
    nTrials = totalNumTrials + 1;
  }

  protected void endTest() {
    testTimer.cancel();
  }

  protected void initialize() {
    nTrials = 0;
    numCorrect = 0;
    trialResults = new LinkedList<ChoiceReactionTimeTrialResult>();
    statistics = new ChoiceReactionTimeStatistics();
    generator.setSeed(randomSeed);
    testStartTime = System.currentTimeMillis();
  }


  protected void startTrial() {
    ++nTrials;
    currentTrialResult = new ChoiceReactionTimeTrialResult();
    currentTrialResult.trialNumber = nTrials;
    stimulusDisplayed = false;
    testWidget.hideStimulus();
    updateText();
    createTrial();
    startTimer();
  }

  protected void updateText() {
    statisticsWidget.getTextCorrectPercentage().setText(
        numberFormat.format(statistics.getCorrectFraction() * 100) + "%");
    statisticsWidget.getTextTooEarlyPercentage().setText(
        numberFormat.format(statistics.getTooEarlyFraction() * 100) + "%");
    statisticsWidget.getTextLastReactionTime().setText(lastReactionTimeMessage);
    statisticsWidget.getTextTrialNumber().setText(
        Integer.toString(statistics.getTotalTrials()));
    statisticsWidget.getTextMeanReactionTime().setText(
        numberFormat.format(statistics.getMeanReactionTime()));
    statisticsWidget.getTextStandardDeviation().setText(
        numberFormat.format(statistics.getStdDevReactionTime()));
  }

  protected void createTrial() {
    currentChoice = generator.nextInt(numChoices);
    currentDelay =
        constantDelay - (int) (delayLambda * Math.log(generator.nextDouble()));
    testWidget.setChoice(currentChoice);
    currentTrialResult.correctAnswer = currentChoice;
    currentTrialResult.delay = currentDelay;
  }

  protected Timer timer = new Timer() {

    @Override
    public void run() {
      testWidget.showStimulus();
      stimulusDisplayed = true;
      t1 = System.currentTimeMillis();
    }
  };

  protected Timer testTimer = new Timer() {
    @Override
    public void run() {
      long currentTime = System.currentTimeMillis();
      long testTime = currentTime - testStartTime;
      statisticsWidget.getTextSessionDuration().setText(
          Long.toString(testTime / 1000) + " seconds");
    }
  };

  protected void startTimer() {
    timer.schedule(currentDelay);
    t0 = System.currentTimeMillis();
  }
}
