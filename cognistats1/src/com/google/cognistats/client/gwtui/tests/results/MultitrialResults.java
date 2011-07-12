package com.google.cognistats.client.gwtui.tests.results;

import java.util.LinkedList;

public class MultitrialResults extends BaseResult {
	protected LinkedList<TrialResult> trialResults;

	public LinkedList<TrialResult> getTrialResults() {
		return trialResults;
	}

	public void setTrialResults(LinkedList<TrialResult> trialResults) {
		this.trialResults = trialResults;
	}
}
