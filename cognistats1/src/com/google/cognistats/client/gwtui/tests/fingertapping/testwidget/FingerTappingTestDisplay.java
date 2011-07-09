package com.google.cognistats.client.gwtui.tests.fingertapping.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestView;

public interface FingerTappingTestDisplay extends Display {
	MultitrialTestView getMultiTrialTestView();
	void setTime(int timeLeft);
	void setCount(int pressCount);
	void setInstructionsVisible(boolean visible);
	void setTimeAndCountVisible(boolean visible);
}
