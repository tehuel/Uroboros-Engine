package org.team.uroboros.uroboros.engine.utils.redux;

public interface Store<State> {

	public Unsubscribe subscribe(Subscription<State> subscription);

}
