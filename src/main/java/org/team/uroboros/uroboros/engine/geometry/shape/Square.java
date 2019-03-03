package org.team.uroboros.uroboros.engine.geometry.shape;

import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.ui.resources.Color;

public class Square extends RectangularShape {

	public Square(double side) {
		super(new Dimension(side, side));
	}

	public Square(double side, Color color) {
		super(new Dimension(side, side), color);
	}

}
