package com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.gwt.user.client.ui.Label;

public interface ChoiceReactionTimeResultDisplay extends Display {
	Label getTextTrialNumber();
	Label getTextLastReactionTime();
	Label getTextCorrectPercentage();
	Label getTextTooEarlyPercentage();
	Label getTextSessionDuration();
	Label getTextMeanReactionTime();
	Label getTextStandardDeviation();
	
	Label getTextAllTimeCorrectPercentage();
	Label getTextAllTimeTooEarlyPercentage();
	Label getTextAllTimeMeanReactionTime();
	Label getTextAllTimeStandardDeviation();
	Label getTextAllTimeSessions();
}
