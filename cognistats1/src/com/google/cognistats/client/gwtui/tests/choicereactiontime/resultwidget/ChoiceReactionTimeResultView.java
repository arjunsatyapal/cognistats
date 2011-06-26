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
	@UiField Label textLastReactionTime;
	@UiField Label textTrialNumber;
	@UiField Label textCorrectPercentage;
	@UiField Label textSessionDuration;
	@UiField Label textMeanReactionTime;
	@UiField Label textStandardDeviation;
	@UiField Label textTotalCorrectPercentage;
	@UiField Label textTotalMeanReactionTime;
	@UiField Label textTotalStandardDeviation;
	@UiField Label textTotalSessions;

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
		// TODO Auto-generated method stub
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
	public Label getTextTotalCorrectPercentage() {
		return textTotalCorrectPercentage;
	}

	@Override
	public Label getTextTotalMeanReactionTime() {
		return textTotalMeanReactionTime;
	}

	@Override
	public Label getTextTotalStandardDeviation() {
		return textTotalStandardDeviation;
	}

	@Override
	public Label getTextTotalSessions() {
		return textTotalSessions;
	}


}
