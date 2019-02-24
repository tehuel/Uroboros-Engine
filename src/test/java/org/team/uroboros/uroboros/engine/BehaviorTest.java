package org.team.uroboros.uroboros.engine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BehaviorTest {

	@Test
	public void testBehaviorIsEnable() {
		Behavior behavior = new Behavior() {

			@Override
			protected void onDettach() {

			}

			@Override
			protected void onAttach() {

			}

		};
		behavior.enabled = true;
		assertTrue(behavior.enabled);
	}

	@Test
	public void testBehaviorIsDisable() {
		Behavior behavior = new Behavior() {

			@Override
			protected void onDettach() {

			}

			@Override
			protected void onAttach() {

			}

		};
		assertFalse(behavior.enabled);
	}

}
