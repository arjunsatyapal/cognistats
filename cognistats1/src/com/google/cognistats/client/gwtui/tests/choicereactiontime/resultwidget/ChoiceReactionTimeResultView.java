package com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;

public class ChoiceReactionTimeResultView extends Composite implements ChoiceReactionTimeResultDisplay {

	private static ChoiceReactionResultViewUiBinder uiBinder = GWT
			.create(ChoiceReactionResultViewUiBinder.class);
	@UiField public Label textLastReactionTime;
	@UiField public Label textTrialNumber;
	@UiField public Label textCorrectPercentage;
	@UiField public Label textTooEarlyPercentage;
	@UiField public Label textSessionDuration;
	@UiField public Label textMeanReactionTime;
	@UiField public Label textStandardDeviation;
	@UiField public Label textAllTimeCorrectPercentage;
	@UiField public Label textAllTimeTooEarlyPercentage;
	@UiField public Label textAllTimeMeanReactionTime;
	@UiField public Label textAllTimeStandardDeviation;
	@UiField public Label textAllTimeSessions;

	interface ChoiceReactionResultViewUiBinder extends
			UiBinder<Widget, ChoiceReactionTimeResultView> {
	}

	public ChoiceReactionTimeResultView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public ChoiceReactionTimeResultView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Label getTextTrialNumber() {
		return textTrialNumber;
	}

	@Override
	public Label getTextLastReactionTime() {
		return textLastReactionTime;
	}

	@Override
	public Label getTextCorrectPercentage() {
		return textCorrectPercentage;
	}

	@Override
	public Label getTextTooEarlyPercentage() {
		return textTooEarlyPercentage;
	}

	@Override
	public Label getTextSessionDuration() {
		return textSessionDuration;
	}

	@Override
	public Label getTextMeanReactionTime() {
		return textMeanReactionTime;
	}

	@Override
	public Label getTextStandardDeviation() {
		return textStandardDeviation;
	}

	@Override
	public Label getTextAllTimeCorrectPercentage() {
		return textAllTimeCorrectPercentage;
	}

	@Override
	public Label getTextAllTimeTooEarlyPercentage() {
		return textAllTimeTooEarlyPercentage;
	}

	@Override
	public Label getTextAllTimeMeanReactionTime() {
		return textAllTimeMeanReactionTime;
	}

	@Override
	public Label getTextAllTimeStandardDeviation() {
		return textAllTimeStandardDeviation;
	}

	@Override
	public Label getTextAllTimeSessions() {
		return textAllTimeSessions;
	}


}
