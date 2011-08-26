package com.google.cognistats.client.gwtui.tests.results;

import java.util.ArrayList;

public class TSRTrialResult extends MultitrialTrialResult {
	protected boolean trialCorrect;
	protected long reactionTime;
	
	public boolean isTrialCorrect() {
		return trialCorrect;
	}
	public void setTrialCorrect(boolean trialCorrect) {
		this.trialCorrect = trialCorrect;
	}
	public long getReactionTime() {
		return reactionTime;
	}
	public void setReactionTime(long reactionTime) {
		this.reactionTime = reactionTime;
	}
	
	@Override
	protected ArrayList<String> attrs(ArrayList<String> a) {
		a = super.attrs(a);
		a.add("trialCorrect");
		a.add(String.valueOf(trialCorrect));
		a.add("reactionTime");
		a.add(String.valueOf(reactionTime));
		return a;
	}	
}
