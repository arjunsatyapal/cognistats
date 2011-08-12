package com.google.cognistats.client.gwtui.tests.basetest;

import java.util.HashMap;
import java.util.Random;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.cognistats.client.gwtui.tests.basetest.testwidget.BaseTestDisplay;
import com.google.cognistats.client.gwtui.tests.results.BaseResult;
import com.google.cognistats.client.gwtui.widgets.classroomwidget.TestFinisher;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.DurationStatistic;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.LayoutPanel;

public class BaseTestPresenter implements TestPresenter {

  protected BaseTestDisplay testWidget;
  protected BaseStatisticWidgetPresenter statPresenter;
  protected HasWidgets statContainer;
  protected TestFinisher finisher;
  protected boolean isRunning;
  protected long testStartTime;
  protected long testTime;
  protected long timeInTest;
  private Random generator;
  protected DurationStatistic durationStatistic;
  protected HashMap<Character, Integer> keyMap;
  private static long randomSeed = 0;
  protected boolean testComplete;

  public BaseTestPresenter(BaseTestDisplay testWidget,
      BaseStatisticWidgetPresenter statPresenter) {
    this.testWidget = testWidget;
    this.statPresenter = statPresenter;
    generator = new Random();
    setupKeys();
    initializeStatistics();
    isRunning = false;
  }
  
  protected void initializeStatistics() {
	  durationStatistic = new DurationStatistic();
	  statPresenter.addRow(durationStatistic);
  }

  protected void setupKeys() {
    keyMap = new HashMap<Character, Integer>();
    keyMap.put('q', 0);
    keyMap.put('Q', 0);
  }

  @Override
  public void setStatContainer(LayoutPanel layoutPanelResult) {
    this.statContainer = layoutPanelResult;
    statPresenter.go(statContainer);
  }

  @Override
  public void go(HasWidgets container) {
    //throw new UnsupportedOperationException();
  }

  @Override
  public void bind() {
  }

  @Override
  public Display getTestView() {
    return testWidget;
  }

  protected void keyPressed(int keyCode) {
    if (keyCode == 0) {
      cancelTest();
    }
  }

  protected void keyUp(int keyCode) {
	  // do nothing
  }
  
  @Override
  public KeyPressHandler getFocusPanelKeyPressHandler() {
    KeyPressHandler myHandler = new KeyPressHandler() {
      @Override
      public void onKeyPress(KeyPressEvent event) {
        char code = event.getCharCode();
        GWT.log("Keypress event: " + Character.toString(code));
        if (isRunning) {
        	if (keyMap.containsKey(code)) {
        		keyPressed(keyMap.get(code).intValue());
        	}
        }
      }
    };
    return myHandler;
  }

  @Override
  public KeyUpHandler getFocusPanelKeyUpHandler() {
	  KeyUpHandler myHandler = new KeyUpHandler() {
		  public void onKeyUp(KeyUpEvent event) {
			  int nativeCode = event.getNativeKeyCode();
			  char code = (char)nativeCode;
			  //GWT.log("code is '" + code + "'");
			  if (isRunning) {
				  if (keyMap.containsKey(code)) {
					  keyUp(keyMap.get(code).intValue());
				  }
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
    	  if (isRunning) {
    		  touchStart(event);
    	  }
      }
    };
    return myTouchHandler;
  }

  protected void touchStart(TouchStartEvent event) {
    // do nothing
  }

  protected Timer testTimer = new Timer() {
    @Override
    public void run() {
      long currentTime = System.currentTimeMillis();
      testTime = currentTime - testStartTime;
      if (isRunning) {
    	  testTimeUpdated();
      }
    }
  };

  protected void testTimeUpdated() {
    // TODO(arjuns) : use presenter to update the time.
	  durationStatistic.setTestTimeInMillis(testTime);
    // statisticsWidget.setTestTimeCurrent(testTime);
    // statisticsWidget.setTestTimeAllTime(testTime + 36000000);
  }

  @Override
  public void start() {
    testStartTime = System.currentTimeMillis();
    testTimer.scheduleRepeating(100);
    generator.setSeed(randomSeed);
    isRunning = true;
  }

  @Override
  public void stop() {
    cancelTest();
  }
  
  @Override
  public void togglePause() {
	  Window.alert("Pause not implemented yet");
  }
  
  @Override
  public BaseStatisticWidgetPresenter getStatPresenter() {
    return statPresenter;
  }

  protected Random getGenerator() {
    return generator;
  }
  
  @Override
  public void setFinisher(TestFinisher finisher) {
	  this.finisher = finisher;
  }
  
  @Override
  public String getInstructions() {
	  return "These are the default instructions from BaseTestPresenter.";
  }

  @Override
  public void buildResults() {
	  BaseResult results = new BaseResult();
	  buildBaseResults(results);
  }
  
  protected void buildBaseResults(BaseResult results) {
	  results.setTestComplete(testComplete);
	  results.setTimeInTest(timeInTest);
	  results.setSeed(randomSeed);
  }

  @Override
  public void finish() {
	  timeInTest = System.currentTimeMillis() - testStartTime;
	  buildResults();
	  finisher.finishTest(statContainer);
  }
  
  protected void cancelTest() {
	  isRunning = false;
	  testComplete = false;
	  finish();
  }

}
