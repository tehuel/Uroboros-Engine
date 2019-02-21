package org.team.uroboros.uroboros.engine.scene;

import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.GameObject;

public abstract class Scene {

	private List<GameObject> gameObjects = new ArrayList<>();

	public List<GameObject> getGameObject() {
		return gameObjects;
	}

	public void add(GameObject gameObject) {
		gameObjects.add(gameObject);
	}

	public void removeGameObjectsWithPendingOfDestruction() {
		gameObjects.removeIf(gameObject -> gameObject.isDestructionPending);
	}

}
