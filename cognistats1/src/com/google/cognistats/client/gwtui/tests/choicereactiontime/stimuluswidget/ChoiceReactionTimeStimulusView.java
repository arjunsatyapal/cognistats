package com.google.cognistats.client.gwtui.tests.choicereactiontime.stimuluswidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class ChoiceReactionTimeStimulusView extends Composite {

	private static ChoiceReactionTimeStimulusViewUiBinder uiBinder = GWT
			.create(ChoiceReactionTimeStimulusViewUiBinder.class);

	interface ChoiceReactionTimeStimulusViewUiBinder extends
			UiBinder<Widget, ChoiceReactionTimeStimulusView> {
	}

	public ChoiceReactionTimeStimulusView() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public ChoiceReactionTimeStimulusView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


}
