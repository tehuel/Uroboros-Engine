package org.team.uroboros.uroboros.engine.utils;

import java.util.function.BiFunction;

@FunctionalInterface
public interface Reducer<State> extends BiFunction<State, Action, State> {

}
