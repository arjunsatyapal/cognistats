package com.google.cognistats.client.gwtui.tests.results;

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
}
