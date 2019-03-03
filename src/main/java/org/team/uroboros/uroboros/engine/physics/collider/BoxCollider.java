package org.team.uroboros.uroboros.engine.physics.collider;

import org.dyn4j.geometry.Geometry;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.shape.Rectangle;

public class BoxCollider extends Collider {

	public BoxCollider(Rectangle rectangle) {
		super(Geometry.createRectangle(rectangle.getWidth(), rectangle.getHeight()));
	}

	public BoxCollider(Dimension dimension) {
		super(Geometry.createRectangle(dimension.getWidth(), dimension.getHeight()));
	}

	public BoxCollider(double width, double height) {
		super(Geometry.createRectangle(width, height));
	}

}
