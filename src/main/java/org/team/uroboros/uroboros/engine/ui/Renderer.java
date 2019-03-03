package org.team.uroboros.uroboros.engine.ui;

import org.team.uroboros.uroboros.engine.Component;
import org.team.uroboros.uroboros.engine.store.render.RenderStore;
import org.team.uroboros.uroboros.engine.utils.Unsubscribe;

public abstract class Renderer extends Component {

	private final RenderStore store = RenderStore.getInstance();
	private Unsubscribe unsubscribe;

	@Override
	protected void onAttach() {
		unsubscribe = store.subscribe((state, dispatch) -> {
			if (!state.isEmpty()) {
				this.render(new Graphics(state));
			}
		});
	}

	@Override
	protected void onDettach() {
		unsubscribe.run();
	}

	protected abstract void render(Graphics graphics);

}
