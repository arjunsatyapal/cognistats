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
import com.google.gwt.user.client.ui.Label;

public class ChoiceReactionTimeStimulusView extends Composite implements ChoiceReactionTimeStimulusDisplay {

	private static ChoiceReactionTimeStimulusViewUiBinder uiBinder = GWT
			.create(ChoiceReactionTimeStimulusViewUiBinder.class);
	@UiField Label textChoice;

	interface ChoiceReactionTimeStimulusViewUiBinder extends
			UiBinder<Widget, ChoiceReactionTimeStimulusView> {
	}

	public ChoiceReactionTimeStimulusView() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public ChoiceReactionTimeStimulusView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setChoice(int choice) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showStimulus() {
		textChoice.setVisible(true);		
	}


	@Override
	public void hideStimulus() {
		textChoice.setVisible(false);		
	}


}
