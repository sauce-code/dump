package compiler.symboltable;

import java.util.HashMap;

import compiler.utility.InformationLexem;
import compiler.utility.TokenType;

/**
 * Stellt die Symboltabelle dar.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public class SymbolTable extends HashMap<String, InformationLexem> {

	/**
	 * Die serialVersionUID.
	 */
	private static final long serialVersionUID = 2172548490055310139L;

	/**
	 * Erzeugt eine neye Symboltabelle.
	 */
	public SymbolTable() {
		super();
		put("+", new InformationLexem("+", TokenType.SIGN_PLUS));
		put("-", new InformationLexem("-", TokenType.SIGN_MINUS));
		put("*", new InformationLexem("*", TokenType.SIGN_MULTIPLY));
		put("/", new InformationLexem("/", TokenType.SIGN_DIVIDE));
		put("<", new InformationLexem("<", TokenType.SIGN_LESS));
		put(">", new InformationLexem(">", TokenType.SIGN_GREATER));
		put("=", new InformationLexem("=", TokenType.SIGN_EQUAL));
		put(":=", new InformationLexem(":=", TokenType.SIGN_ASSIGN));
		put("<:>", new InformationLexem("<:>", TokenType.SIGN_UNEQUAL));
		put("!", new InformationLexem("!", TokenType.SIGN_NOT));
		put("&", new InformationLexem("&", TokenType.SIGN_AND));
		put(";", new InformationLexem(";", TokenType.SIGN_SEMICOLON));
		put("(", new InformationLexem("(", TokenType.SIGN_ROUNDBRACKETOPEN));
		put(")", new InformationLexem(")", TokenType.SIGN_ROUNDBRACKETCLOSE));
		put("{", new InformationLexem("{", TokenType.SIGN_CURLYBRACKETOPEN));
		put("}", new InformationLexem("}", TokenType.SIGN_CURLYBRACKETCLOSE));
		put("[", new InformationLexem("[", TokenType.SIGN_SQUAREDBRACKETOPEN));
		put("]", new InformationLexem("]", TokenType.SIGN_SQUAREDBRACKETCLOSE));
	}

}
