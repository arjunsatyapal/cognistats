package com.google.cognistats.client.gwtui.tests.results;

import java.util.ArrayList;

public class StroopTrialResult extends TSRTrialResult {
	protected String testPart;
	public String getTestPart() {
		return testPart;
	}
	public void setTestPart(String testPart) {
		this.testPart = testPart;
	}
	public int getTrialNumberWithinPart() {
		return trialNumberWithinPart;
	}
	public void setTrialNumberWithinPart(int trialNumberWithinPart) {
		this.trialNumberWithinPart = trialNumberWithinPart;
	}
	public boolean isConcordant() {
		return isConcordant;
	}
	public void setConcordant(boolean isConcordant) {
		this.isConcordant = isConcordant;
	}
	public boolean isTrialColor() {
		return trialIsColor;
	}
	public void setTrialIsColor(boolean trialIsColor) {
		this.trialIsColor = trialIsColor;
	}
	protected int trialNumberWithinPart;
	protected boolean isConcordant;
	protected boolean trialIsColor;
	
	@Override
	protected ArrayList<String> attrs(ArrayList<String> a) {
		a = super.attrs(a);
		a.add("testPart");
		a.add(testPart);
		a.add("trialNumberWithinPart");
		a.add(String.valueOf(trialNumberWithinPart));
		a.add("isConcordant");
		a.add(String.valueOf(isConcordant));
		a.add("trialIsColor");
		a.add(String.valueOf(trialIsColor));
		return a;
	}
}
