package org.team.uroboros.uroboros.engine.ui;

import static org.team.uroboros.uroboros.engine.geometry.Point.ORIGIN;
import static java.awt.Color.decode;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.geometry.shape.RectangularShape;
import org.team.uroboros.uroboros.engine.store.render.GraphicsState;
import org.team.uroboros.uroboros.engine.ui.resources.Color;
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

	public void render(Sprite sprite, Point position, Point center, Double rotation) {
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

	public void render(Sprite sprite, Point position, Double rotation) {
		this.render(sprite, position, ORIGIN, rotation);
	}

	public void render(Sprite sprite, Point position) {
		this.render(sprite, position, ORIGIN, 0.0);
	}

	public void render(RectangularShape shape, Point position, Point center, Double rotation, Color color,
			Boolean fill) {
		this.renderOnLocalTransform(position, rotation, () -> {
			int width = (int) Math.ceil(shape.getWidth());
			int height = (int) Math.ceil(shape.getHeight());
			int x = (int) Math.ceil((center.getX() - width) * 0.5);
			int y = (int) Math.ceil((center.getY() - height) * 0.5);
			graphics.setColor(decode(color.hexCode()));
			graphics.drawRect(x, y, width, height);
			if (fill) {
				graphics.fillRect(x, y, width, height);
			}
		});
	}

	public void render(RectangularShape shape, Point position, Point center, Color color, Boolean fill) {
		this.render(shape, position, center, 0.0, color, fill);
	}

	public void render(RectangularShape shape, Point position, Double rotation, Color color, Boolean fill) {
		this.render(shape, position, ORIGIN, rotation, color, fill);
	}

	public void render(RectangularShape shape, Point position, Color color, Boolean fill) {
		this.render(shape, position, ORIGIN, 0.0, color, fill);
	}

}
