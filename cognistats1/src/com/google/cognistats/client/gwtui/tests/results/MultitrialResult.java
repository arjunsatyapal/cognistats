package com.google.cognistats.client.gwtui.tests.results;

import java.util.ArrayList;
import java.util.LinkedList;

public class MultitrialResult extends BaseResult {
	protected LinkedList<TrialResult> trialResults;

	public LinkedList<TrialResult> getTrialResults() {
		return trialResults;
	}

	public void setTrialResults(LinkedList<TrialResult> trialResults) {
		this.trialResults = trialResults;
	}
	
	
	@Override
	protected ArrayList<String> attrs(ArrayList<String> a) {
		a = super.attrs(a);
		a.add("trialResults");
		a.add("(" + trialResults.size() + " results)");//String.valueOf(trialResults));
		return a;
	}

}
