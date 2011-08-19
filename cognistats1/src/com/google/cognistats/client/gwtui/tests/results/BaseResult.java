package com.google.cognistats.client.gwtui.tests.results;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class BaseResult implements TestResult {
	protected boolean testComplete;
	protected long timeInTest;
	protected long seed;
	
	public long getSeed() {
		return seed;
	}
	public void setSeed(long seed) {
		this.seed = seed;
	}
	public boolean isTestComplete() {
		return testComplete;
	}
	public void setTestComplete(boolean testComplete) {
		this.testComplete = testComplete;
	}
	public long getTimeInTest() {
		return timeInTest;
	}
	public void setTimeInTest(long timeInTest) {
		this.timeInTest = timeInTest;
	}
	
	protected ArrayList<String> attrs(ArrayList<String> a) {
		a.add("testComplete");
		a.add(String.valueOf(testComplete));
		a.add("timeInTest");
		a.add(String.valueOf(timeInTest));
		a.add("seed");
		a.add(String.valueOf(seed));
		return a;
	}
	
	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName());
		sb.append(" {" );
		ArrayList<String> a = attrs(new ArrayList<String>());
		for(int i = 0; i < a.size(); i += 2) {
			sb.append(a.get(i));
			sb.append(": ");
			sb.append(a.get(i+1));
			if(i < a.size() - 2)
				sb.append(", ");
		}
		sb.append("}");
		return sb.toString();
	}
}
