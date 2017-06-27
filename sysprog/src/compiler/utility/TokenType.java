package compiler.utility;

/**
 * Alle m&ouml;gliche Typen von Tokens.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public enum TokenType {

	/**
	 * +
	 */
	SIGN_PLUS,

	/**
	 * -
	 */
	SIGN_MINUS,

	/**
	 * &#47;
	 */
	SIGN_DIVIDE,

	/**
	 * &#42;
	 */
	SIGN_MULTIPLY,

	/**
	 * <
	 */
	SIGN_LESS,

	/**
	 * >
	 */
	SIGN_GREATER,

	/**
	 * =
	 */
	SIGN_EQUAL,

	/**
	 * :=
	 */
	SIGN_ASSIGN,

	/**
	 * <:>
	 */
	SIGN_UNEQUAL,

	/**
	 * !
	 */
	SIGN_NOT,

	/**
	 * &
	 */
	SIGN_AND,

	/**
	 * ;
	 */
	SIGN_SEMICOLON,

	/**
	 * (
	 */
	SIGN_ROUNDBRACKETOPEN,

	/**
	 * )
	 */
	SIGN_ROUNDBRACKETCLOSE,

	/**
	 * {
	 */
	SIGN_CURLYBRACKETOPEN,

	/**
	 * }
	 */
	SIGN_CURLYBRACKETCLOSE,

	/**
	 * [
	 */
	SIGN_SQUAREDBRACKETOPEN,

	/**
	 * ]
	 */
	SIGN_SQUAREDBRACKETCLOSE,

	/**
	 * Leerzeichen, Tabs, Zeilenumbr&uuml;che
	 */
	WHITESPACE,

	/**
	 * Fehler bei ung&uuml;ltigen Zeichen
	 */
	FAILURE,

	/**
	 * Nothing
	 */
	NOTHING,

	/**
	 * Empty, d.h. Ende der Datei
	 */
	EMPTY,

	/**
	 * Integer
	 */
	INTEGER,

	/**
	 * Identifier
	 */
	IDENTIFIER,

	/**
	 * if
	 */
	KEYWORD_IF,

	/**
	 * else
	 */
	KEYWORD_ELSE,

	/**
	 * while
	 */
	KEYWORD_WHILE,

	/**
	 * write
	 */
	KEYWORD_WRITE,

	/**
	 * read
	 */
	KEYWORD_READ,

	/**
	 * int
	 */
	KEYWORD_INT;

}
