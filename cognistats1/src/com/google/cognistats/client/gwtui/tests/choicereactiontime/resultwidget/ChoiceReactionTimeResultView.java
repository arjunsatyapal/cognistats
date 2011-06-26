package com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget;

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
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Label;

public class ChoiceReactionTimeResultView extends Composite {

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


}
