package org.team.uroboros.uroboros.engine.scene;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.team.uroboros.uroboros.engine.GameObject;

public class SceneTest {

	@Test
	public void testCreateGameSceneWithNoGameOjects() {
		Scene scene = new Scene() {};
		assertTrue(scene.isEmpty());
	}

	@Test
	public void testAddGameObjectOnScene() {
		Scene scene = new Scene() {};
		GameObject gameObject = new GameObject() {};
		scene.add(gameObject);
		assertEquals(gameObject, scene.getGameObjects().get(0));
		assertTrue(scene.contains(gameObject));
	}
	
	@Test
	public void testRemoveGameObjectsWithPendingOfDestruction() {
		Scene scene = new Scene() {};
		GameObject gameObject = new GameObject() {};
		gameObject.isDestructionPending = true;
		scene.removeGameObjectsWithPendingOfDestruction();
		assertTrue(scene.isEmpty());
	}
	
	@Test
	public void testNotRemoveAnyGameObjectWithPendingOfDestruction() {
		Scene scene = new Scene() {};
		GameObject gameObject = new GameObject() {};
		scene.add(gameObject);
		scene.removeGameObjectsWithPendingOfDestruction();
		assertEquals(gameObject, scene.getGameObjects().get(0));
		assertTrue(scene.contains(gameObject));
	}

}
