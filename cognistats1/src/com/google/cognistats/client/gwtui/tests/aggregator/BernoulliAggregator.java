package com.google.cognistats.client.gwtui.tests.aggregator;

public class BernoulliAggregator {
	private int nTotal, nTrue;
	
	public BernoulliAggregator() {
		nTotal = 0;
		nTrue = 0;
	}
	
	public void add(boolean b) {
		++nTotal;
		if (b) {
			++nTrue;
		}
	}
	
	public double getFraction() {
		return (double)nTrue / (double)nTotal;
	}
}
