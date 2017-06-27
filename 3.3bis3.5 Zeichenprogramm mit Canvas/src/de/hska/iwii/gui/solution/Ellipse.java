package de.hska.iwii.gui.solution;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Stellt eine Ellipse dar.
 * @author brma0004
 *
 */
public class Ellipse extends Shape {

	public Ellipse(int x, int y, int width, int height) {
		this.startX = x;
		this.startY = y;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.color = Color.BLUE;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if (this.selected) {
			this.color = Color.DARKBLUE;
		} else {
			this.color = Color.BLUE;
		}
		
		gc.setFill(this.color);
		gc.fillOval(this.x, this.y, this.width, this.height);
	}

	@Override
	public boolean isCursorInShape(int cursorX, int cursorY) {
		// TODO
		return false;
	}

	@Override
	public void resize(int cursorX, int cursorY) {
		// TODO
	}

	@Override
	public Shape duplicate() {
		// TODO Auto-generated method stub
		return null;
	}

}