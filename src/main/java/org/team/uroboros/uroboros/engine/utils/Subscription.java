package org.team.uroboros.uroboros.engine.utils;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface Subscription<State> extends BiConsumer<State, Dispatch> {

}