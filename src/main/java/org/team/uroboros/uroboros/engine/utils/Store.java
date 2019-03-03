package org.team.uroboros.uroboros.engine.utils;

public interface Store<State> {

	public Unsubscribe subscribe(Subscription<State> subscription);

}
