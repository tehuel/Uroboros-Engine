package org.team.uroboros.uroboros.engine.ui;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import org.team.uroboros.uroboros.engine.geometry.Point;

public class ViewPort {

	private Point transformation;
	private Point rotation;
	private Point scale;

	public ViewPort(double width, double height) {
		transformation = new Point(width * 0.5, (height * 0.5) * -1);
		rotation = new Point(0, 0);
		scale = new Point(1, -1);
	}

	public void transform(Graphics2D graphics) {
		graphics.transform(AffineTransform.getScaleInstance(scale.getX(), scale.getY()));
		graphics.transform(AffineTransform.getRotateInstance(rotation.getX(), rotation.getY()));
		graphics.transform(AffineTransform.getTranslateInstance(transformation.getX(), transformation.getY()));
	}

}
