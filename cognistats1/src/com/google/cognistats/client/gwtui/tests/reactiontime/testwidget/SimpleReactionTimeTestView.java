package com.google.cognistats.client.gwtui.tests.reactiontime.testwidget;

import static com.google.cognistats.client.resources.GlobalResources.RESOURCE;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class SimpleReactionTimeTestView extends View implements ReactionTimeTestDisplay {
	@UiField
	TSRTestView tsrTest;
	@UiField HTML stimulus;

	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, SimpleReactionTimeTestView> {
	}

	@Override
	public void noStimulus() {
		stimulus.removeStyleName(RESOURCE.globalStyle().activeStimulus());		
	}

	@Override
	public void stimulusOn(int stimulusType) {
		stimulus.addStyleName(RESOURCE.globalStyle().activeStimulus());		
	}

	public SimpleReactionTimeTestView() {
		initWidget(uiBinder.createAndBindUi(this));
		stimulus.setStyleName(RESOURCE.globalStyle().circle());		
	}

	@Override
	public void setEnabled(boolean enabled) {
	}


	@Override
	public TSRTestView getTSRTestView() {
		return tsrTest;
	}

}
