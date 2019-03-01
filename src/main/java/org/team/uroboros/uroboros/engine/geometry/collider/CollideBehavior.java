package org.team.uroboros.uroboros.engine.geometry.collider;

import org.dyn4j.collision.manifold.Manifold;
import org.dyn4j.collision.narrowphase.Penetration;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.CollisionListener;
import org.dyn4j.dynamics.contact.ContactConstraint;
import org.team.uroboros.uroboros.engine.GameObject;
import org.team.uroboros.uroboros.engine.MonoBehavior;
import org.team.uroboros.uroboros.engine.physics.World;
import org.team.uroboros.uroboros.engine.store.update.DeltaState;
import org.team.uroboros.uroboros.engine.ui.Graphics;

public abstract class CollideBehavior extends MonoBehavior implements CollisionListener {

	private boolean stopInteraction = false;

	@Override
	public boolean collision(Body body1, BodyFixture fixture1, Body body2, BodyFixture fixture2) {
		this.onCollide(null, null);
		return !stopInteraction;
	}

	@Override
	public boolean collision(Body body1, BodyFixture fixture1, Body body2, BodyFixture fixture2,
			Penetration penetration) {
		this.onCollide(null, penetration);
		return !stopInteraction;
	}

	@Override
	public boolean collision(Body body1, BodyFixture fixture1, Body body2, BodyFixture fixture2, Manifold manifold) {

		return !stopInteraction;
	}

	@Override
	public boolean collision(ContactConstraint contactConstraint) {

		return !stopInteraction;
	}

	@Override
	public void start() {
		World.getInstance().listenCollision(this);
	}

	@Override
	public void update(DeltaState deltaTime) {
		System.out.println(this.getGameObject().isDestructionPending());
	}

	@Override
	public void render(Graphics graphics) {

	}

	@Override
	public void onDisable() {

	}

	@Override
	public void onEnable() {

	}

	public abstract void onCollide(GameObject collider, Penetration penetration);

}
