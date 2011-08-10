package com.google.cognistats.client.gwtui.tests.reactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.ReactionTimeTestDisplay;
import com.google.cognistats.client.gwtui.tests.results.ChoiceReactionTimeTrialResult;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;

public class ChoiceReactionTimePresenter extends ReactionTimePresenter implements Presenter {

	protected static int numChoices = 3;
	protected boolean ready;
	protected boolean correctChoice;
	protected int trialType;
	protected int actualChoice;
	
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
		afterStimulusDisplay();
	}

	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode > 0) {
			ready = (trialState == TrialState.AFTER_STIMULUS_DISPLAY);
			actualChoice = keyCode - 1;
			correctChoice = (actualChoice == trialType);
			responseCorrect = ready && correctChoice;
			processResponse();
			return;
		}
		super.keyPressed(keyCode);
	}

	@Override
	protected void saveTrialResult() {
		ChoiceReactionTimeTrialResult trialResult = new ChoiceReactionTimeTrialResult();
		saveChoiceReactionTimeTrialResult(trialResult);
		trialResults.add(trialResult);
	}

	protected void saveChoiceReactionTimeTrialResult(ChoiceReactionTimeTrialResult trialResult) {
		saveReactionTimeTrialResult(trialResult);
		trialResult.setTrialType(trialType);
		trialResult.setChoice(actualChoice);
		trialResult.setReady(ready);
	}

	@Override
	public String getInstructions() {
		return "Press 1, 2, or 3 quickly each time you see one of the circles turn green.";
	}

}
