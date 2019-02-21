package org.team.uroboros.uroboros.engine.ui;

import static org.team.uroboros.uroboros.engine.geometry.Point.ORIGIN;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.store.render.GraphicsState;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;

public class Graphics {

	Graphics2D graphics;

	public Graphics(GraphicsState state) {
		graphics = state.graphics;
	}

	private void renderOnLocalTransform(Point position, double rotation, Runnable runnable) {
		AffineTransform worldTransform = graphics.getTransform();
		AffineTransform localTransform = new AffineTransform();
		localTransform.translate(position.getX(), position.getY());
		localTransform.rotate(rotation);
		localTransform.rotate(Math.toRadians(180));
		graphics.transform(localTransform);
		runnable.run();
		graphics.setTransform(worldTransform);
	}

	public void render(Sprite sprite, Point position, Point center, double rotation) {
		this.renderOnLocalTransform(position, rotation, () -> {
			ImageObserver observer = null;
			int width = (int) Math.ceil(sprite.getWidth());
			int height = (int) Math.ceil(sprite.getHeight());
			int x = (int) Math.ceil((center.getX() - width) * 0.5);
			int y = (int) Math.ceil((center.getY() - height) * 0.5);
			graphics.drawImage(sprite.getSpriteImg(), x, y, width, height, observer);
		});
	}

	public void render(Sprite sprite, Point position, Point center) {
		this.render(sprite, position, center, 0.0);
	}

	public void render(Sprite sprite, Point position, double rotation) {
		this.render(sprite, position, ORIGIN, rotation);
	}

	public void render(Sprite sprite, Point position) {
		this.render(sprite, position, ORIGIN, 0.0);
	}

}
