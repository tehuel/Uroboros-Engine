package org.team.uroboros.uroboros.engine.ui.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorTest {

	@Test
	public void testNewColor() {
		Color color = new Color("#FF0F00");
		assertEquals("#FF0F00", color.hexCode());
	}

	@Test
	public void testWhiteColor() {
		assertEquals(Color.WHITE, new Color("#FFFFFF"));
	}

	@Test
	public void testLightGrayColor() {
		assertEquals(Color.LIGHTGRAY, new Color("#D3D3D3"));
	}

	@Test
	public void testGrayColor() {
		assertEquals(Color.GRAY, new Color("#808080"));
	}

	@Test
	public void testDarkGrayColor() {
		assertEquals(Color.DARKGRAY, new Color("#A9A9A9"));
	}

	@Test
	public void testBlackColor() {
		assertEquals(Color.BLACK, new Color("#000000"));
	}

	@Test
	public void testRedColor() {
		assertEquals(Color.RED, new Color("#FF0000"));
	}

	@Test
	public void testPinkColor() {
		assertEquals(Color.PINK, new Color("#FFC0CB"));
	}

	@Test
	public void testOrangeColor() {
		assertEquals(Color.ORANGE, new Color("#FFA500"));
	}

	@Test
	public void testYellowColor() {
		assertEquals(Color.YELLOW, new Color("#FFFF00"));
	}

	@Test
	public void testGreenColor() {
		assertEquals(Color.GREEN, new Color("#008000"));
	}

	@Test
	public void testMagentaColor() {
		assertEquals(Color.MAGENTA, new Color("#FF00FF"));
	}

	@Test
	public void testCyanColor() {
		assertEquals(Color.CYAN, new Color("#00FFFF"));
	}

	@Test
	public void testBlueColor() {
		assertEquals(Color.BLUE, new Color("#0000FF"));
	}

}
