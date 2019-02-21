package org.team.uroboros.uroboros.engine.utils.redux;

import org.team.uroboros.uroboros.engine.utils.QuadFunction;

@FunctionalInterface
public interface Middleware<State> extends QuadFunction<State, Action, Dispatch, Next<State>, Action> {

}
