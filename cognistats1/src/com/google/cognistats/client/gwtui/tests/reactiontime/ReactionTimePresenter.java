package com.google.cognistats.client.gwtui.tests.reactiontime;

import com.google.cognistats.client.gwtui.mvpinterfaces.Display;
import com.google.cognistats.client.gwtui.mvpinterfaces.Presenter;
import com.google.cognistats.client.gwtui.tests.reactiontime.testwidget.ReactionTimeTestDisplay;
import com.google.cognistats.client.gwtui.tests.tsr.TSRPresenter;
import com.google.cognistats.client.gwtui.widgets.statisticswidget.BaseStatisticWidgetPresenter;

public class ReactionTimePresenter extends TSRPresenter implements Presenter {

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
	public Display getTestView() {
		return reactionTimeTestWidget;
	}

	@Override
	protected boolean isFinished() {
		return (nTrials == testTotalTrials);
	}

	@Override
	public BaseStatisticWidgetPresenter getStatPresenter() {
		return super.getStatPresenter();
	}

}
