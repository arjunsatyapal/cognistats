package com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.gwt.user.client.ui.TextBox;

public interface ChoiceReactionTimeResultDisplay extends Display {
	TextBox getTextTrialNumber();
	TextBox getTextLastReactionTime();
}
