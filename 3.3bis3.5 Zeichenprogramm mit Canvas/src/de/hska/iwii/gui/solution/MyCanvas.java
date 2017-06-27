package de.hska.iwii.gui.solution;

import javafx.scene.canvas.Canvas;

/**
 * Meine Implementierung des Canvas. Zusätzlich verwaltet und zeichnet dieses Canvas die  Zeichenobjekte (shapes).
 *  
 * @author brma0004
 *
 */
public class MyCanvas extends Canvas {
	
	
	
	MyShapeManager shapeManager;

	/**
	 * Initialisiert ein Canvas mit width x height Pixel großer Fläche.
	 *  
	 * @param width
	 * @param height
	 */
	public MyCanvas(int width, int height, MyShapeManager shapeManager) {
		this.setWidth(width);
		this.setHeight(height);
		this.shapeManager = shapeManager;
	}
	
	
	/**
	 * Zeichnet die komplette Zeichenfläche neu.
	 */
	public void refresh() {
		getGraphicsContext2D().clearRect(0, 0, this.getWidth(), this.getHeight());
		for (Shape shape : this.shapeManager.getShapes()) {
			shape.draw(getGraphicsContext2D());
		}
	}
	
	
}
