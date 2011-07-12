package com.google.cognistats.client.gwtui.tests.reactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.aggregator.RealAggregator;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.ReactionTimeTestDisplay;
import com.google.cognistats.client.gwtui.tests.tsr.TSRPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.CorrectStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.ReactionTimeStatistic;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.statistics.RowNamesEnum;

public class ReactionTimePresenter extends TSRPresenter implements Presenter {

	protected RealAggregator correctAggregator;
	protected ReactionTimeStatistic reactionTimeStatistic;
	protected CorrectStatistic readyStatistic;
	protected ReactionTimeTestDisplay reactionTimeTestWidget;
	protected int trialDelay;
	protected static final int constantTrialDelay = 250;
	protected static final int trialDelayLambda = 500;
	protected static final int testTotalTrials = 10;

	public ReactionTimePresenter(ReactionTimeTestDisplay testWidget, BaseStatisticWidgetPresenter statPresenter) {
		super(testWidget.getTSRTestView(), statPresenter);
		reactionTimeTestWidget = testWidget;
		setupKeys();
	}

	@Override
	protected void initializeTest() {
		super.initializeTest();
		correctAggregator = new RealAggregator();
	}

	@Override
	protected int stimulusDisplayDelay() {
		return trialDelay;
	}

	@Override
	protected void startTrial() {
		reactionTimeTestWidget.noStimulus();
		createTrial();
		super.startTrial();
	}

	protected void createTrial() {
		trialDelay = constantTrialDelay - (int)(trialDelayLambda * Math.log(getGenerator().nextDouble()));
	}

	@Override
	protected void increaseTrialCount() {
		super.increaseTrialCount();
		trialStatistic.setTestTrialAndTotalCount(nTrials, testTotalTrials + numIncorrectTrials);
	}

	@Override
	public Display getTestView() {
		return reactionTimeTestWidget;
	}

	@Override
	protected boolean isFinished() {
		return (numCorrectTrials == testTotalTrials);
	}

	@Override
	public BaseStatisticWidgetPresenter getStatPresenter() {
		return super.getStatPresenter();
	}

	@Override
	protected void initializeStatistics() {
		super.initializeStatistics();
		reactionTimeStatistic = new ReactionTimeStatistic();
		readyStatistic = new CorrectStatistic(RowNamesEnum.CORRECT_ROW);
		statPresenter.addRow(reactionTimeStatistic);
		statPresenter.addRow(readyStatistic);
	}

	@Override
	protected void endTrial() {
		super.endTrial();
		if (responseCorrect) {
			correctAggregator.add(reactionTime);
			reactionTimeStatistic.setTrialReactionTime(reactionTime);
			reactionTimeStatistic.setTestReactionTime(correctAggregator.mean(), correctAggregator.variance());
		}
		readyStatistic.setTrialCorrect(responseCorrect);
		readyStatistic.setTestCorrect((double)numCorrectTrials / nTrials);
	}

}
