package org.team.uroboros.uroboros.engine.geometry.shape;

import static org.team.uroboros.uroboros.engine.ui.resources.Color.*;

import org.dyn4j.geometry.Convex;
import org.dyn4j.geometry.Transform;
import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Direction;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.geometry.Transformable;
import org.team.uroboros.uroboros.engine.physics.Vector;
import org.team.uroboros.uroboros.engine.ui.resources.Color;

public abstract class Shape implements Transformable {

	private Color color;
	protected org.dyn4j.geometry.Shape shape;

	public Shape() {
		this.color = BLUE;
	}

	public Shape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	@Override
	public void translate(double x, double y) {
		shape.translate(x, y);
	}

	@Override
	public void translate(Point position) {
		this.translate(position.getX(), position.getY());
	}

	@Override
	public void translate(Direction direction, double steps) {
		switch (direction) {

		case WEST:
			this.translate(-steps, 0.0);
			break;

		case NORTHWEST:
			this.translate(-steps, steps);
			break;

		case NORTH:
			this.translate(0.0, steps);
			break;

		case NORTHEAST:
			this.translate(steps, steps);
			break;

		case EAST:
			this.translate(steps, 0.0);
			break;

		case SOUTHEAST:
			this.translate(steps, -steps);
			break;

		case SOUTH:
			this.translate(0.0, -steps);
			break;

		case SOUTHWEST:
			this.translate(-steps, -steps);
			break;

		}
	}

	@Override
	public void translate(Direction xDir, double xSteps, Direction yDir, double ySteps) {
		this.translate(xDir, Double.valueOf(xSteps));
		this.translate(yDir, Double.valueOf(ySteps));
	}

	@Override
	public void translateTo(double x, double y) {
		this.translate(x, y);
	}

	@Override
	public void translateTo(Point position) {
		this.translateTo(position.getX(), position.getY());
	}

	@Override
	public void rotate(double theta) {
		shape.rotate(theta);
	}

	@Override
	public void rotate(double theta, Vector point) {
		shape.rotate(theta, point);
	}

	@Override
	public void rotate(double theta, double x, double y) {
		shape.rotate(theta, x, y);
	}

	@Override
	public void rotateAboutCenter(double theta) {
		shape.rotateAboutCenter(theta);
	}

	@Override
	public void scale(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scale(Dimension dimension) {
		// TODO Auto-generated method stub

	}

	public Point getLocalCenter() {
		return new Point(shape.getCenter());
	}

	public boolean contains(Vector point) {
		return shape.contains(point);
	}

	public boolean contains(Vector point, Transform transform) {
		return shape.contains(point, transform);
	}

	public void createMass(double density) {
		shape.createMass(density);
	}

	public Convex getConvex() {
		return (Convex) shape;
	}

}
