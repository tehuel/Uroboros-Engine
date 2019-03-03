package org.team.uroboros.uroboros.engine;

import org.team.uroboros.uroboros.engine.store.render.RenderStore;
import org.team.uroboros.uroboros.engine.store.update.DeltaState;
import org.team.uroboros.uroboros.engine.store.update.UpdateStore;
import org.team.uroboros.uroboros.engine.ui.Graphics;
import org.team.uroboros.uroboros.engine.utils.Unsubscribe;

public abstract class MonoBehavior extends Behavior {

	private final UpdateStore updateStore = UpdateStore.getInstance();
	private final RenderStore renderStore = RenderStore.getInstance();
	private Unsubscribe updateUnsubscribe;
	private Unsubscribe renderUnsubscribe;

	@Override
	protected void onAttach() {
		this.start();
		updateUnsubscribe = updateStore.subscribe((state, dispatch) -> this.update(state));
		renderUnsubscribe = renderStore.subscribe((state, dispatch) -> {
			if (!state.isEmpty()) {
				this.render(new Graphics(state));
			}
		});
	}

	@Override
	protected void onDettach() {
		updateUnsubscribe.run();
		renderUnsubscribe.run();
	}

	// Use this for initialization.
	public abstract void start();

	// Update is called once per frame.
	public abstract void update(DeltaState deltaTime);

	// Render is called once per frame.
	public abstract void render(Graphics graphics);

	// Executes when this component is disable.
	public abstract void onDisable();

	// Executes when this component is enable.
	public abstract void onEnable();

}
