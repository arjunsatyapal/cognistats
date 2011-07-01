package com.google.cognistats.client.gwtui.tests.tsr.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.multitrial.testwidget.MultitrialTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class TSRTestView extends View implements TSRTestDisplay {
	@UiField
	MultitrialTestView multitrialTest;
	
	private static BaseTestViewUiBinder uiBinder = GWT
			.create(BaseTestViewUiBinder.class);

	interface BaseTestViewUiBinder extends UiBinder<Widget, TSRTestView> {
	}

	public TSRTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {		
	}

	@Override
	public MultitrialTestView getMultitrialTestView() {
		// TODO Auto-generated method stub
		return multitrialTest;
	}


}
