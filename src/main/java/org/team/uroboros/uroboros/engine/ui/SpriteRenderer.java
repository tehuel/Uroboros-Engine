package org.team.uroboros.uroboros.engine.ui;

import org.team.uroboros.uroboros.engine.geometry.Transform;
import org.team.uroboros.uroboros.engine.ui.resources.Sprite;

public class SpriteRenderer extends Renderer {

	private Sprite sprite;

	public SpriteRenderer(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void render(Graphics graphics) {
		Transform transform = this.getGameObject().getComponent(Transform.class);
		graphics.render(sprite, transform.getPosition(), transform.getLocalCenter(), transform.getRotation());
	}

}
