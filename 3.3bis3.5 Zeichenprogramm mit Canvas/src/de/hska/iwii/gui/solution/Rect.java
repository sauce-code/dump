package de.hska.iwii.gui.solution;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Stellt ein Rechteck dar.
 * @author brma0004
 *
 */
public class Rect extends Shape {

	public Rect(int x, int y, int width, int height) {
		this.startX = x;
		this.startY = y;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.color = Color.RED;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if (this.selected) {
			this.color = Color.DARKRED;
		} else {
			this.color = Color.RED;
		}
		
		gc.setFill(this.color);
		gc.fillRect(x, y, width, height);
	}

	@Override
	public boolean isCursorInShape(int cursorX, int cursorY) {
		
		if (	(cursorX >= this.x && cursorX <= this.x + this.width) && 
				(cursorY >= this.y && cursorY <= this.y + this.height) ) {
			
			return true;
		}
		
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
