package org.team.uroboros.uroboros.engine.store.update;

import org.team.uroboros.uroboros.engine.utils.redux.Action;

public class Update implements Action {

	public final Double deltaTime;

	public Update(Double deltaTime) {
		this.deltaTime = deltaTime;
	}

}
