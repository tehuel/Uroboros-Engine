package org.team.uroboros.uroboros.engine.geometry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.team.uroboros.uroboros.engine.physics.Vector;

public class PointTest {

	@Test
	public void testCreateAPoint0XAnd0Y() {
		Point point = new Point(0, 0);
		assertEquals(0.0, point.getX().doubleValue(), 1);
		assertEquals(0.0, point.getY().doubleValue(), 1);
	}

	@Test
	public void testCreateAPointFromAVector() {
		Vector vector = new Vector(5.5, 7.7);
		Point point = new Point(vector);
		assertEquals(5.5, point.getX().doubleValue(), 1);
		assertEquals(7.7, point.getY().doubleValue(), 1);
	}

	@Test
	public void testCreateAPoint1XAnd1YButAssertFor0XAnd0Y() {
		Point point = new Point(1, 1);
		assertNotEquals(0.0, point.getX().doubleValue());
		assertNotEquals(0.0, point.getY().doubleValue());
	}

	@Test
	public void testOriginEqualsPoint0XAnd0Y() {
		assertEquals(new Point(0, 0), Point.ORIGIN);
	}

	@Test
	public void testPointRendersCorrectly() {
		assertEquals("Point[x=0.0,y=0.0]", Point.ORIGIN.toString());
	}

	@Test
	public void testOriginDistanceWithPoint1X1YIsPoint1Y1Y() {
		assertEquals(new Point(1.0, 1.0), Point.ORIGIN.distance(new Point(1.0, 1.0)));
	}

	@Test
	public void testOriginDistanceOnX1YIsPoint1Y1Y() {
		assertEquals(new Point(1.0, 1.0), Point.ORIGIN.distance(1.0, 1.0));
	}

	@Test
	public void testOriginDistanceWithPoint1X1YIsPoint1Y1YButAssertForPoint2X1Y() {
		assertNotEquals(new Point(2.0, 1.0), Point.ORIGIN.distance(new Point(1.0, 1.0)));
	}

	@Test
	public void testOriginDistanceOnOneStepOnWestIsMinus1X0Y() {
		assertEquals(new Point(-1.0, 0.0), Point.ORIGIN.distance(Direction.WEST, 1));
	}

	@Test
	public void testOriginDistanceOnOneStepOnNorthwestIsMinus1X1Y() {
		assertEquals(new Point(-1.0, 1.0), Point.ORIGIN.distance(Direction.NORTHWEST, 1));
	}

	@Test
	public void testOriginDistanceOnOneStepOnNorthIs0X1Y() {
		assertEquals(new Point(0.0, 1.0), Point.ORIGIN.distance(Direction.NORTH, 1));
	}

	@Test
	public void testOriginDistanceOnOneStepOnNortheastIs1X1Y() {
		assertEquals(new Point(1.0, 1.0), Point.ORIGIN.distance(Direction.NORTHEAST, 1));
	}

	@Test
	public void testOriginDistanceOnOneStepOnEastIs1X0Y() {
		assertEquals(new Point(1.0, 0.0), Point.ORIGIN.distance(Direction.EAST, 1));
	}

	@Test
	public void testOriginDistanceOnOneStepOnSoutheastIs1XMinus1Y() {
		assertEquals(new Point(1.0, -1.0), Point.ORIGIN.distance(Direction.SOUTHEAST, 1));
	}

	@Test
	public void testOriginDistanceOnOneStepOnSouthIs0XMinus1Y() {
		assertEquals(new Point(0.0, -1.0), Point.ORIGIN.distance(Direction.SOUTH, 1));
	}

	@Test
	public void testOriginDistanceOnOneStepOnSouthwestIsMinus1XMinus1Y() {
		assertEquals(new Point(-1.0, -1.0), Point.ORIGIN.distance(Direction.SOUTHWEST, 1));
	}

	@Test
	public void testOriginIsInSamePositionWithPoint0X0Y() {
		assertTrue(Point.ORIGIN.isInPosition(new Point(0, 0)));
	}

	@Test
	public void testOriginIsNotInSamePositionWithPoint1X1Y() {
		assertFalse(Point.ORIGIN.isInPosition(new Point(1, 1)));
	}

	@Test
	public void testOriginIsNotInPosition5X0Y() {
		assertFalse(Point.ORIGIN.isInPosition(5.0, 0.0));
	}

	@Test
	public void testOriginIsNotInPosition0X3Y() {
		assertFalse(Point.ORIGIN.isInPosition(0.0, 3.0));
	}

	@Test
	public void testOriginDistanceOnOneStepOnNorthAndTwoStepsOnEastIs2X1Y() {
		assertEquals(new Point(2.0, 1.0), Point.ORIGIN.distance(Direction.NORTH, 1, Direction.EAST, 2));
	}

}
