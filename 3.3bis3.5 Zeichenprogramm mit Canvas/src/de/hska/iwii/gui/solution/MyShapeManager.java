package de.hska.iwii.gui.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet Shapes.
 * @author Martin
 *
 */
public class MyShapeManager {

	List<Shape> shapes;
	List<Shape> selectedShapes;
	List<Shape> clipboard;
	
	
	public MyShapeManager() {
		this.shapes = new ArrayList<Shape>();
		this.selectedShapes = new ArrayList<Shape>();
		this.clipboard = new ArrayList<Shape>();
	}
	
	/**
	 * Fügt ein Zeichenobjekt hinzu.
	 * @param shape
	 */
	public void addShape(Shape shape) {
		this.shapes.add(shape);
	}
	
	/**
	 * Entfernt das angegebene Zeichenobjet von der Zeichenfläche.
	 * @param shape
	 */
	public void removeShape(Shape shape) {
		this.shapes.remove(shape);
	}
	
	/**
	 * Liefert das Zeichenobjekt an einer gegebenen XY Koordinate.
	 * @param x
	 * @param y
	 * @return  @code{Shape} Zeichenobjekt
	 */
	public Shape getShapeAtPos(int x, int y) {
		for (Shape shape : this.shapes) {
			if (shape.isCursorInShape(x, y)) return shape;
		}
		
		return null;
	}
	
	/**
	 * Adds shape to group of selected shapes.
	 * @param shape
	 */
	public void selectShape(Shape shape) {
		shape.setSelected(true);
		this.selectedShapes.add(shape);
	}
	
	/**
	 * Removes shape of group of selected shapes.
	 * @param shape
	 */
	public void deselectShape(Shape shape) {
		shape.setSelected(false);
		this.selectedShapes.remove(shape);
	}
	
	/**
	 * Clears group of selected shapes.
	 */
	public void clearSelectedShapes() {
		for (Shape shape : this.selectedShapes) {
			shape.setSelected(false);
		}
		
		this.selectedShapes.clear();
	}
	
	/**
	 * Adds shape to clipboard
	 * @param shape
	 */
	public void addShapeToClipboard(Shape shape) {
		this.clipboard.add(shape.duplicate());
	}
	
	/**
	 * Adds all shapes in clipboard to canvas.
	 */
	public void insertShapesInClipboard() {
		this.shapes.addAll(this.clipboard);
	}
	
	/**
	 * Clears clipboard.
	 */
	public void clearClipboard() {
		this.clipboard.clear();
	}

	public List<Shape> getShapes() {
		return this.shapes;
	}
	
}
