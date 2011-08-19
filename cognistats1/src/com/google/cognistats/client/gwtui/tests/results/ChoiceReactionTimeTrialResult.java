package com.google.cognistats.client.gwtui.tests.results;

import java.util.ArrayList;

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
	
	@Override
	protected ArrayList<String> attrs(ArrayList<String> a) {
		a = super.attrs(a);
		a.add("trialType");
		a.add(String.valueOf(trialType));
		a.add("choice");
		a.add(String.valueOf(choice));
		return a;
	}

}
