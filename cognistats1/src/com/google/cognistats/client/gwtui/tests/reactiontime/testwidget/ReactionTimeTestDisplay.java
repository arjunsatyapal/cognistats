package com.google.cognistats.client.gwtui.tests.reactiontime.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;

public interface ReactionTimeTestDisplay extends Display {
	TSRTestView getTSRTestView();
	void noStimulus();
	void stimulusOn(int stimulusType);
}
