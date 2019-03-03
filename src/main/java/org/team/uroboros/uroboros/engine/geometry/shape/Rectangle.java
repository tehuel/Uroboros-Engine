package org.team.uroboros.uroboros.engine.geometry.shape;

import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.ui.resources.Color;

public class Rectangle extends RectangularShape {

	public Rectangle(Dimension dimension) {
		super(dimension);
	}

	public Rectangle(Dimension dimension, Color color) {
		super(dimension, color);
	}

	public Rectangle(double width, double height) {
		super(width, height);
	}

	public Rectangle(double width, double height, Color color) {
		super(width, height, color);
	}

}
