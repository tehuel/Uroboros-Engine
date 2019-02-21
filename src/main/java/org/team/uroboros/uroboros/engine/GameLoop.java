package org.team.uroboros.uroboros.engine;

//import org.team.uroboros.uroboros.engine.physics.World;
import org.team.uroboros.uroboros.engine.ui.GameUI;

public class GameLoop implements Runnable {

	private volatile Thread loopThread = new Thread(this);
//	private final World world = new World();
	private final GameUI ui = new GameUI();
	private final Game game;
	private Integer ups = 60;
	private Integer fps = 60;
	private Integer fpsCount = 0;
	private Boolean isRunning = false;

	public GameLoop(Game game) {
		this.game = game;
		loopThread.setDaemon(true);
	}

	private void loop() {
		long initialTime = System.nanoTime();
		double timeU = 1000000000.0 / ups;
		double timeF = 1000000000.0 / fps;
		double deltaU = 0.0;
		double deltaF = 0.0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		isRunning = true;

		ui.open();

		while (isRunning) {

			long currentTime = System.nanoTime();
			deltaU += (currentTime - initialTime) / timeU;
			deltaF += (currentTime - initialTime) / timeF;
			initialTime = currentTime;

			if (deltaU >= 1) {
				this.update(deltaU);
				deltaU--;
			}

			if (deltaF >= 1) {
				this.render(fpsCount);
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				fpsCount = frames;
				frames = 0;
				timer += 1000;
			}

			sleep(initialTime, deltaU);
		}
	}

	private void sleep(Long lastLoopTime, Double OPTIMAL_TIME) {
		try {
			Thread.sleep((long) Math.max(0, ((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000)));
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void render(Integer fps) {
		ui.render(fps);
	}

	private void update(Double deltaTime) {
//		world.update(deltaTime);
		game.update(deltaTime);
	}

	public void pause() {

	}

	public void resume() {

	}

	public void end() {
		isRunning = false;
	}

	public Boolean isRunning() {
		return isRunning;
	}

	@Override
	public void run() {
		this.loop();
	}

}
