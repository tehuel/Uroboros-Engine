package org.team.uroboros.uroboros.engine.ui.animation;

import org.team.uroboros.uroboros.engine.geometry.Dimension;
import org.team.uroboros.uroboros.engine.geometry.Point;

public class Frame
{
	private Point coord;
	private Dimension dimension;
	
	public Frame(Integer x, Integer y, Integer w, Integer h) 
	{
		coord= new Point(x, y);
		dimension = new Dimension(w, h);
	}
	
	public Point getCoord()
	{
		return this.coord;
	}
	
	public Dimension getDimension()
	{
		return this.dimension;
	}
}
