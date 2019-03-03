package org.team.uroboros.uroboros.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public enum Mouse implements MouseMotionListener, MouseWheelListener, MouseListener  {
	
	BUTTON1, BUTTON2, BUTTON3, MOUSE_WHEEL, MOUSE_CLICKED, MOUSE_DRAGGED, MOUSE_PRESSED, MOUSE_RELEASED;
	
	private Boolean isPressed = false;
	
	private Mouse() {
		// TODO Auto-generated constructor stub
	}

	public Boolean isPressed() {
		return isPressed;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getButton() == MouseEvent.MOUSE_DRAGGED) {
			isPressed = true;
//			e.translatePoint(x, y);
			// alcanza con saber que esta presionada?
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// tiene que definir un nuevo punto?
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() < 0 ) {
			// negative values rotated up
		} else {
			// positive values rotated down
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.MOUSE_CLICKED) {
			isPressed = true;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.MOUSE_PRESSED) {
			isPressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.MOUSE_RELEASED) {
			isPressed = false;
		}
	}
	

}
