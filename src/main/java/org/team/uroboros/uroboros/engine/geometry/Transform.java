package org.team.uroboros.uroboros.engine.geometry;

import org.dyn4j.geometry.Mass;
import org.team.uroboros.uroboros.engine.Component;
import org.team.uroboros.uroboros.engine.physics.Vector;

public class Transform extends Component implements Transformable {

	public Mass mass;
	public org.dyn4j.geometry.Transform wrappedObject;

	@Override
	protected void onAttach() {
		mass = new Mass();
		wrappedObject = new org.dyn4j.geometry.Transform();
	}

	@Override
	protected void onDettach() {
		wrappedObject = null;
		mass = null;
	}
	
	@Override
	public Point getPosition() {
		return new Point(wrappedObject.getTransformed(mass.getCenter()));
	}

	@Override
	public Point getLocalCenter() {
		return new Point(mass.getCenter());
	}

	@Override
	public void translate(double x, double y) {
		wrappedObject.translate(x, y);
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
		wrappedObject.translate(x - this.getPosition().getX(), y - this.getPosition().getY());
	}

	@Override
	public void translateTo(Point position) {
		this.translateTo(position.getX(), position.getY());
	}

	@Override
	public Double getRotation() {
		return wrappedObject.getRotation();
	}

	@Override
	public void rotate(double theta) {
		wrappedObject.rotate(theta);
	}

	@Override
	public void rotate(double theta, Vector vector) {
		this.rotate(theta, vector.x, vector.y);
	}

	public void rotate(double theta, Point point) {
		this.rotate(theta, point.getX(), point.getY());
	}

	@Override
	public void rotate(double theta, double x, double y) {
		wrappedObject.rotate(theta, x, y);
	}

	@Override
	public void rotateAboutCenter(double theta) {
		this.rotate(theta, this.getPosition());
	}

	@Override
	public Dimension getScale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void scale(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void scale(Dimension dimension) {
		// TODO Auto-generated method stub

	}

}
