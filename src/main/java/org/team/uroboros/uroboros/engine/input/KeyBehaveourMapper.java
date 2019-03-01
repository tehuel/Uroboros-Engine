package org.team.uroboros.uroboros.engine.input;

import org.team.uroboros.uroboros.engine.MonoBehavior;
import org.team.uroboros.uroboros.engine.input.Key;
import org.team.uroboros.uroboros.engine.store.update.DeltaState;
import org.team.uroboros.uroboros.engine.ui.Graphics;

public class KeyBehaveourMapper extends MonoBehavior {

	private MonoBehavior behaveour;
	private Key key;

	public KeyBehaveourMapper(Key key, MonoBehavior behaveour) {
		this.behaveour = behaveour;
		this.key = key;
	}

	@Override
	public void start() {
		this.behaveour.attatch(this.getGameObject());
		this.behaveour.start();
	}

	@Override
	public void update(DeltaState deltaTime) {
		if (this.key.isPressed()) {
			this.behaveour.update(deltaTime);
		}
	}

	@Override
	public void render(Graphics graphics) {
		this.behaveour.render(graphics);
	}

	@Override
	public void onDisable() {
		this.behaveour.onDisable();
	}

	@Override
	public void onEnable() {
		this.behaveour.onEnable();
	}

}
