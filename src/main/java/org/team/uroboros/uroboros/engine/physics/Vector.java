package org.team.uroboros.uroboros.engine.physics;

import org.dyn4j.geometry.Vector2;

public class Vector extends Vector2 {

	public Vector(double x, double y) {
		super(x, y);
	}

	public Vector(Vector2 vector) {
		super(vector.x, vector.y);
	}

}
