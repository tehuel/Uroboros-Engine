package org.team.uroboros.uroboros.engine.utils;

@FunctionalInterface
public interface Next<State> extends TriFunction<State, Action, Dispatch, Action> {

}
