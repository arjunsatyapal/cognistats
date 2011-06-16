package com.google.cognistats.client.gwtui.mainscreen;

import static com.google.cognistats.shared.enums.ServletPaths.LOGIN_GOOGLE;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;

public class MainScreenView extends Composite  {
	@UiField
	MenuItem menuItemLogin;
	
	private static MainScreenUiBinder uiBinder = GWT
			.create(MainScreenUiBinder.class);

	interface MainScreenUiBinder extends UiBinder<Widget, MainScreenView> {
	}

	public MainScreenView() {
		initWidget(uiBinder.createAndBindUi(this));
		menuItemLogin.setCommand(new Command() {
			
			@Override
			public void execute() {
				Window.Location.assign(LOGIN_GOOGLE.getRelativePath());
			}
		});
	}
}
