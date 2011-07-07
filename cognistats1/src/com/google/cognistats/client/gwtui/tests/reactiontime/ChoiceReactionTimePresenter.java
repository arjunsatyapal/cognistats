package com.google.cognistats.client.gwtui.tests.reactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.ReactionTimeTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;

public class ChoiceReactionTimePresenter extends ReactionTimePresenter implements Presenter {

	protected static int numChoices = 3;
	protected int trialType;
	
	public ChoiceReactionTimePresenter(ReactionTimeTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget, statPresenter);
	}
	
	protected void setupKeys() {
		super.setupKeys();
		for (int i = 0; i < numChoices; ++i) {
			keyMap.put(new Character((char)('1' + i)), new Integer(1 + i));
		}
	}
	
	@Override
	protected void createTrial() {
		trialType = getGenerator().nextInt(numChoices);
		super.createTrial();
	}

	@Override
	protected void displayStimulus() {
		reactionTimeTestWidget.stimulusOn(trialType);
		super.displayStimulus();
	}

	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode > 0) {
			responseCorrect = (keyCode == trialType);
			processResponse();
			return;
		}
		super.keyPressed(keyCode);
	}

}
