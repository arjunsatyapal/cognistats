package com.google.cognistats.client.gwtui.tests.stroop;

public enum StroopColor {
	RED("red"),
	GREEN("green"),
	BLUE("blue");
	
	private final String name;
	
	public String getName() {
		return name;
	}

	StroopColor(String name) {
		this.name = name;
	}
}
