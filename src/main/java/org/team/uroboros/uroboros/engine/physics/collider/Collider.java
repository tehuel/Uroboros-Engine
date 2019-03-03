package org.team.uroboros.uroboros.engine.physics.collider;

import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Convex;

public abstract class Collider extends BodyFixture {

	protected Convex shape;

	public Collider(Convex shape) {
		super(shape);
		this.shape = shape;
	}

}
