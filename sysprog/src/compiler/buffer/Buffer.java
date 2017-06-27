package compiler.buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Der Buffer.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public class Buffer {

	/**
	 * Setzt die maximale Anzahl Chars eines Teilbuffers fest. MAXBYTES ist daher zugleich die
	 * maximale Anzahl an chars, die mittels {@link #ungetChar()} garantiert zurueckgegangen werden
	 * kann, ohne Gefahr zu laufen, dass aeltere Chars bereits verworfen wurden.
	 */
	public static final int MAXBYTES = 512;

	/**
	 * Pfad zur einzulesenden Datei.
	 */
	private String filepath;

	/**
	 * Klasse zum Einlesen der Datei.
	 */
	private FileReader fileReader;

	/**
	 * Klasse zum einlesen aus @link {@link Buffer#fileReader}.
	 */
	private BufferedReader bufferedReader;

	/**
	 * Erster Teilbuffer.
	 */
	private char[] buffer0;

	/**
	 * Zweiter Teilbuffer.
	 */
	private char[] buffer1;

	/**
	 * Gibt an, ob sich der Buffer zur Zeit im ersten der beiden eingelesenen Segmente befindet.
	 */
	private boolean firstSegment;

	/**
	 * Gibt an, ob sich der Buffer zur Zeit in {@link #buffer0} befindet.
	 */
	private boolean currentlyInBuffer0;

	/**
	 * Gibt den aktuellen Index dex chars an.
	 */
	private int currChar;

	/**
	 * Hilfsmethode zum Einlesen des naechsten Segments aus der zu lesenden Datei.
	 */
	private void readSegment() {
		int count = 0;
		try {
			count = bufferedReader.read(currentlyInBuffer0 ? buffer1 : buffer0);
		} catch (IOException e) {
			System.err.println("can't open file " + filepath);
		}
		if (count < MAXBYTES) {
			(currentlyInBuffer0 ? buffer1 : buffer0)[count + 1] = '\0';
		}
	}

	/**
	 * Erzeugt einen neuen Buffer.
	 * 
	 * @param filepath
	 *            Pfad zur einzulesenden Datei
	 */
	public Buffer(String filepath) {
		this.filepath = filepath;
		try {
			fileReader = new FileReader(new File(filepath));
		} catch (FileNotFoundException e) {
			System.err.println("can't find file " + filepath);
		}
		bufferedReader = new BufferedReader(fileReader);
		buffer0 = new char[MAXBYTES];
		buffer1 = new char[MAXBYTES];
		currentlyInBuffer0 = true;
		readSegment();
		currentlyInBuffer0 = false;
		readSegment();
		firstSegment = true;
		currChar = 0;
	}

	/**
	 * Liefert den aktuellen char und springt anschlieszend mit dem Zeiger auf den naechten Char im
	 * Buffer. Zeigt der Buffer zu Beginn bereits auf Dateiende, so wird '\0' geliefert und der
	 * Zeiger wird nicht verschoben.
	 * 
	 * @return char, auf welchen der Zeiger zu Beginn stand
	 */
	public char getChar() {
		char charRead = (currentlyInBuffer0 ? buffer0 : buffer1)[currChar];
		if (charRead != '\0') {
			if (currChar == MAXBYTES - 1) {
				if (!firstSegment) {
					readSegment();
				}
				currChar = 0;
				currentlyInBuffer0 = !currentlyInBuffer0;
				firstSegment = false;
			} else {
				currChar++;
			}
		}
		return charRead;
	}

	/**
	 * Wandert mit dem Zeiger im Buffer einen char zurueck. Falls Bufferanfang erreicht wurde,
	 * geschieht nichts.
	 * 
	 * @return {@code true}, falls Bufferende noch nicht erreicht.
	 */
	public boolean ungetChar() {
		if (currChar != 0) {
			currChar--;
			return true;
		}
		if ((currChar == 0) && !firstSegment) {
			currChar = MAXBYTES - 1;
			currentlyInBuffer0 = !currentlyInBuffer0;
			firstSegment = true;
			return true;
		}
		return false;
	}

	/**
	 * Ruft steps mal ungetChar() auf. Falls mindestens ein Mal ungetChar() {@code false} liefern
	 * w&uuml;rde, so liefert {@link #ungetChar(int)} ebenfalls {@code false}.
	 * 
	 * @param steps
	 *            Anzahl der Aufrufe von {@link #ungetChar()}
	 * @return {@code true}, falls Bufferbeginn nicht erreicht wurde
	 */
	public boolean ungetChar(int steps) {
		boolean success = true;
		for (int i = 0; i < steps; i++) {
			success &= ungetChar();
		}
		return success;
	}

	/**
	 * Schlie&szlig;t die ge&ouml;ffnete Datei.
	 */
	public void close() {
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			System.err.println("can't close file " + filepath);
		}
	}

}
