package de.hska.iwii.gui.solution;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Mutterklasse aller möglichen Zeichenobjekte: Ellipse, Rechteck und Linie. 
 * Liefert die grundlegenden Eigenschaften (Breite, Höhe, XYZ Koordinaten) und Methoden die
 * die benötigten Benutzereingaben abbilden (z.B. Bewegen, Vergrößern/Verkleinern, etc.)
 * 
 * @author brma0004
 *
 */
public abstract class Shape {
	
	int width, height;
	int x, y, z;
	int startX, startY;
	int oldX, oldY;
	Shape parent;
	Color color;
	boolean selected;

	public abstract void resize(int cursorX, int cursorY);
	public abstract void draw(GraphicsContext gc);
	public abstract boolean isCursorInShape(int cursorX, int cursorY);
	public abstract Shape duplicate();
	
	/**
	 * Returns parent Shape.
	 * @return Shape parent
	 */
	public Shape getParent() {
		return this.parent;
	}
	
	/**
	 * Set parent of current Shape.
	 * @param parent
	 */
	public void setParent(Shape parent) {
		this.parent = parent;
	}
	
	/**
	 * Starts movement process. Stores old coordinates.
	 * @param cursorX
	 * @param cursorY
	 */
	public void startMove(int cursorX, int cursorY) {
		// TOODO
	}
	
	/**
	 * Relocates Shape, uses delta coordinates (old, cursor)
	 * @param newX
	 * @param newY
	 */
	public void relocate(int newX, int newY) {
		// TODO
	}
	
	/**
	 * Sets startX and startY to current pos. 
	 */
	public void endMove() {
		endResize();
	}
	
	/**
	 * Sets startX and startY to current pos.
	 */
	public void endResize() {
		// TODO
	}
	
	/**
	 * Sets selected attribute.
	 * @param isSelected
	 */
	public void setSelected(boolean isSelected) {
		this.selected = isSelected;
	}
	
	/**
	 * Returns isSelected.
	 * @return boolean selected
	 */
	public boolean isSelected() {
		return this.selected;
	}
}