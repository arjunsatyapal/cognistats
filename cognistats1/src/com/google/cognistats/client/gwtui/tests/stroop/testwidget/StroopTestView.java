package com.google.cognistats.client.gwtui.tests.stroop.testwidget;

import static com.google.cognistats.client.resources.GlobalResources.RESOURCE;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestView;
import com.google.cognistats.client.gwtui.tests.stroop.StroopColor;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;

public class StroopTestView extends View implements StroopTestDisplay {
	@UiField
	TSRTestView tsrTest;
	@UiField Label stroopLabel;
	@UiField HTML stroopWord;
	@UiField Label commentLabel;
	
	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, StroopTestView> {
	}

	public StroopTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {		
	}


	@Override
	public TSRTestView getTSRTestView() {
		return tsrTest;
	}

	@Override
	public void setWordAndColor(String word, StroopColor color) {
		stroopWord.setHTML("<span style=\"font-size: 32pt; color:" + color.getHTMLColor() + ";\">" + word + "</span>");
//		stroopLabel.setText(word);
//		stroopLabel.setStyleName(RESOURCE.globalStyle().stroopword());
//		stroopLabel.addStyleName(color.getStyleName());
		//stroopLabel.addStyleName(color.getName());
	}

	@Override
	public void setWordVisible(boolean visible) {
		//stroopLabel.setVisible(visible);
		stroopWord.setHTML("");
	}

	@Override
	public void setTrialInstructions(String instructions) {
		stroopLabel.setText(instructions);
		
	}

	@Override
	public void setCommentText(String commentText) {
		commentLabel.setText(commentText);
	}


}
