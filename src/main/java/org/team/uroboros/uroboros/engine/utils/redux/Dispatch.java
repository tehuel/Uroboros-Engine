package org.team.uroboros.uroboros.engine.utils.redux;

import java.util.function.Consumer;

@FunctionalInterface
public interface Dispatch extends Consumer<Action> {

}
