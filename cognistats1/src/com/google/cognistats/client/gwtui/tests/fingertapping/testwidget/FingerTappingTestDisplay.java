package com.google.cognistats.client.gwtui.tests.fingertapping.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestView;

public interface FingerTappingTestDisplay extends Display {
	MultitrialTestView getMultiTrialTestView();
	void setTimeLeft(int timeLeft);
	void setTapCount(int tapCount);
	void setInstructionsVisible(boolean visible);
	void setInstructionsHand(String hand);
	void setTimeAndCountVisible(boolean visible);
}
