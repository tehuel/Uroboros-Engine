package org.team.uroboros.uroboros.engine.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PairTest {

	@Test
	public void testCreateIntegerStringPair() {
		Pair<Integer, String> pair = new Pair<Integer, String>(7, "Seven");
		assertEquals(7, pair.first().intValue());
		assertEquals("Seven", pair.second());
	}

}
