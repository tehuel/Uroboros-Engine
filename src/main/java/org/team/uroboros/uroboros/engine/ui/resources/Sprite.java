package org.team.uroboros.uroboros.engine.ui.resources;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.team.uroboros.uroboros.engine.geometry.Dimension;

public class Sprite {

	private final String path;
	private final Dimension dimension;
	private BufferedImage spriteImg;

	public Sprite(String path, Dimension dimension) {
		this.path = path;
		this.dimension = dimension;
		this.createImage();
	}

	public Sprite(String path, Integer width, Integer height) {
		this.path = path;
		this.dimension = new Dimension(width, height);
		this.createImage();
	}

	public String getPath() {
		return path;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Integer getWidth() {
		return dimension.getWidth();
	}

	public Integer getHeight() {
		return dimension.getHeight();
	}

	private void createImage() {
		try {
			spriteImg = ImageIO.read(new File("src/main/resources/" + path));
		}

		catch (Exception e) {
			// TODO
			e.printStackTrace();
		}
	}

	public BufferedImage getSpriteImg() {
		return spriteImg;
	}

}
