package org.team.uroboros.uroboros.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public enum Key implements KeyListener {

	LEFT(37), UP(38), RIGHT(39), DOWN(40);

	private final int keyCode;
	private Boolean isPressed = false;

	private Key(int keyCode) {
		this.keyCode = keyCode;
	}

	public Boolean isPressed() {
		return isPressed;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == keyCode) {

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == keyCode) {
			isPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == keyCode) {
			isPressed = false;
		}
	}

}
