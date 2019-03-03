package org.team.uroboros.uroboros.engine.utils;

@FunctionalInterface
public interface Middleware<State> extends QuadFunction<State, Action, Dispatch, Next<State>, Action> {

}
