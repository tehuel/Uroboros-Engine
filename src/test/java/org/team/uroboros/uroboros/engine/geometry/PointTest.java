package org.team.uroboros.uroboros.engine.geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PointTest {

	@Test
	void testCreateAPoint0XAnd0Y() {
		Point point = new Point(0, 0);
		assertEquals(0.0, point.getX().doubleValue());
		assertEquals(0.0, point.getY().doubleValue());
	}

	@Test
	void testCreateAPoint1XAnd1YButAssertFor0XAnd0Y() {
		Point point = new Point(1, 1);
		assertNotEquals(0.0, point.getX().doubleValue());
		assertNotEquals(0.0, point.getY().doubleValue());
	}

	@Test
	void testOriginEqualsPoint0XAnd0Y() {
		assertEquals(new Point(0, 0), Point.ORIGIN);
	}

	@Test
	void testPointRendersCorrectly() {
		assertEquals("Point[x=0.0,y=0.0]", Point.ORIGIN.toString());
	}

	@Test
	void testOriginDistanceWithPoint1X1YIsPoint1Y1Y() {
		assertEquals(new Point(1.0, 1.0), Point.ORIGIN.distance(new Point(1.0, 1.0)));
	}

	@Test
	void testOriginDistanceOnX1YIsPoint1Y1Y() {
		assertEquals(new Point(1.0, 1.0), Point.ORIGIN.distance(1.0, 1.0));
	}

	@Test
	void testOriginDistanceWithPoint1X1YIsPoint1Y1YButAssertForPoint2X1Y() {
		assertNotEquals(new Point(2.0, 1.0), Point.ORIGIN.distance(new Point(1.0, 1.0)));
	}

	@Test
	void testOriginDistanceOnOneStepOnWestIsMinus1X0Y() {
		assertEquals(new Point(-1.0, 0.0), Point.ORIGIN.distance(Direction.WEST, 1));
	}

	@Test
	void testOriginDistanceOnOneStepOnNorthIs0X1Y() {
		assertEquals(new Point(0.0, 1.0), Point.ORIGIN.distance(Direction.NORTH, 1));
	}

	@Test
	void testOriginDistanceOnOneStepOnEastIs1X0Y() {
		assertEquals(new Point(1.0, 0.0), Point.ORIGIN.distance(Direction.EAST, 1));
	}

	@Test
	void testOriginDistanceOnOneStepOnSouthIs0XMinus1Y() {
		assertEquals(new Point(0.0, -1.0), Point.ORIGIN.distance(Direction.SOUTH, 1));
	}

	@Test
	void testOriginIsInSamePositionWithPoint0X0Y() {
		assertTrue(Point.ORIGIN.isInPosition(new Point(0, 0)));
	}

	@Test
	void testOriginIsNotInSamePositionWithPoint1X1Y() {
		assertFalse(Point.ORIGIN.isInPosition(new Point(1, 1)));
	}

	@Test
	void testOriginIsNotInPosition5X3Y() {
		assertFalse(Point.ORIGIN.isInPosition(5.0, 3.0));
	}

}
