package org.team.uroboros.uroboros.engine.geometry.collider;

import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.shape.Rectangle;

public class BoxCollider extends Collider {

	public BoxCollider(Rectangle rectangle) {
		super(rectangle);
	}

	public BoxCollider(Dimension dimension) {
		super(new Rectangle(dimension));
	}

	public BoxCollider(double width, double height) {
		super(new Rectangle(width, height));
	}

}
