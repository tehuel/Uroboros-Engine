package org.team.uroboros.uroboros.engine.geometry;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DimensionTest {

	@Test
	public void testCreateADimensionWithWidth800And600Height() {
		Dimension dimension = new Dimension(800, 600);
		assertEquals(800, dimension.getWidth().intValue());
		assertEquals(600, dimension.getHeight().intValue());
	}

	@Test
	public void testDimensionRendersCorrectly() {
		Dimension dimension = new Dimension(800, 600);
		assertEquals("Dimension[width=800,height=600]", dimension.toString());
	}

}
