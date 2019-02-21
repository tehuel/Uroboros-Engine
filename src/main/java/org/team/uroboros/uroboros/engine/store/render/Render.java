package org.team.uroboros.uroboros.engine.store.render;

import java.awt.Graphics2D;

import org.team.uroboros.uroboros.engine.utils.redux.Action;

public class Render implements Action {

	public final Integer fps;
	public final Graphics2D graphics;

	public Render(Integer fps) {
		this.fps = fps;
		this.graphics = null;
	}

	public Render(Graphics2D graphics, Integer fps) {
		this.fps = fps;
		this.graphics = graphics;
	}

}
