package org.team.uroboros.uroboros.engine.geometry;

public interface Translatable {

	public abstract void translate(double x, double y);

	public abstract void translate(Point position);

	@Deprecated
	public abstract void translate(Direction direction, double steps);

	@Deprecated
	public void translate(Direction xDir, double xSteps, Direction dir, double ySteps);

	public abstract void translateTo(double x, double y);

	public abstract void translateTo(Point position);

}
