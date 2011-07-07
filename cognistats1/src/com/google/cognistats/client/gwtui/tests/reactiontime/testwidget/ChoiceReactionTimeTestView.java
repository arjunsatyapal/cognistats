package com.google.cognistats.client.gwtui.tests.reactiontime.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Image;

public class ChoiceReactionTimeTestView extends View implements ReactionTimeTestDisplay {
	@UiField
	TSRTestView tsrTest;
	@UiField Image stimulusImage1, stimulusImage2, stimulusImage3;

	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, ChoiceReactionTimeTestView> {
	}

	@Override
	public void noStimulus() {
		stimulusImage1.setVisible(true);
		stimulusImage2.setVisible(true);
		stimulusImage3.setVisible(true);
	}

	@Override
	public void stimulusOn(int stimulusType) {
		switch (stimulusType) {
		case 0: stimulusImage1.setVisible(false); break;
		case 1: stimulusImage2.setVisible(false); break;
		case 2: stimulusImage3.setVisible(false); break;
		}
	}

	public ChoiceReactionTimeTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {
	}


	@Override
	public TSRTestView getTSRTestView() {
		return tsrTest;
	}

}
