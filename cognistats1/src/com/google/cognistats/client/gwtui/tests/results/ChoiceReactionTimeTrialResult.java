package com.google.cognistats.client.gwtui.tests.results;

public class ChoiceReactionTimeTrialResult extends ReactionTimeTrialResult {
	protected int trialType;
	protected int choice;
	
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	protected boolean ready;
	
	public int getTrialType() {
		return trialType;
	}
	public void setTrialType(int trialType) {
		this.trialType = trialType;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
}
