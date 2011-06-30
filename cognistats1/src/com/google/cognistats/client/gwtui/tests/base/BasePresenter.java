package com.google.cognistats.client.gwtui.tests.base;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.TestPresenter;
import com.google.cognistats.client.gwtui.tests.base.statisticswidget.BaseStatisticsDisplay;
import com.google.cognistats.client.gwtui.tests.base.testwidget.BaseTestDisplay;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultDisplay;
import com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget.ChoiceReactionTimeStimulusDisplay;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.TouchStartEvent;
import com.google.gwt.event.dom.client.TouchStartHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;

public class BasePresenter implements TestPresenter {

	protected BaseTestDisplay testWidget;
	protected BaseStatisticsDisplay statisticsWidget;
	protected NumberFormat numberFormat;
	protected long testStartTime;
	protected long testTime;

	public BasePresenter(BaseTestDisplay testWidget, BaseStatisticsDisplay statisticsWidget) {
		this.testWidget = testWidget;
		this.statisticsWidget = statisticsWidget;
		this.numberFormat = NumberFormat.getDecimalFormat();
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
		return testWidget;
	}

	@Override
	public Display getStatisticsView() {
		return statisticsWidget;
	}
	
	protected void keyPressed(KeyPressEvent event) {
		
	}
	
	protected void cancelTest() {
		Window.alert("Test cancelled!");
	}

	@Override
	public KeyPressHandler getFocusPanelKeyPressHandler() {
	    KeyPressHandler myHandler = new KeyPressHandler() {
	        @Override
	        public void onKeyPress(KeyPressEvent event) {
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
	        public void onTouchStart(TouchStartEvent event) {
	        	touchStart(event);
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
			testTimeUpdated();
		}
	};
	
	protected void testTimeUpdated() {
		statisticsWidget.setTestTimeCurrent(testTime);
		statisticsWidget.setTestTimeAllTime(testTime + 36000000);
	}
	
	@Override
	public void start() {
		testStartTime = System.currentTimeMillis();
		testTimer.scheduleRepeating(100);
	}

	@Override
	public void stop() {
		cancelTest();
	}

}
