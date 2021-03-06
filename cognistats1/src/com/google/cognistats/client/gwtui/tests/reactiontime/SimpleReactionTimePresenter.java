package com.google.cognistats.client.gwtui.tests.reactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.ReactionTimeTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum;

public class SimpleReactionTimePresenter extends ReactionTimePresenter implements Presenter {
	
	public SimpleReactionTimePresenter(ReactionTimeTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget, statPresenter);
		this.correctStatistic.setName(RowNamesEnum.READY_ROW);
	}
	
	protected void setupKeys() {
		super.setupKeys();
		keyMap.put(' ', 1);
	}

	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode == 1) {
			responseCorrect = (trialState == TrialState.AFTER_STIMULUS_DISPLAY);
			processResponse();
			return;
		}
		super.keyPressed(keyCode);
	}

	@Override
	protected void displayStimulus() {
		reactionTimeTestWidget.stimulusOn(0);
		afterStimulusDisplay();
	}

	@Override
	public String getInstructions() {
		return "Press (space) quickly each time you see the green circle.";
	}

}
