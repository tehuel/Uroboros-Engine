package org.team.uroboros.uroboros.engine.ui.animation;

import java.util.ArrayList;
import java.util.List;

import org.team.uroboros.uroboros.engine.ui.resources.Sprite;

public class AnimatedSprite 
{
	private List<Sprite> sprites;
	private Integer ratio;
	
	public AnimatedSprite(SpriteSheet image, List<Frame> frames, Integer ratio)
	{
		this.sprites = new ArrayList<Sprite>();
		this.ratio = ratio;
		createSprites(image, frames);
	}

	private void createSprites(SpriteSheet image, List<Frame> frames) 
	{
		frames.forEach(frame -> addSprite(image, frame));
	}
	
	private void addSprite(SpriteSheet image, Frame frame)
	{
		sprites.add(new Sprite(image, frame.getCoord(), frame.getDimension()));
	}
}
