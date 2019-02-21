package org.team.uroboros.uroboros.engine.utils.redux;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicStore<State> implements Store<State> {

	private State state;
	private final List<Subscription<State>> subscriptions = new ArrayList<>();
	protected final List<Reducer<State>> reducers = new ArrayList<>();
	protected final List<Middleware<State>> middleware = new ArrayList<>();

	public BasicStore() {
		state = this.initialState();
	}

	protected abstract State initialState();

	private void dispatch(Action action) {
		final Action newAction = applyMiddleware(state, action);
		final State newState = applyReducers(state, newAction);
		if (newState != state) {
			state = newState;
			subscriptions.forEach(subscription -> subscription.accept(state, this::dispatch));
		}
	}

	private State applyReducers(State current, Action action) {
		State newState = current;

		for (Reducer<State> reducer : reducers) {
			newState = reducer.apply(newState, action);
		}

		return newState;

	}

	private Action applyMiddleware(State state, Action action) {
		return this.next(0).apply(state, action, this::dispatch);
	}

	private Next<State> next(Integer index) {
		if (index == middleware.size()) {
			return (state, action, dispatch) -> action;
		}
		return (state, action, dispatch) -> middleware.get(index).apply(state, action, dispatch, this.next(index + 1));
	}

	@Override
	public Unsubscribe subscribe(Subscription<State> subscription) {
		subscriptions.add(subscription);
		subscription.accept(state, this::dispatch);
		return () -> subscriptions.remove(subscription);
	}

}
