package org.team.uroboros.uroboros.engine;

import java.util.HashSet;
import java.util.Set;

import org.team.uroboros.uroboros.engine.physics.RigidBody;

public abstract class GameObject extends Object {

	private Set<Component> components = new HashSet<>();

	public GameObject() {
		this.addComponent(new RigidBody());
	}

	public <T extends Component> T getComponent(Class<T> cls) {
		return cls.cast(components.stream().filter(c -> c.getClass().equals(cls)).findFirst().get());
	}

	public Set<Component> getComponents() {
		return components;
	}

	public void addComponent(Component component) {
		components.add(component);
		component.attatch(this);
	}

	public void removeComponent(Component component) {
		components.remove(component);
		component.dettatch(this);
	}

}
