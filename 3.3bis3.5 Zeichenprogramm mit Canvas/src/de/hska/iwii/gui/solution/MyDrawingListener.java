package de.hska.iwii.gui.solution;

import javafx.scene.canvas.Canvas;
import de.hska.iwii.gui.drawing.DrawingListener;

/**
 * Implementierung des DrawingListener Interface.
 * 
 * ACHTUNG: Diese Klasse soll nur zur dazu dienen, einen möglichen Weg der Implementierung darzustellen. Sie ist bei weitem noch nicht komplett, 
 * soll aber den Einstieg mit der Variante 1 erleichtern.
 * 
 * @author brma0004
 *
 */
public class MyDrawingListener implements DrawingListener {

	MyShapeManager shapeManager;
	Canvas canvas;
	Shape currentShape;
	
	/**
	 * Konstruktor, initialisiert den Canvas.
	 * @param canvas
	 */
	public MyDrawingListener(Canvas canvas, MyShapeManager shapeManager) {
		this.canvas = canvas;
		this.shapeManager = shapeManager;
	}
	
	
	/**
	 * Pro Mausklick wird entweder eine Ellipse, Rechteck oder eine Linie gezeichnet, deren Größe/Form 
	 * vorerst in dieser Version fest codiert ist.
	 */
	@Override
	public void startCreateFigure(String figureType, double xPos, double yPos) {
		this.currentShape = null;
		
		if (figureType.compareTo("ellipse") == 0) {
			this.currentShape = new Ellipse((int) xPos, (int) yPos, 20, 20);
			System.out.println("New Oval!");
		}
		
		if (figureType.compareTo("rectangle") == 0) {
			this.currentShape = new Rect((int) xPos, (int) yPos, 20, 20);
			System.out.println("New Rectangle!");
		}

		if (figureType.compareTo("line") == 0) {
			this.currentShape = new Line((int)xPos, (int) yPos, (int) xPos + 20, (int) yPos + 20);
			System.out.println("New Line!");
		}
		
		if (this.currentShape != null) {
			shapeManager.addShape(this.currentShape);
			((MyCanvas) this.canvas).refresh();
		}
		
	}

	@Override
	public void startMoveFigure(double xPos, double yPos) {
		
		// finde Shape heraus, auf das wir evtl geklickt haben
		this.currentShape = shapeManager.getShapeAtPos((int) xPos, (int) yPos);
	
		if (this.currentShape != null) {
			// TODO Beginne mit Shape-Bewegung
		}
		
	}

	@Override
	public void workCreateFigure(double xPos, double yPos) {
		// TODO Verkleinere/Vergrößere Shape, refresh Canvas
	}

	@Override
	public void workMoveFigure(double xPos, double yPos) {
		// TODO Bewege Shape, refresh Canvas
	}

	@Override
	public void endCreateFigure(double xPos, double yPos) {
		// TODO Beende Shape Erstellung
	}

	@Override
	public void endMoveFigure(double xPos, double yPos) {
		// TODO Beende Shape Bewegung
	}

	@Override
	public void selectFigure(double xPos, double yPos, boolean shiftPressed) {
		// Shape seleted?
		// TODO Finde angeklicktes Shape heraus
		// TODO Prüfe auf Shift und selektiere ggf. Shape
		// TODO Refres Canvas
	}

	@Override
	public void deleteFigures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copyFigures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pasteFigures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveSelectedFiguresToTop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveSelectedFiguresToBottom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveSelectedFiguresDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveSelectedFiguresUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupFigures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ungroupFigures() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSelectedFiguresCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFiguresInClipboardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isGroupSelected() {
		// TODO Auto-generated method stub
		return false;
	}

}
