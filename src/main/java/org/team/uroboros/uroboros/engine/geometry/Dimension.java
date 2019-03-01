package org.team.uroboros.uroboros.engine.geometry;

import org.team.uroboros.uroboros.engine.utils.Pair;

public class Dimension {

	private final Pair<Double, Double> pair;

	public Dimension(double width, double height) {
		pair = new Pair<Double, Double>(width, height);
	}

	public Double getWidth() {
		return pair.first();
	}

	public Double getHeight() {
		return pair.second();
	}

	@Override
	public String toString() {
		return "Dimension[width=" + this.getWidth() + "," + "height=" + this.getHeight() + "]";
	}

}
