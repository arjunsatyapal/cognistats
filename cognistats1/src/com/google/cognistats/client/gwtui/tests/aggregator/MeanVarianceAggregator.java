package com.google.cognistats.client.gwtui.tests.aggregator;

public class MeanVarianceAggregator {
	
	private int nElements;
	private double sum;
	private double sumSquares;
	
	public MeanVarianceAggregator() {}
	
	public void add(double x) {
		++nElements;
		sum += x;
		sumSquares += x * x;
	}
	
	public double mean() {
		return (sum / nElements);
	}
	
	public double variance() {
		return (sumSquares - sum * sum / nElements) / nElements;
	}
	
}
