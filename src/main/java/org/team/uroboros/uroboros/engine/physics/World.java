package org.team.uroboros.uroboros.engine.physics;

import org.dyn4j.geometry.Vector2;

public class World {

	private org.dyn4j.dynamics.World world;
	private static final World instance = new World();
	public static final Vector2 EARTH_GRAVITY = new Vector2(0.0, -9.8);
	public static final Vector2 ZERO_GRAVITY = new Vector2(0.0, 0.0);

	private World() {
		world = new org.dyn4j.dynamics.World();
	}

	public static World getInstance() {
		return instance;
	}

	public void addBody(RigidBody rigidBody) {
		world.addBody(rigidBody.body);
	}

	public void removeBody(RigidBody rigidBody) {
		world.removeBody(rigidBody.body);
	}

	public void removeAllBodies() {
		world.removeAllBodies();
	}

	public void update(Double deltaTime) {
		world.updatev(deltaTime);
	}

}
