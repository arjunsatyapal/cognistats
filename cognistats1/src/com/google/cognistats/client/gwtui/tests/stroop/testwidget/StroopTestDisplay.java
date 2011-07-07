package com.google.cognistats.client.gwtui.tests.stroop.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.tests.stroop.StroopColor;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;

public interface StroopTestDisplay extends Display {
	TSRTestView getTSRTestView();
	void setWordAndColor(String word, StroopColor color);
	void setWordVisible(boolean visible);
	void setTrialInstructions(String instructions);
	void setCommentText(String commentText);
}
