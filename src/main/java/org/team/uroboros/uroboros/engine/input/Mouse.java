package org.team.uroboros.uroboros.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import org.team.uroboros.uroboros.engine.geometry.Point;

public enum Mouse implements MouseMotionListener, MouseWheelListener, MouseListener  {
	
	BUTTON1, BUTTON2, BUTTON3, MOUSE_WHEEL, MOUSE_CLICKED, MOUSE_DRAGGED, MOUSE_PRESSED, MOUSE_RELEASED, MOUSE_MOVED;
	
	private Boolean isPressed = false;
	private Point lastPosition = Point.ORIGIN;
	
//	private Mouse() {
//		// creo q es por aca!!!
//	}

	public Boolean isPressed() {
		return isPressed;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		setLastPosition(new Point(e.getX(), e.getY()*(-1)));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		 setLastPosition(new Point(e.getX() * 0.5, (e.getY() * 0.5) * -1));
		 System.out.println(e.getX());
//		 e.getPoint()
		 /**
		  * Transformacion del Mouse respecto de canvas
		  * 
		  */
		 System.out.println(e.getY()*(-1));
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
//		if(e.getWheelRotation() < 0 ) {
//			// negative values rotated up
//		} else {
//			// positive values rotated down
//		}
//		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		if(e.getButton() == MouseEvent.MOUSE_CLICKED) {
//			isPressed = true;
//		}
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
//		if(e.getButton() == MouseEvent.MOUSE_PRESSED) {
//			isPressed = true;
//		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		if(e.getButton() == MouseEvent.MOUSE_RELEASED) {
//			isPressed = false;
//		}
	}

	public Point getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point lastPosition) {
		this.lastPosition = lastPosition;
	}

}
