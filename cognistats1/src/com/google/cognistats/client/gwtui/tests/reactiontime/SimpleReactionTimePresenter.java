package com.google.cognistats.client.gwtui.tests.reactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.aggregator.RealAggregator;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.ReactionTimeTestDisplay;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.CorrectStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.ReactionTimeStatistic;

public class SimpleReactionTimePresenter extends ReactionTimePresenter implements Presenter {

	protected RealAggregator correctAggregator;
	protected ReactionTimeStatistic reactionTimeStatistic;
	protected CorrectStatistic correctStatistic;
	
	public SimpleReactionTimePresenter(ReactionTimeTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget, statPresenter);
	}
	
	@Override
	protected void initializeTest() {
		super.initializeTest();
		correctAggregator = new RealAggregator();
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
	protected void initializeStatistics() {
		super.initializeStatistics();
		reactionTimeStatistic = new ReactionTimeStatistic();
		correctStatistic = new CorrectStatistic();
		statPresenter.addRow(reactionTimeStatistic);
		statPresenter.addRow(correctStatistic);
	}

	@Override
	protected void endTrial() {
		super.endTrial();
		if (responseCorrect) {
			correctAggregator.add(reactionTime);
			reactionTimeStatistic.setTrialReactionTime(reactionTime);
			reactionTimeStatistic.setTestReactionTime(correctAggregator.mean(), correctAggregator.variance());
		}
		correctStatistic.setTrialCorrect(responseCorrect);
		correctStatistic.setTestCorrect((double)numCorrectTrials / nTrials);
	}


}
