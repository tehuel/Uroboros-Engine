package org.team.uroboros.uroboros.engine.store.update;

import org.team.uroboros.uroboros.engine.utils.redux.Action;
import org.team.uroboros.uroboros.engine.utils.redux.BasicStore;

public class UpdateStore extends BasicStore<DeltaState> {

	private static final UpdateStore instance = new UpdateStore();

	private UpdateStore() {
		reducers.add(this::reduce);
	}

	public static UpdateStore getInstance() {
		return instance;
	}

	@Override
	protected DeltaState initialState() {
		return new DeltaState(0.0);
	}

	private DeltaState reduce(DeltaState state, Action action) {

		if (action instanceof Update) {
			return new DeltaState(((Update) action).deltaTime);
		}

		return state;
	}

}
