package org.team.uroboros.uroboros.engine.geometry;

public interface Translatable {

	public abstract Point getPosition();

	public abstract Point getLocalCenter();

	public abstract void translate(double x, double y);

	public abstract void translate(Point position);

	public abstract void translate(Direction direction, double steps);

	public void translate(Direction xDir, double xSteps, Direction dir, double ySteps);

	public abstract void translateTo(double x, double y);

	public abstract void translateTo(Point position);

}
