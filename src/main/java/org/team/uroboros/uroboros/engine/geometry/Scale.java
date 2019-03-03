package org.team.uroboros.uroboros.engine.geometry;

import org.team.uroboros.uroboros.engine.utils.Pair;

public class Scale {

	private final Pair<Double, Double> pair;

	public Scale(double width, double height) {
		pair = new Pair<Double, Double>(width, height);
	}

	public double getXScale() {
		return pair.first();
	}

	public double getYScale() {
		return pair.second();
	}

	public Scale scale(double x, double y) {
		return new Scale(this.getXScale() + x, this.getYScale() + y);
	}

	public Scale scale(Scale scale) {
		return this.scale(scale.getXScale(), scale.getYScale());
	}

}
