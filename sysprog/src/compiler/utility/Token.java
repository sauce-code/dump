package compiler.utility;

/**
 * Definiert die Klasse Token.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public class Token {

	/**
	 * Das Informationsobjekt.
	 */
	protected Information information;

	/**
	 * Zeile des Tokens.
	 */
	protected int line;

	/**
	 * Spalte des Tokens.
	 */
	protected int column;

	/**
	 * Erzeugt ein neues Token.
	 * 
	 * @param information
	 *            das Informationsobjekt
	 * @param line
	 *            Zeile des Tokens
	 * @param column
	 *            Spalte des Tokens
	 */
	public Token(Information information, int line, int column) {
		this.information = information;
		this.line = line;
		this.column = column;
	}

	/**
	 * Liefert das Informationsobjekt.
	 * 
	 * @return das Informationsobjekt
	 */
	public Information getInformation() {
		return information;
	}

	/**
	 * Liefert die Zeile.
	 * 
	 * @return die Zeile
	 */
	public int getLine() {
		return line;
	}

	/**
	 * Liefert die Spalte.
	 * 
	 * @returndie Spalte
	 */
	public int getColumn() {
		return column;
	}

}
