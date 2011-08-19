package com.google.cognistats.client.gwtui.tests.results;

import java.util.ArrayList;
import java.util.LinkedList;

public class FingerTappingTrialResult extends MultitrialTrialResult {
	protected String hand;
	protected LinkedList<Integer> tapTimes;
	protected int duration;
	
	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LinkedList<Integer> getTapTimes() {
		return tapTimes;
	}

	public void setTapTimes(LinkedList<Integer> tapTimes) {
		this.tapTimes = tapTimes;
	}

	@Override
	protected ArrayList<String> attrs(ArrayList<String> a) {
		a.add("hand");
		a.add(String.valueOf(hand));
		a.add("tapTimes");
		a.add(String.valueOf(tapTimes));
		a.add("duration");
		a.add(String.valueOf(duration));
		return a;
	}

}
