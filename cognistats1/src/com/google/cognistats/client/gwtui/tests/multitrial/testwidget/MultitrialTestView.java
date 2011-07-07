package com.google.cognistats.client.gwtui.tests.multitrial.testwidget;

import com.google.cognistats.client.gwtui.mvpinterfaces.View;
import com.google.cognistats.client.gwtui.tests.basetest.testwidget.BaseTestView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class MultitrialTestView extends View implements MultitrialTestDisplay {
	@UiField
	BaseTestView baseTest;
	
	private static MultitrialTestViewUiBinder uiBinder = GWT
			.create(MultitrialTestViewUiBinder.class);

	interface MultitrialTestViewUiBinder extends UiBinder<Widget, MultitrialTestView> {
	}

	public MultitrialTestView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
//		baseTest.getFixationPlus().
		
	}


	@Override
	public BaseTestView getBaseTestView() {
		return baseTest;
	}


}
