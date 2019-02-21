package org.team.uroboros.uroboros.engine.physics;

public class World {

	private org.dyn4j.dynamics.World world;

	public World() {
		world = new org.dyn4j.dynamics.World();
	}

//	public void addBody(RigidBody body) {
//		world.addBody(body.wrappedObject);
//	}
//
//	public void removeBody(RigidBody body) {
//		world.removeBody(body.wrappedObject);
//	}

	public void removeAllBodies() {
		world.removeAllBodies();
	}

	public void update(Double deltaTime) {
		world.updatev(deltaTime);
	}

}
