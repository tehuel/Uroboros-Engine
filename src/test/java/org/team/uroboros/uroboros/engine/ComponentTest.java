package org.team.uroboros.uroboros.engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComponentTest {

	@Test
	public void testAttachAGameObject() {
		GameObject gameObject = new GameObject() {};
		Component component = new Component() {
			
			@Override
			protected void onDettach() {
				
			}
			
			@Override
			protected void onAttach() {
				
			}
		};
		component.attatch(gameObject);
		assertEquals(gameObject, component.getGameObject());
	}
	
	@Test
	public void testDettachAGameObject() {
		GameObject gameObject = new GameObject() {};
		Component component = new Component() {
			
			@Override
			protected void onDettach() {
				
			}
			
			@Override
			protected void onAttach() {
				
			}
		};
		component.attatch(gameObject);
		component.dettatch(gameObject);
		assertEquals(null, component.getGameObject());
	}

	
}
