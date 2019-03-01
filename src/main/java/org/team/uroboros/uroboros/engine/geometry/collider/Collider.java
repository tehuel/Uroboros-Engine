package org.team.uroboros.uroboros.engine.geometry.collider;

import org.dyn4j.dynamics.BodyFixture;
import org.team.uroboros.uroboros.engine.geometry.shape.Shape;

public abstract class Collider extends BodyFixture {

	public Collider(Shape shape) {
		super(shape.getConvex());
	}

}
