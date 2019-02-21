package org.team.uroboros.uroboros.engine.utils.redux;

import org.team.uroboros.uroboros.engine.utils.TriFunction;

@FunctionalInterface
public interface Next<State> extends TriFunction<State, Action, Dispatch, Action> {

}
