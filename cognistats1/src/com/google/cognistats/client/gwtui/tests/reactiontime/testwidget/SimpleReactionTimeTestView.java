package com.google.cognistats.client.gwtui.tests.reactiontime.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Image;

public class SimpleReactionTimeTestView extends View implements ReactionTimeTestDisplay {
	@UiField
	TSRTestView tsrTest;
	@UiField Image stimulusImage;

	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, SimpleReactionTimeTestView> {
	}

	@Override
	public void noStimulus() {
		stimulusImage.setVisible(false);
	}

	@Override
	public void stimulusOn(int stimulusType) {
		stimulusImage.setVisible(true);
	}

	public SimpleReactionTimeTestView() {
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
