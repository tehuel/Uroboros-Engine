package org.team.uroboros.uroboros.engine.geometry.shape;

import org.dyn4j.geometry.Geometry;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.ui.resources.Color;

public class Rectangle extends Shape {

	public Rectangle(double width, double height) {
		shape = Geometry.createRectangle(width, height);
	}

	public Rectangle(double width, double height, Color color) {
		super(color);
		shape = Geometry.createRectangle(width, height);
	}

	public Rectangle(Dimension dimension) {
		this(dimension.getWidth(), dimension.getHeight());
	}

	public Rectangle(Dimension dimension, Color color) {
		this(dimension.getWidth(), dimension.getHeight(), color);
	}

	public double getWidth() {
		org.dyn4j.geometry.Rectangle rectangle = (org.dyn4j.geometry.Rectangle) shape;
		return rectangle.getWidth();
	}

	public double getHeight() {
		org.dyn4j.geometry.Rectangle rectangle = (org.dyn4j.geometry.Rectangle) shape;
		return rectangle.getHeight();
	}

	public Double getRotation() {
		org.dyn4j.geometry.Rectangle rectangle = (org.dyn4j.geometry.Rectangle) shape;
		return rectangle.getRotation();
	}

}
