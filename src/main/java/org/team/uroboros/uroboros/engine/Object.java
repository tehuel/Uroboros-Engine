package org.team.uroboros.uroboros.engine;

import org.team.uroboros.uroboros.engine.physics.RigidBody;
import org.team.uroboros.uroboros.engine.physics.Vector;

public class Object implements Cloneable {

	protected boolean isDestructionPending = false;

	public boolean isDestructionPending() {
		return this.isDestructionPending;
	}

	public static void Destroy(GameObject object) {
		object.isDestructionPending = true;
	}

	public static void Destroy(GameObject object, float time) {
		Destroy(object);
	}

	public static void Destroy(Component component) {
		component.isDestructionPending = true;
	}

	public static void Destroy(Component component, float time) {
		Destroy(component);
	}

	public static Object Instantiate(Object original) {
		Object clone = null;

		try {
			clone = (Object) original.clone();
		}

		catch (CloneNotSupportedException e) {

		}

		return clone;
	}

	public static Object Instantiate(Object original, RigidBody parent) {
		return null;
	}

	public static Object Instantiate(Object original, RigidBody parent, Boolean instantiateInWorldSpace) {
		return null;
	}

	public static Object Instantiate(Object original, Vector position, double rotation) {
		return null;
	}

	public static Object Instantiate(Object original, Vector position, double rotation, RigidBody parent) {
		return null;
	}

}
