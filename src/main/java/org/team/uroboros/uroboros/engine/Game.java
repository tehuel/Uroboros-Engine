package org.team.uroboros.uroboros.engine;

import org.team.uroboros.uroboros.engine.scene.Scene;
import org.team.uroboros.uroboros.engine.store.update.Update;
import org.team.uroboros.uroboros.engine.store.update.UpdateStore;
import org.team.uroboros.uroboros.engine.utils.Dispatch;

public abstract class Game {

	private final GameLoop loop;
	private final UpdateStore store = UpdateStore.getInstance();
	private Dispatch dispatch;
	private Scene currentGameScene;
	private String title = "";

	public Game(Scene initialScene) {
		loop = new GameLoop(this);
		currentGameScene = initialScene;
		store.subscribe((state, dispatch) -> this.dispatch = dispatch);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private void setScene(Scene scene) {
		currentGameScene = scene;
	}

	public Boolean isOnScene(Scene scene) {
		return scene == currentGameScene;
	}

	public Scene getCurrentGameScene() {
		return currentGameScene;
	}

	public void changeScene(Scene scene) {
		if (!this.isOnScene(scene)) {
			this.setScene(scene);
		}
	}

	public void update(double deltaTime) {
		currentGameScene.removeGameObjectsWithPendingOfDestruction();
		dispatch.accept(new Update(deltaTime));
	}

	public void start() {
		loop.run();
	}

}
