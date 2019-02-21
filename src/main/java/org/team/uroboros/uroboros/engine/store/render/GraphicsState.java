package org.team.uroboros.uroboros.engine.store.render;

import java.awt.Graphics2D;

public class GraphicsState {

	public final Graphics2D graphics;
	public final Integer fps;

	public GraphicsState(Graphics2D graphics, Integer fps) {
		this.graphics = graphics;
		this.fps = fps;
	}

	public Boolean isEmpty() {
		return graphics == null;
	}

}
