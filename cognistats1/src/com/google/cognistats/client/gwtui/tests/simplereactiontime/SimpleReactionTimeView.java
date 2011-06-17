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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import java.util.Random;

public class SimpleReactionTimeView extends Composite {

  @UiField
  Image imageCircle;
  @UiField
  FocusPanel focusPanel;
  @UiField
  Button buttonStartTest;
  @UiField
  TextBox textAttempts;
  @UiField
  TextBox textSuccessRatio;
  @UiField
  TextBox textFailureCount;
  @UiField
  TextBox textAvgTime;
  @UiField
  TextBox textStdDev;
  @UiField
  TextArea textArea;

  // Constants.
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
  private Random generator;
  
  private void reset() {
    iterationCounter = 0;
    successCounter = 0;
    failureCounter = 0;
    aggregateResponseTimeInMillis = 0;
    resultArray = new String[blockSize];
    responseTimes = new double[blockSize];
    generator = new Random();
  }

  // Resetted with each iteration.
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
	  int delay = (int)(constantDelay - Math.log(u) * lambda);
	  return delay;
  }
  
  private boolean isValidToPressKey = false;
  private Timer t = new Timer() {
    @Override
    public void run() {
      boolean updateVisibility = !imageCircle.isVisible();
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
      textAttempts.setText(iterationCounter + "/" + maxIterations);


      if (iterationCounter < maxIterations) {
    	  if(!updateVisibility)
    		  t.schedule(getDelay());
    	  else
    		  t.schedule(maxDelayInMillis);  // turn circle off eventually
      } else {
        reset();
      }

      imageCircle.setVisible(updateVisibility);
      if (updateVisibility) {
        // This should be started when all manipulations are done.
        iterationStartTimeInMillis = System.currentTimeMillis();
      }
    }
  };

  private void updateResultAndTextArea() {
    if (isHit) {
      // Storing with space so dont have to append it later.
      resultArray[iterationCounter] = new String("Hit("
          + Double.toString(new Double(
              iterationEndTimeInMillis - iterationStartTimeInMillis))
          + "ms) ");
    } else {
      resultArray[iterationCounter] = "Miss ";
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 1; i <= iterationCounter; i++) {
      builder.append(resultArray[i]);
    }
    textArea.setText(builder.toString());
  }

  private void updateSuccessText() {
    double per = successCounter * 100 / (iterationCounter + failureCounter);
    textSuccessRatio.setText(Double.toString(per));
  }

  private void updateFailureText() {
	textFailureCount.setText(Integer.toString(failureCounter));
  }

  private void updateAvgResponseTime() {
	double thisResponseTime = iterationEndTimeInMillis - iterationStartTimeInMillis;
    responseTimes[successCounter] = thisResponseTime;
    aggregateResponseTimeInMillis += thisResponseTime;
    textAvgTime.setText(Double.toString(aggregateResponseTimeInMillis / (double)successCounter) + "ms");
  }

  private void updateStdDev() {
	double sumOfVariance = 0;
	double meanResponseTime = aggregateResponseTimeInMillis / (double)successCounter;
	for(int i = 0; i < successCounter; ++i) {
		sumOfVariance += Math.pow(responseTimes[i] - meanResponseTime, 2);
	}
	double variance = sumOfVariance / (double)successCounter;
	double stdDev = Math.sqrt(variance);
	textStdDev.setText(Double.toString(stdDev) + "ms");
  }
  
  private static SimpleReactionTimeViewUiBinder uiBinder =
      GWT.create(SimpleReactionTimeViewUiBinder.class);

  interface SimpleReactionTimeViewUiBinder extends
      UiBinder<Widget, SimpleReactionTimeView> {
  }

  public SimpleReactionTimeView() {
    initWidget(uiBinder.createAndBindUi(this));

    KeyPressHandler myHandler = new KeyPressHandler() {
      @Override
      public void onKeyPress(KeyPressEvent event) {
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
          //Window.alert("You pressed too quickly. In future I will "
          //    + "penalize you for pressing too quickly.");
        }
        updateSuccessText();
    	updateFailureText();
        isValidToPressKey = false;
      }
    };
    focusPanel.addKeyPressHandler(myHandler);

    buttonStartTest.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        reset();
        t.schedule(getDelay());
      }
    });
  }
}
