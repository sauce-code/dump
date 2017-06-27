package compiler.scanner.executable;

import java.io.File;

import compiler.scanner.Scanner;
import compiler.utility.Token;
import compiler.utility.TokenType;

/**
 * Stellt einen ausf&uuml;hrbaren Scanner.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public class ScannerExecutable {

	/**
	 * Erstellt einen Scanner, liesst eine Datei ein und schreibt anschlie&szlig;end alle Tokens in
	 * eine Ausgabedatei.
	 * 
	 * @param args
	 *            <ul>
	 *            <li>relativer Pfad zur Eingabedatei</li>
	 *            <li>relativer Pfad zur Ausgabedatei</li>
	 *            </ul>
	 */
	public static void main(String[] args) {

		// 2 parameter?
		if (args.length != 2) {
			System.err.println("Fehler bei Eingabe der Parameter.");
			System.exit(1);
		}

		// ausgabedatei existiert schon?
		File outputFiile = new File(args[1]);
		if (outputFiile.exists() && !outputFiile.isDirectory()) {
			System.err.println("Ausgabedatei existiert bereits!");
			System.exit(1);
		}

		// TODO
		Scanner scanner = new Scanner(args[0]);

		// gebe alle Tokens aus
		for (Token currentToken = scanner.nextToken(); currentToken.getInformation()
				.getTokenType() != TokenType.EMPTY; currentToken = scanner.nextToken()) {
			if (currentToken.getInformation().getTokenType() == TokenType.FAILURE) {
				printFailure(currentToken);
			} else {
				printToken(currentToken);
			}
		}

	}

	/**
	 * Schreibt einen Token in die Ausgabedatei.
	 * 
	 * @param currentToken
	 *            Token, welcher geschrieben werden soll.
	 */
	private static void printToken(Token currentToken) {
		// TODO Auto-generated method stub
	}

	/**
	 * Schreibt einen fehlerhaften Token auf {@link System#err}.
	 * 
	 * @param currentToken
	 *            Token, welcher geschrieben werden soll
	 */
	private static void printFailure(Token currentToken) {
		// TODO Auto-generated method stub
	}

}
