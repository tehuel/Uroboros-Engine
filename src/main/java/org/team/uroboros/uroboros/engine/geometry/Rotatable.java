package org.team.uroboros.uroboros.engine.geometry;

import org.team.uroboros.uroboros.engine.physics.Vector;

public interface Rotatable {

	public abstract Double getRotation();

	public abstract void rotate(double theta);

	public abstract void rotate(double theta, Vector vector);

	public abstract void rotate(double theta, double x, double y);

	public abstract void rotateAboutCenter(double theta);

}
