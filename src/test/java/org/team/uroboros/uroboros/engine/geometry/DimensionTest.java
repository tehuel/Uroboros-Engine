package org.team.uroboros.uroboros.engine.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DimensionTest {

	@Test
	public void testCreateADimensionWithWidth800And600Height() {
		Dimension dimension = new Dimension(800, 600);
		assertEquals(800, dimension.getWidth().doubleValue(), 1);
		assertEquals(600, dimension.getHeight().doubleValue(), 1);
	}

	@Test
	public void testDimensionRendersCorrectly() {
		Dimension dimension = new Dimension(800, 600);
		assertEquals("Dimension[width=800.0,height=600.0]", dimension.toString());
	}

}
