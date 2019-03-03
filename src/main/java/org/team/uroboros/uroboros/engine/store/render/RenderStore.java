package org.team.uroboros.uroboros.engine.store.render;

import org.team.uroboros.uroboros.engine.utils.Action;
import org.team.uroboros.uroboros.engine.utils.BasicStore;

public class RenderStore extends BasicStore<GraphicsState> {

	private static final RenderStore instance = new RenderStore();

	private RenderStore() {
		reducers.add(this::reduce);
	}

	public static RenderStore getInstance() {
		return instance;
	}

	@Override
	protected GraphicsState initialState() {
		return new GraphicsState(null, 0);
	}

	private GraphicsState reduce(GraphicsState state, Action action) {

		if (action instanceof Render) {
			Render render = ((Render) action);
			return new GraphicsState(render.graphics, render.fps);
		}

		return state;
	}

}
