package com.google.cognistats.client.gwtui.tests.basetest;

import java.util.Random;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.cognistats.client.gwtui.tests.basetest.testwidget.BaseTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public abstract class BaseTestPresenter implements TestPresenter {

  protected BaseTestDisplay testWidget;
  protected BaseStatisticWidgetPresenter statPresenter;
  protected NumberFormat numberFormat;
  protected long testStartTime;
  protected long testTime;
  private Random generator;
  private static long RANDOM_SEED = 0;

  public BaseTestPresenter(BaseTestDisplay testWidget,
    BaseStatisticWidgetPresenter statPresenter) {
    this.testWidget = testWidget;
    this.statPresenter = statPresenter;
    this.numberFormat = NumberFormat.getDecimalFormat();
    generator = new Random();
  }

  @Override
  public void go(
    HasWidgets container) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void bind() {
  }

  @Override
  public Display getTestView() {
    return testWidget;
  }

  protected void keyPressed(
    KeyPressEvent event) {
  }

  protected void cancelTest() {
    Window.alert("Test cancelled!");
  }

  @Override
  public KeyPressHandler getFocusPanelKeyPressHandler() {
    KeyPressHandler myHandler = new KeyPressHandler() {
      @Override
      public void onKeyPress(
        KeyPressEvent event) {
        char code = event.getCharCode();
        GWT.log("Keypress event: " + Character.toString(code));
        if ((code == 'q') || (code == 'Q')) {
          cancelTest();
        }
        keyPressed(event);
      }
    };
    return myHandler;
  }

  @Override
  public TouchStartHandler getFocusPanelTouchStartHandler() {
    TouchStartHandler myTouchHandler = new TouchStartHandler() {
      @Override
      public void onTouchStart(
        TouchStartEvent event) {
        touchStart(event);
      }
    };
    return myTouchHandler;
  }

  protected void touchStart(
    TouchStartEvent event) {
    // do nothing
  }

  protected Timer testTimer = new Timer() {
    @Override
    public void run() {
      long currentTime = System.currentTimeMillis();
      testTime = currentTime - testStartTime;
      testTimeUpdated();
    }
  };

  protected void testTimeUpdated() {
    // TODO(arjuns) : use presenter to update the tim.
//    statisticsWidget.setTestTimeCurrent(testTime);
//    statisticsWidget.setTestTimeAllTime(testTime + 36000000);
  }

  @Override
  public void start() {
    testStartTime = System.currentTimeMillis();
    testTimer.scheduleRepeating(100);
    generator.setSeed(RANDOM_SEED);
  }

  @Override
  public void stop() {
    cancelTest();
  }

  @Override
  public BaseStatisticWidgetPresenter getStatPresenter() {
    Window.alert("Illegal state. This should not be called.");
    throw new UnsupportedOperationException();
  }

  protected Random getGenerator() {
	  return generator;
  }
}
