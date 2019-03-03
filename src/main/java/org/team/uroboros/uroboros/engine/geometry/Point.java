package org.team.uroboros.uroboros.engine.geometry;

import org.team.uroboros.uroboros.engine.physics.Vector;
import org.team.uroboros.uroboros.engine.utils.Pair;

public class Point {

	public static Point ORIGIN = new Point(0.0, 0.0);
	private final Pair<Double, Double> pair;

	public Point(double x, double y) {
		pair = new Pair<Double, Double>(x, y);
	}

	public Point(Vector vector) {
		this(vector.x, vector.y);
	}

	public Double getX() {
		return pair.first();
	}

	public Double getY() {
		return pair.second();
	}

	public Point distance(double x, double y) {
		return new Point(this.getX() + x, this.getY() + y);
	}

	@Deprecated
	public Point distance(Direction direction, double steps) {
		switch (direction) {

		case WEST:
			return new Point(this.getX() - steps, this.getY());

		case NORTHWEST:
			return new Point(this.getX() - steps, this.getY() + steps);

		case NORTH:
			return new Point(this.getX(), this.getY() + steps);

		case NORTHEAST:
			return new Point(this.getX() + steps, this.getY() + steps);

		case EAST:
			return new Point(this.getX() + steps, this.getY());

		case SOUTHEAST:
			return new Point(this.getX() + steps, this.getY() - steps);

		case SOUTH:
			return new Point(this.getX(), this.getY() - steps);

		case SOUTHWEST:
			return new Point(this.getX() - steps, this.getY() - steps);
		}

		return this;
	}

	public Point distance(Point point) {
		return this.distance(point.getX(), point.getY());
	}

	@Deprecated
	public Point distance(Direction xDir, double xSteps, Direction yDir, double ySteps) {
		return this.distance(xDir, xSteps).distance(yDir, ySteps);
	}

	public Boolean isInPosition(double x, double y) {
		return this.getX().equals(x) && this.getY().equals(y);
	}

	public Boolean isInPosition(Point point) {
		return this.isInPosition(point.getX(), point.getY());
	}

	@Override
	public String toString() {
		return "Point[x=" + this.getX() + "," + "y=" + this.getY() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return this.isInPosition((Point) obj);
	}

}
