package compiler.scanner;

import compiler.buffer.Buffer;
import compiler.symboltable.SymbolTable;
import compiler.utility.Token;

/**
 * Stellt den Scanner dar.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public class Scanner {

	/**
	 * Der Buffer.
	 */
	protected Buffer buffer;

	/**
	 * Die Symboltabelle.
	 */
	protected SymbolTable symbolTable;

	/**
	 * Erzeugt einen neuen Scanner.
	 * 
	 * @param path
	 *            Pfad zur einzulesenden Datei
	 */
	public Scanner(String path) {
		buffer = new Buffer(path);
		symbolTable = new SymbolTable();
	}

	/**
	 * Liefert den n&auml;chsten Token.
	 * 
	 * @return n&auml;chster Token
	 */
	public Token nextToken() {
		return null;
	}

	/**
	 * Schlie&szlig;t die einzulesende Datei.
	 */
	public void close() {
		buffer.close();
	}

}
