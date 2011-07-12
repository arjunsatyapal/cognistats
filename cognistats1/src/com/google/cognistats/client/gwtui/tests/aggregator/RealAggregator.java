package com.google.cognistats.client.gwtui.tests.aggregator;

public class RealAggregator {
	private MeanVarianceAggregator meanVarianceAggregator;
	private OrderAggregator orderAggregator;
	
	public RealAggregator() {
		meanVarianceAggregator = new MeanVarianceAggregator();
		orderAggregator = new OrderAggregator();
	}
	
	public void add(double x) {
		meanVarianceAggregator.add(x);
		orderAggregator.add(x);
	}
	
	public double mean() {
		return meanVarianceAggregator.mean();
	}
	
	public double variance() {
		return meanVarianceAggregator.variance();
	}
	
	public double quantile(double p) {
		return orderAggregator.quantile(p);
	}
	
	public double median() {
		return orderAggregator.median();
	}
}
