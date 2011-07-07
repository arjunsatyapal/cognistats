package com.google.cognistats.client.gwtui.tests.stroop;

public enum StroopColor {
	RED("red", "#f00", StroopColor.redKeys),
	GREEN("green", "#0f0", StroopColor.greenKeys),
	BLUE("blue", "#00f", StroopColor.blueKeys);
	
	private final static char[] redKeys = {'1', 'r', 'R'};
	private final static char[] greenKeys = {'2', 'g', 'G'};
	private final static char[] blueKeys = {'3', 'b', 'B'};
	
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
