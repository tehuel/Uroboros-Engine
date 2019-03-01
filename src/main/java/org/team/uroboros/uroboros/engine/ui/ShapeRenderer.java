package org.team.uroboros.uroboros.engine.ui;

import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.geometry.shape.Rectangle;
import org.team.uroboros.uroboros.engine.geometry.shape.Shape;
import org.team.uroboros.uroboros.engine.physics.RigidBody;

public class ShapeRenderer extends Renderer {

	private Shape shape;

	public ShapeRenderer(Shape shape) {
		this.shape = shape;
	}

	@Override
	public void render(Graphics graphics) {
		RigidBody body = this.getGameObject().getComponent(RigidBody.class);

		if (shape instanceof Rectangle) {
			this.render(graphics, body.getPosition(), (Rectangle) shape);
		}

	}

	public void render(Graphics graphics, Point position, Rectangle rectangle) {
		graphics.render(rectangle, position, rectangle.getLocalCenter(), rectangle.getRotation(), rectangle.getColor(),
				true);
	}

}
