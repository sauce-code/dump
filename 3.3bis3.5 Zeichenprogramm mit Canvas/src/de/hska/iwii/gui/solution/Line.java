package de.hska.iwii.gui.solution;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Stellt eine Linie dar.
 * 
 * @author brma0004
 *
 */
public class Line extends Shape {

	int x2, y2;
	int startX2, startY2;
	
	public Line(int x, int y, int x2, int y2) {
		this.startX = x;
		this.startY = y;
		this.startX2 = x2;
		this.startY2 = y2;
		
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		
		this.color = Color.GREEN;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if (this.selected) {
			this.color = Color.DARKGREEN;
		} else {
			this.color = Color.GREEN;
		}
		
		gc.setStroke(this.color);
		gc.strokeLine(this.x, this.y, this.x2, this.y2); 
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
	public void relocate(int newX, int newY) {
		// TODO
	}

	@Override
	public void endResize() {
		// TODO
	}
	
	
	@Override
	public Shape duplicate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
