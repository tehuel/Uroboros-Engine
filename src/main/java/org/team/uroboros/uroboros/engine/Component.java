package org.team.uroboros.uroboros.engine;

import org.team.uroboros.uroboros.engine.Object;

public abstract class Component extends Object {

	private GameObject gameObject;

	public GameObject getGameObject() {
		return gameObject;
	}

	public void attatch(GameObject gameObject) {
		this.gameObject = gameObject;
		this.onAttach();
	}

	public void dettatch(GameObject gameObject) {
		this.gameObject = null;
		this.onDettach();
	}

	protected abstract void onAttach();

	protected abstract void onDettach();

}
