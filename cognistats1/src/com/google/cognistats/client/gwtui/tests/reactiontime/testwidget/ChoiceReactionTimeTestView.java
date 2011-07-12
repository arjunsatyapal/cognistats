package com.google.cognistats.client.gwtui.tests.reactiontime.testwidget;

import static com.google.cognistats.client.resources.GlobalResources.RESOURCE;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ChoiceReactionTimeTestView extends View implements ReactionTimeTestDisplay {
	@UiField
	TSRTestView tsrTest;
	@UiField HTML stimulus1, stimulus2, stimulus3;

	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, ChoiceReactionTimeTestView> {
	}
	
	@Override
	public void noStimulus() {
		stimulus1.removeStyleName(RESOURCE.globalStyle().activeStimulus());
		stimulus2.removeStyleName(RESOURCE.globalStyle().activeStimulus());
		stimulus3.removeStyleName(RESOURCE.globalStyle().activeStimulus());
	}

	@Override
	public void stimulusOn(int stimulusType) {
		switch (stimulusType) {
		case 0: stimulus1.addStyleName(RESOURCE.globalStyle().activeStimulus()); break;
		case 1: stimulus2.addStyleName(RESOURCE.globalStyle().activeStimulus()); break;
		case 2: stimulus3.addStyleName(RESOURCE.globalStyle().activeStimulus()); break;
		}
	}

	public ChoiceReactionTimeTestView() {
		initWidget(uiBinder.createAndBindUi(this));
		stimulus1.setStyleName(RESOURCE.globalStyle().circle());
		stimulus2.setStyleName(RESOURCE.globalStyle().circle());
		stimulus3.setStyleName(RESOURCE.globalStyle().circle());
	}

	@Override
	public void setEnabled(boolean enabled) {
	}


	@Override
	public TSRTestView getTSRTestView() {
		return tsrTest;
	}

}
