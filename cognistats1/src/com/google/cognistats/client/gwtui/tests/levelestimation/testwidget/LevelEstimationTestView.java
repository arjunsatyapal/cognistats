package com.google.cognistats.client.gwtui.tests.levelestimation.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.tsr.testwidget.TSRTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class LevelEstimationTestView extends View implements LevelEstimationTestDisplay {
	@UiField
	TSRTestView tsrTest;
	
	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, LevelEstimationTestView> {
	}

	public LevelEstimationTestView() {
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
