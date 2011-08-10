package com.google.cognistats.client.gwtui.tests.span.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.levelestimation.testwidget.LevelEstimationTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class SpanTestView extends View implements SpanTestDisplay {
	@UiField
	LevelEstimationTestView levelEstimationTest;
	
	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, SpanTestView> {
	}

	public SpanTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {		
	}

	@Override
	public LevelEstimationTestView getLevelEstimationTestView() {
		return levelEstimationTest;
	}


}
