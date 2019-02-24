package org.team.uroboros.uroboros.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.team.uroboros.uroboros.engine.geometry.Transform;

public class GameObjectTest {

	@Test
	public void testCreateGameObject() {
		GameObject gameObject = new GameObject() {};
		assertEquals(1,gameObject.getComponents().size());
	}
	
	@Test
	public void testCreateGameObjectAndRemoveTransformBehaviorAndAddANewTransformBehavior() {
		GameObject gameObject = new GameObject() {};
		Transform transform = new Transform();
		gameObject.removeComponent(gameObject.getComponent(Transform.class));
		gameObject.addComponent(transform);
		assertEquals(transform, gameObject.getComponent(Transform.class));
		assertEquals(1,gameObject.getComponents().size());
	}

}
