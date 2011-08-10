package com.google.cognistats.client.gwtui.tests.fingertapping.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FingerTappingTestView extends View implements FingerTappingTestDisplay {
	@UiField
	MultitrialTestView multiTrialTest;
	@UiField Label tappingLabel;
	@UiField Label handLabel;
	@UiField Label timeLabel;
	@UiField Label countLabel;

	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, FingerTappingTestView> {
	}

	public FingerTappingTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {
	}


	@Override
	public MultitrialTestView getMultiTrialTestView() {
		return multiTrialTest;
	}

	@Override
	public void setTimeLeft(int timeLeft) {
		timeLabel.setText(Integer.toString(timeLeft) + " seconds left");
	}

	@Override
	public void setTapCount(int tapCount) {
		countLabel.setText(Integer.toString(tapCount) + " taps");
	}

	@Override
	public void setInstructionsVisible(boolean visible) {
		tappingLabel.setVisible(visible);
		handLabel.setVisible(visible);
	}
	
	@Override
	public void setInstructionsHand(String hand) {
		handLabel.setText("Use your " + hand + " hand.");
	}
	
	@Override
	public void setTimeAndCountVisible(boolean visible) {
		timeLabel.setVisible(visible);
		countLabel.setVisible(visible);
	}

}
