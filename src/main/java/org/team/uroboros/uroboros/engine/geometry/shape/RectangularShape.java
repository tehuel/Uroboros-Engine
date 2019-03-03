package org.team.uroboros.uroboros.engine.geometry.shape;

import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.ui.resources.Color;

public class RectangularShape extends GeometricShape {

	private Dimension dimension;

	public RectangularShape(Dimension dimension) {
		super();
		this.setDimension(dimension);
	}

	public RectangularShape(Dimension dimension, Color color) {
		super(color);
		this.setDimension(dimension);
	}

	public RectangularShape(double width, double height) {
		this(new Dimension(width, height));
	}

	public RectangularShape(double width, double height, Color color) {
		this(new Dimension(width, height), color);
	}

	public Dimension getDimension() {
		return dimension;
	}

	private void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public double getWidth() {
		return dimension.getWidth();
	}

	public double getHeight() {
		return dimension.getHeight();
	}

}
