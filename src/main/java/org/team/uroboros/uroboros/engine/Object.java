package org.team.uroboros.uroboros.engine;

import org.team.uroboros.uroboros.engine.geometry.Transform;
import org.team.uroboros.uroboros.engine.physics.Vector;

public class Object implements Cloneable {

	public Boolean isDestructionPending = false;

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

	public static Object Instantiate(Object original, Transform parent) {
		return null;
	}

	public static Object Instantiate(Object original, Transform parent, Boolean instantiateInWorldSpace) {
		return null;
	}

	public static Object Instantiate(Object original, Vector position, double rotation) {
		return null;
	}

	public static Object Instantiate(Object original, Vector position, double rotation, Transform parent) {
		return null;
	}

}
