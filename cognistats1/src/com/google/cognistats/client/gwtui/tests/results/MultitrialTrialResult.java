package com.google.cognistats.client.gwtui.tests.results;

import java.util.ArrayList;

public class MultitrialTrialResult implements TrialResult {
	protected int trialNumber;

	public int getTrialNumber() {
		return trialNumber;
	}

	public void setTrialNumber(int trialNumber) {
		this.trialNumber = trialNumber;
	}
	
	protected ArrayList<String> attrs(ArrayList<String> a) {
		a.add("trialNumber");
		a.add(String.valueOf(trialNumber));
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
