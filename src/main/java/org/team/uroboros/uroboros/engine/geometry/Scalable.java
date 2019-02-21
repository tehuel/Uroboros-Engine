package org.team.uroboros.uroboros.engine.geometry;

public interface Scalable {

	public abstract Dimension getScale();

	public abstract void scale(double x, double y);

	public abstract void scale(Dimension dimension);

}
