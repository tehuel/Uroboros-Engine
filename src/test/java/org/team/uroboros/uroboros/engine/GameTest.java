package org.team.uroboros.uroboros.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.team.uroboros.uroboros.engine.scene.Scene;

public class GameTest {

	@Test
	public void testCreateANewGameWithScene() {
		Scene scene = new Scene() {};
		Game game = new Game(scene) {};
		assertTrue(game.isOnScene(scene));
		assertEquals(scene, game.getCurrentGameScene());
	}
	
	@Test
	public void testCurrentGameSceneIsNotThatScene() {
		Scene scene = new Scene() {};
		Scene anotherScene = new Scene() {};
		Game game = new Game(scene) {};
		assertFalse(game.isOnScene(anotherScene));
	}
	
	@Test
	public void testChangeSceneForAnotherScene() {
		Scene scene = new Scene() {};
		Scene anotherScene = new Scene() {};
		Game game = new Game(scene) {};
		game.changeScene(anotherScene);
		assertFalse(game.isOnScene(scene));
		assertTrue(game.isOnScene(anotherScene));
		assertNotEquals(scene, game.getCurrentGameScene());
		assertEquals(anotherScene, game.getCurrentGameScene());
	}
	
	@Test
	public void testChangeSceneForSameSceneHaveNotChangeCurrentScene() {
		Scene scene = new Scene() {};
		Game game = new Game(scene) {};
		game.changeScene(scene);
		assertTrue(game.isOnScene(scene));
		assertEquals(scene, game.getCurrentGameScene());
	}
	
	
	@Test
	public void testGameTitle() {
		Game game = new Game(null) {};
		game.setTitle("Game's title");
		assertEquals("Game's title", game.getTitle());
	}

}
