package org.team.uroboros.uroboros.engine.physics;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Transform;
import org.team.uroboros.uroboros.engine.Component;
import org.team.uroboros.uroboros.engine.geometry.Direction;
import org.team.uroboros.uroboros.engine.geometry.Point;
import org.team.uroboros.uroboros.engine.geometry.Scale;
import org.team.uroboros.uroboros.engine.geometry.Transformable;
import org.team.uroboros.uroboros.engine.physics.collider.Collider;

public class RigidBody extends Component implements Transformable {

	public final Body body = new Body();
	private Scale scale = new Scale(1, 1);

	public RigidBody() {
		body.setMassType(MassType.NORMAL);
	}

	@Override
	protected void onAttach() {
		World.getInstance().addBody(this);
	}

	@Override
	protected void onDettach() {
		World.getInstance().removeBody(this);
	}

	public void addCollider(Collider collider) {
		body.addFixture(collider);
		body.updateMass();
	}

	public void removeCollider(Collider collider) {
		body.removeFixture(collider);
		body.updateMass();
	}

	@Override
	public void translate(double x, double y) {
		this.body.translate(x, y);
	}

	@Override
	public void translate(Point position) {
		this.translate(position.getX(), position.getY());
	}

	@Deprecated
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

	@Deprecated
	@Override
	public void translate(Direction xDir, double xSteps, Direction yDir, double ySteps) {
		this.translate(xDir, Double.valueOf(xSteps));
		this.translate(yDir, Double.valueOf(ySteps));
	}

	@Override
	public void translateTo(double x, double y) {
		this.translate(x - this.getPosition().getX(), y - this.getPosition().getY());
	}

	@Override
	public void translateTo(Point position) {
		this.translateTo(position.getX(), position.getY());
	}

	@Override
	public void rotate(double theta) {
		body.rotate(theta);
	}

	@Override
	public void rotate(double theta, Vector vector) {
		body.rotate(theta, vector);
	}

	@Override
	public void rotate(double theta, double x, double y) {
		body.rotate(theta, x, y);
	}

	@Override
	public void rotateAboutCenter(double theta) {
		body.rotateAboutCenter(theta);
	}

	@Override
	public void scale(double x, double y) {
		scale.scale(x, y);
	}

	@Override
	public void scale(Scale scale) {
		this.scale.scale(scale);
	}

	public Scale getScale() {
		return scale;
	}

	public double getXScale() {
		return scale.getXScale();
	}

	public double getYScale() {
		return scale.getYScale();
	}

	public Point getPosition() {
		return new Point(body.getWorldCenter().x, body.getWorldCenter().y);
	}

	public Point getLocalCenter() {
		return new Point(body.getLocalCenter().x, body.getLocalCenter().y);
	}

	public Double getRotation() {
		return body.getTransform().getRotation();
	}

	public Transform getTransform() {
		return body.getTransform();
	}

}
