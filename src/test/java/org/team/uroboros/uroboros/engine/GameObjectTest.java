package org.team.uroboros.uroboros.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.team.uroboros.uroboros.engine.physics.RigidBody;

public class GameObjectTest {

	@Test
	public void testCreateGameObject() {
		GameObject gameObject = new GameObject() {};
		assertEquals(1,gameObject.getComponents().size());
	}
	
	@Test
	public void testCreateGameObjectAndRemoveTransformBehaviorAndAddANewTransformBehavior() {
		GameObject gameObject = new GameObject() {};
		RigidBody body = new RigidBody();
		gameObject.removeComponent(gameObject.getComponent(RigidBody.class));
		gameObject.addComponent(body);
		assertEquals(body, gameObject.getComponent(RigidBody.class));
		assertEquals(1,gameObject.getComponents().size());
	}

}
