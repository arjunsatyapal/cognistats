package com.google.cognistats.client.gwtui.tests.results;

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
}
