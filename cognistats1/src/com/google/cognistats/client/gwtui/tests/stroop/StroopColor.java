package com.google.cognistats.client.gwtui.tests.stroop;

public enum StroopColor {
	RED("red", "#f00", new char[] {'1', 'r', 'R'}),
	GREEN("green", "#0f0", new char[] {'2', 'g', 'G'}),
	BLUE("blue", "#00f", new char[] {'3', 'b', 'B'});
	
	private final String name, HTMLColor;
	private char[] keys;
	
	public String getName() {
		return name;
	}
	
	public String getHTMLColor() {
		return HTMLColor;
	}
	
	public char[] getKeys() {
		return keys;
	}
	
	public static StroopColor byNumber(int i) {
		return values()[i];
	}

	StroopColor(String name, String HTMLColor, char[] keys) {
		this.name = name;
		this.HTMLColor = HTMLColor;
		this.keys = keys;
	}
}
