/*
 * @author Holger Vogelsang
 */
package de.hska.iwii.gui.drawing;


/**
 * Ein konkreter Beobachter der Zeichenereignisse muss diese
 * Schnittstelle implementieren.
 * @author H. Vogelsang
 */
public interface DrawingListener {
    
    /**
     * Reaktion auf einen Mausklick in die Flaeche mit den Figuren. Dabei soll eine neue
     * Figur erzeugt werden.
     * @param figureType Zu erzeugende Figur:
     *                   <ul>
     *                     <li><code>"circle"</code> Es soll ein neuer Kreis erzeugt werden.
     *                     <li><code>"rect"</code> Es soll ein neues Rechteck erzeugt werden.
     *                     <li><code>"line"</code> Es soll eine neue Linie erzeugt werden.
     *                   </ul>
     * @param xPos X-Position des Mauszeigers waehrend des Klicks. 
     * @param yPos y-Position des Mauszeigers waehrend des Klicks. 
     */
    void startCreateFigure(String figureType, double xPos, double yPos);

    /**
     * Die Figur an der mit <code>xpos</code> und <code>ypos</code>
     * gekennzeichneten Stelle soll verschoben werden.
     * @param xPos X-Position des Mauszeigers waehrend des Klicks. 
     * @param yPos y-Position des Mauszeigers waehrend des Klicks. 
     */
    void startMoveFigure(double xPos, double yPos);
    
    
    /**
     * Der Mauszeiger wird mit gedrueckter Maustaste ueber die
     * Zeichenflaeche bewegt. Dabei wird die neu mit
     * <code>startCreateFigure</code> erzeugte Figur in der Groesse
     * veraendert.
     * @param xPos X-Position des Mauszeigers waehrend des Verschiebens. 
     * @param yPos y-Position des Mauszeigers waehrend des Verschiebens. 
     */
    void workCreateFigure(double xPos, double yPos);
    
    /**
     * Der Mauszeiger wird mit gedrueckter Maustaste ueber die
     * Zeichenflaeche bewegt. Dabei wird eine mit
     * <code>startMoveFigure</code> gewaehlte Figur verschoben.
     * @param xPos X-Position des Mauszeigers waehrend des Verschiebens. 
     * @param yPos y-Position des Mauszeigers waehrend des Verschiebens. 
     */
    void workMoveFigure(double xPos, double yPos);
   
    /**
     * Der Mauszeiger wird wieder losgelassen. Das Erzeugen
     * der Figur ist somit beendet.
     * @param xPos X-Position des Mauszeigers nach Loslassen der Maustaste. 
     * @param yPos y-Position des Mauszeigers nach Loslassen der Maustaste. 
     */
    void endCreateFigure(double xPos, double yPos);
    
    /**
     * Der Mauszeiger wird wieder losgelassen. Das Verschieben
     * der Figur ist somit beendet.
     * @param xPos X-Position des Mauszeigers nach Loslassen der Maustaste. 
     * @param yPos y-Position des Mauszeigers nach Loslassen der Maustaste. 
     */
    void endMoveFigure(double xPos, double yPos);
    
    /**
     * Selektionsereignis: Die Maustaste wurde auf einer Figur
     * gedrueckt und wieder losgelassen.
     * @param xPos X-Position des Mauszeigers waehrend des Klicks. 
     * @param yPos y-Position des Mauszeigers waehrend des Klicks. 
     * @param shiftPressed <code>true</code>: Die Shift-Taste wurde waehrend des
     *                     Mausklicks gedrueckt. 
     */
    void selectFigure(double xPos, double yPos, boolean shiftPressed);
    
    /**
     * Aufforderung zum Loeschen der selektierten Figuren.
     */
    void deleteFigures();

    /**
     * Aufforderung zum Kopieren der selektierten Figuren.
     */
    void copyFigures();

    /**
     * Aufforderung zum Einfuegen der ins Clipboard kopierten Figuren.
     */
    void pasteFigures();

    /**
     * Selektierte Figuren in die oberste Ebene verschieben.
     */
    void moveSelectedFiguresToTop();

    /**
     * Selektierte Figuren in die unterste Ebene verschieben.
     */
    void moveSelectedFiguresToBottom();

    /**
     * Selektierte Figuren eine Ebene nach unten verschieben.
     */
    void moveSelectedFiguresDown();

   	/**
     * Selektierte Figuren um eine Ebene nach oben verschieben.
     */
    void moveSelectedFiguresUp();
    
    /**
     * Alle selektierten Figuren zu einer Gruppe zusammenfassen.
     */
    void groupFigures();
    
    /**
     * Alle selektierten Gruppen aufloesen.
     */
    void ungroupFigures();
    
    /**
     * Anzahl selektierter Figuren ermitteln.
     * @return Anzahl selektierter Figuren.
     */
    int getSelectedFiguresCount();
    
    /**
     * Anzahl Figuren im Clipboard ermitteln.
     * @return Anzahl Figuren im Clipboard.
     */
    int getFiguresInClipboardCount();
    
    /**
     * Ist eine Gruppe momentan selektiert?
     * @return <code>true</code> Ja, es ist mindestens eine Gruppe selektiert.
     */
    boolean isGroupSelected();
}
