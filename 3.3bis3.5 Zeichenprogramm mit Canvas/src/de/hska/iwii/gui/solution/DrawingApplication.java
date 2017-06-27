package de.hska.iwii.gui.solution;

import javafx.application.Application;
import de.hska.iwii.gui.drawing.MainWindow;

/**
 * Stellt die Main-Methode bereit, welche die Anwendung initialisiert und startet.
 * @author brma0004
 *
 */
public class DrawingApplication {

	public static void main(String[] args) {
		// Erzeuge ShapeManager
		MyShapeManager shapeManager = new MyShapeManager();
		
		// Erzeuge Canvas
		MyCanvas canvas = new MyCanvas(800, 600, shapeManager);
		
		// Mache MainWindow mit dem Canvas und dem DrawingListener bekannt.
		MainWindow.setDrawingListener(new MyDrawingListener(canvas, shapeManager));
		MainWindow.setCanvas(canvas);
		
		// Starte die Anwendung
		Application.launch(MainWindow.class, args);
	}
	
}
