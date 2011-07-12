package com.google.cognistats.client.gwtui.tests.aggregator;

import java.util.ArrayList;

public class OrderAggregator {
	private ArrayList<Double> elements;
	
	public OrderAggregator() {
		elements = new ArrayList<Double>();
	}
	
	public void add(double x) {
		// add element, keeping the array sorted
		if ((elements.size() == 0) || (x <= elements.get(0))) {
			elements.add(0, x);
		}
		else {
			int i = 0;
			while ((i < elements.size()) && (elements.get(i) < x)) {
				++i;
			}
			elements.add(i, x);
		}
	}
	
	public double quantile(double p) {
		double h = p * (elements.size() - 1);
		int ih = (int)Math.round(Math.floor(h));
		double frac = h - ih;
		if ((ih + 1) == elements.size()) {
			return elements.get(ih);
		}
		return (1 - frac) * elements.get(ih) + frac * elements.get(ih + 1);
	}
	
	public double median() {
		return quantile(0.5);
	}
}
