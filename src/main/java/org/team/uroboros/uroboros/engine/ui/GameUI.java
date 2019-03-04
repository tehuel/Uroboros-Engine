package org.team.uroboros.uroboros.engine.ui;

import static java.awt.Color.decode;
import static java.awt.RenderingHints.*;
import static org.team.uroboros.uroboros.engine.ui.resources.Color.*;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

import org.team.uroboros.uroboros.engine.input.Key;
import org.team.uroboros.uroboros.engine.input.Mouse;
import org.team.uroboros.uroboros.engine.store.render.Render;
import org.team.uroboros.uroboros.engine.store.render.RenderStore;
import org.team.uroboros.uroboros.engine.ui.resources.Color;
import org.team.uroboros.uroboros.engine.utils.redux.Dispatch;

@SuppressWarnings("serial")
public class GameUI extends Frame implements WindowListener, ComponentListener {

	private final RenderStore store = RenderStore.getInstance();
	private Dispatch dispatch;
	private final Canvas canvas;
	private ViewPort viewPort;

	public GameUI() {
		Dimension dimension = new Dimension(800, 600);
		viewPort = new ViewPort(dimension.getWidth(), dimension.getHeight());
		canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setFocusable(true);
		canvas.setFocusTraversalKeysEnabled(true);
		Arrays.asList(Key.values()).forEach(canvas::addKeyListener);
		Arrays.asList(Mouse.values()).forEach(canvas::addMouseMotionListener);
		Arrays.asList(Mouse.values()).forEach(canvas::addMouseListener);
		this.setSize(dimension);
		this.setPreferredSize(dimension);
		this.setMinimumSize(dimension);
		this.setColor(BLACK);
		this.setVisible(false);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(canvas);
		this.addWindowListener(this);
		this.addComponentListener(this);
		store.subscribe((state, dispatch) -> this.dispatch = dispatch);
	}

	private void setColor(Color color) {
		this.setBackground(decode(color.hexCode()));
	}

	public void open() {
		this.setVisible(true);
		this.canvas.createBufferStrategy(2);
	}

	private void setDefaultGraphicsRenderingQuality(Graphics2D graphics) {
		graphics.setRenderingHint(KEY_ALPHA_INTERPOLATION, VALUE_ALPHA_INTERPOLATION_SPEED);
		graphics.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_OFF);
		graphics.setRenderingHint(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_SPEED);
		graphics.setRenderingHint(KEY_DITHERING, VALUE_DITHER_DISABLE);
		graphics.setRenderingHint(KEY_FRACTIONALMETRICS, VALUE_FRACTIONALMETRICS_OFF);
		graphics.setRenderingHint(KEY_RENDERING, VALUE_RENDER_SPEED);
		graphics.setRenderingHint(KEY_STROKE_CONTROL, VALUE_STROKE_DEFAULT);
		graphics.setRenderingHint(KEY_INTERPOLATION, VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
	}

	private void clearScreen(Graphics2D graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void render(Integer fps) {
		Graphics2D graphics = (Graphics2D) canvas.getBufferStrategy().getDrawGraphics();
		viewPort.transform(graphics);
		this.setDefaultGraphicsRenderingQuality(graphics);
		this.clearScreen(graphics);
		dispatch.accept(new Render(graphics, fps));
		if (!canvas.getBufferStrategy().contentsLost()) {
			canvas.getBufferStrategy().show();
		}
		graphics.dispose();
	}

	@Override
	public void componentResized(ComponentEvent e) {

	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentShown(ComponentEvent e) {

	}

	@Override
	public void componentHidden(ComponentEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

}
