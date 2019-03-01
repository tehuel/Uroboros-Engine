package org.team.uroboros.uroboros.engine.ui;

import org.team.uroboros.uroboros.engine.physics.RigidBody;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;

public class SpriteRenderer extends Renderer {

	private Sprite sprite;

	public SpriteRenderer(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void render(Graphics graphics) {
		RigidBody body = this.getGameObject().getComponent(RigidBody.class);
		graphics.render(sprite, body.getPosition(), body.getLocalCenter(), body.getRotation());
	}

}
