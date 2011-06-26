package com.google.cognistats.client.gwtui.tests.choicereactiontime.simplereactiontime.statisticswidget;

import com.google.cognistats.client.gwtui.tests.choicereactiontime.resultwidget.ChoiceReactionTimeResultView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class SimpleReactionTimeStatisticsView extends ChoiceReactionTimeResultView {

	private static SimpleReactionTimeResultViewUiBinder uiBinder = GWT
			.create(SimpleReactionTimeResultViewUiBinder.class);

	interface SimpleReactionTimeResultViewUiBinder extends
			UiBinder<Widget, SimpleReactionTimeStatisticsView> {
	}

	public SimpleReactionTimeStatisticsView() {
		super();
		//initWidget(uiBinder.createAndBindUi(this));
	}

}
