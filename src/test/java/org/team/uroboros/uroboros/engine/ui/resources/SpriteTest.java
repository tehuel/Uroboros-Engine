package org.team.uroboros.uroboros.engine.ui.resources;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.team.uroboros.uroboros.engine.geometry.Dimension;

public class SpriteTest {

	@Test
	public void testCreateSpriteWithDimension() {
		Dimension dimension = new Dimension(20, 10);
		Sprite sprite = new Sprite("Test.png", dimension);
		assertEquals(20, sprite.getWidth().intValue());
		assertEquals(10, sprite.getHeight().intValue());
		assertEquals(dimension, sprite.getDimension());
		assertEquals("Test.png", sprite.getPath());
		assertNotEquals(null, sprite.getSpriteImg());
	}

	@Test
	public void testCreateSpriteWithXY() {
		Sprite sprite = new Sprite("Test.png", 20, 10);
		assertEquals(20, sprite.getWidth().intValue());
		assertEquals(10, sprite.getHeight().intValue());
		assertEquals("Test.png", sprite.getPath());
		assertNotEquals(null, sprite.getSpriteImg());
	}

	@Test
	public void testCreateSpriteWithWrongImagePath() {
		Sprite sprite = new Sprite("WorngPath.png", 20, 10);
		assertNull(sprite.getSpriteImg());
	}

}
