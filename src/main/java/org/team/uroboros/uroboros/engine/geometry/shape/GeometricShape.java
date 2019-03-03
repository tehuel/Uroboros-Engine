package org.team.uroboros.uroboros.engine.geometry.shape;

import static org.team.uroboros.uroboros.engine.ui.resources.Color.BLUE;

import org.team.uroboros.uroboros.engine.ui.resources.Color;

public abstract class GeometricShape {

	private Color color;

	public GeometricShape() {
		this.color = BLUE;
	}

	public GeometricShape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

}
