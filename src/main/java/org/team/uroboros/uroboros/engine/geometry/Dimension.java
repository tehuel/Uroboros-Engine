package org.team.uroboros.uroboros.engine.geometry;

import org.team.uroboros.uroboros.engine.utils.Pair;

public class Dimension {

	private final Pair<Integer, Integer> pair;

	public Dimension(Integer width, Integer height) {
		pair = new Pair<Integer, Integer>(width, height);
	}

	public Integer getWidth() {
		return pair.first();
	}

	public Integer getHeight() {
		return pair.second();
	}

	@Override
	public String toString() {
		return "Dimension[width=" + this.getWidth() + "," + "height=" + this.getHeight() + "]";
	}

}
