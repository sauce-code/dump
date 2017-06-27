package compiler.utility;

/**
 * Stellt die grunds&auml;tzliche Struktur eines Informationsobjekts dar.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public abstract class Information {

	/**
	 * Typ des entsprechenden Tokens.
	 */
	protected TokenType tokenType;

	/**
	 * Erzeugt ein nues Informationsobjekt.
	 * 
	 * @param tokenType
	 *            Typ des entsprechenden Tokens
	 */
	protected Information(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * Liefert den Typ des entsprechenden Tokens.
	 * 
	 * @return Typ des entsprechenden Tokens
	 */
	public TokenType getTokenType() {
		return tokenType;
	}

}
