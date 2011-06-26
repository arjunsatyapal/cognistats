package com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.gwt.user.client.ui.Label;

public interface ChoiceReactionTimeResultDisplay extends Display {
	Label getTextTrialNumber();
	Label getTextLastReactionTime();
	Label getTextCorrectPercentage();
	Label getTextSessionDuration();
	Label getTextMeanReactionTime();
	Label getTextStandardDeviation();
	
	Label getTextTotalCorrectPercentage();
	Label getTextTotalMeanReactionTime();
	Label getTextTotalStandardDeviation();
	Label getTextTotalSessions();
}
