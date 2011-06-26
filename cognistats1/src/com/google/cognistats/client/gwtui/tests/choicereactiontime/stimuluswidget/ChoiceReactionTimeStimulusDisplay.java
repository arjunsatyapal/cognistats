package com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.gwt.user.client.ui.Label;

public interface ChoiceReactionTimeStimulusDisplay extends Display {
	public void setChoice(int choice);
	public void showStimulus();
	public void hideStimulus();
}
