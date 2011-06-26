/**
 * Copyright 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cognistats.client.gwtui.tests.simplereactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.resultwidget.SimpleReactionTimeResultDisplay;
import com.google.cognistats.client.gwtui.tests.simplereactiontime.stimuluswidget.SimpleReactionTimeStimulusDisplay;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

import java.util.Random;

/**
 * Presenter for SimpleReactionTime Test.
 *
 * @author Arjun Satyapal
 */
public class SimpleReactionTimePresenter implements TestPresenter {
  private SimpleReactionTimeStimulusDisplay stimulusWidget;
  private SimpleReactionTimeResultDisplay resultWidget;


  public SimpleReactionTimePresenter(
      SimpleReactionTimeStimulusDisplay stimulusWidget,
      SimpleReactionTimeResultDisplay resultWidget) {
    this.stimulusWidget = stimulusWidget;
    this.resultWidget = resultWidget;
  }

  // Constants.
  // TODO(arjuns) : Get this value from the server.
  private int maxIterations = 150;
  private int blockSize = maxIterations + 1;
  private int maxDelayInMillis = 3000;
  private String[] resultArray = new String[blockSize];
  private double[] responseTimes = new double[blockSize];

  // Things to be reseted with each test.
  private int iterationCounter = 0;
  private int successCounter = 0;
  private int failureCounter = 0;
  private double aggregateResponseTimeInMillis = 0;
  private Random generator = new Random();

  private void resetTestSpecificVariables() {
    iterationCounter = 0;
    successCounter = 0;
    failureCounter = 0;
    aggregateResponseTimeInMillis = 0;
  }

  // Reset with each iteration.
  private long iterationStartTimeInMillis = 0;
  private long iterationEndTimeInMillis = 0;
  private boolean isHit = false;

  private void resetIterationSpecificVars() {
    iterationStartTimeInMillis = 0;
    iterationEndTimeInMillis = 0;
    isHit = false;
  }

  private int getDelay() {
    int lambda = 500;
    int constantDelay = 250;
    double u = generator.nextDouble();
    int delay = (int) (constantDelay - Math.log(u) * lambda);
    return delay;
  }

  private boolean isValidToPressKey = false;
  private Timer t = new Timer() {
    @Override
    public void run() {
      boolean updateVisibility = !stimulusWidget.getImage().isVisible();
      // Making image visible. So update iteration counter.
      if (updateVisibility) {
        iterationCounter++;
        updateSuccessText();
      } else {
        updateResultAndTextArea();
        resetIterationSpecificVars();
      }
      // If image is visible, its valid to press key else not.
      isValidToPressKey = updateVisibility;
      resultWidget.getTextAttempts().setText(
          iterationCounter + "/" + maxIterations);


      if (iterationCounter < maxIterations) {
        if (!updateVisibility)
          t.schedule(getDelay());
        else
          t.schedule(maxDelayInMillis); // turn circle off eventually
      } else {
        // reset();
      }

      stimulusWidget.getImage().setVisible(updateVisibility);
      if (updateVisibility) {
        // This should be started when all manipulations are done.
        iterationStartTimeInMillis = System.currentTimeMillis();
      }
    }
  };

  private void updateResultAndTextArea() {
    if (isHit) {
      // Storing with space so dont have to append it later.
      resultArray[iterationCounter] =
          new String("Hit("
              + Double.toString(new Double(iterationEndTimeInMillis
                  - iterationStartTimeInMillis)) + "ms) ");
    } else {
      resultArray[iterationCounter] = "Miss ";
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 1; i <= iterationCounter; i++) {
      builder.append(resultArray[i]);
    }
    resultWidget.getTextAreaHistory().setText(builder.toString());
  }

  private void updateSuccessText() {
    double per = successCounter * 100 / (iterationCounter + failureCounter);
    resultWidget.getTextSuccessRatio().setText(Double.toString(per));
  }

  private void updateFailureText() {
    resultWidget.getTextFailureCount()
        .setText(Integer.toString(failureCounter));
  }

  private void updateAvgResponseTime() {
    double thisResponseTime =
        iterationEndTimeInMillis - iterationStartTimeInMillis;
    responseTimes[successCounter] = thisResponseTime;
    aggregateResponseTimeInMillis += thisResponseTime;
    resultWidget.getTextAvgTime().setText(
        Double.toString(aggregateResponseTimeInMillis / successCounter) + "ms");
  }

  private void updateStdDev() {
    double sumOfVariance = 0;
    double meanResponseTime = aggregateResponseTimeInMillis / successCounter;
    for (int i = 0; i < successCounter; ++i) {
      sumOfVariance += Math.pow(responseTimes[i] - meanResponseTime, 2);
    }
    double variance = sumOfVariance / successCounter;
    double stdDev = Math.sqrt(variance);
    resultWidget.getTextStdDev().setText(Double.toString(stdDev) + "ms");
  }

  private void handleReaction() {
    iterationEndTimeInMillis = System.currentTimeMillis();
    if (isValidToPressKey) {
      isHit = true;
      successCounter++;
      updateAvgResponseTime();
      updateResultAndTextArea();
      updateStdDev();
      t.cancel();
      t.run();
    } else {
      failureCounter++;
      // Window.alert("You pressed too quickly. In future I will "
      // + "penalize you for pressing too quickly.");
    }
    updateSuccessText();
    updateFailureText();
    isValidToPressKey = false;
  }

  @Override
  public void go(HasWidgets container) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void bind() {
  }

  @Override
  public Display getTestView() {
    return stimulusWidget;
  }

  @Override
  public Display getStatisticsView() {
    return resultWidget;
  }

  @Override
  public void start() {
    resetTestSpecificVariables();
    t.schedule(getDelay());
  }

  @Override
  public void stop() {
    // TODO(arjuns) : This is a temporary hack. You need to propagate state.
    iterationCounter = maxIterations + 1;
    Window.alert("This is throwin exception. needs to be fixed.");
  }

  @Override
  public KeyPressHandler getFocusPanelKeyPressHandler() {
    KeyPressHandler myHandler = new KeyPressHandler() {
      @Override
      public void onKeyPress(KeyPressEvent event) {
        handleReaction();
      }
    };
    return myHandler;
  }

  @Override
  public TouchStartHandler getFocusPanelTouchStartHandler() {
    TouchStartHandler myTouchHandler = new TouchStartHandler() {
      @Override
      public void onTouchStart(TouchStartEvent event) {
        handleReaction();
      }
    };
    return myTouchHandler;
  }
}
