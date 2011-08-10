package com.google.cognistats.client.gwtui.tests.fingertapping.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FingerTappingTestView extends View implements FingerTappingTestDisplay {
	@UiField
	MultitrialTestView multiTrialTest;
	@UiField Label tappingLabel;
	@UiField Label timeLabel;
	@UiField Label countLabel;
	@UiField FlowPanel timeAndCount;

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
	public void setTime(int timeLeft) {
		timeLabel.setText(Integer.toString(timeLeft) + " seconds");
	}

	@Override
	public void setCount(int pressCount) {
		countLabel.setText(Integer.toString(pressCount) + " presses");
	}

	@Override
	public void setInstructionsVisible(boolean visible) {
		tappingLabel.setVisible(visible);
	}
	
	@Override
	public void setTimeAndCountVisible(boolean visible) {
		timeAndCount.setVisible(visible);
	}

}
