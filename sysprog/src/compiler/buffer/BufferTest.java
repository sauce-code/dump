package compiler.buffer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testet die Klasse {@link Buffer}.
 * 
 * @author Torben Kr&uuml;ger
 *
 */
public class BufferTest {

	/**
	 * Pfad zu den Testfiles.
	 */
	public static final String PATH = "testfiles/compiler/buffer/";

	/**
	 * Name des Testfile A.
	 */
	public static final String FILE_A = "fileA.txt";

	/**
	 * Wird der erste Char korrekt wiedergegeben?
	 */
	@Test
	public void testA01() {
		Buffer b = new Buffer(PATH + FILE_A);
		assertEquals('a', b.getChar());
		b.close();
	}

	/**
	 * Wird der letzte char korrekt wiedergegeben?
	 */
	@Test
	public void testA02() {
		Buffer b = new Buffer(PATH + FILE_A);
		assertEquals('a', b.getChar());
		for (int i = 0; i < 4; i++) {
			b.getChar();
		}
		assertEquals('\0', b.getChar());
		b.close();
	}

	/**
	 * Werden alle chars korrekt wiedergegeben?
	 */
	@Test
	public void testA03() {
		Buffer b = new Buffer(PATH + FILE_A);
		assertEquals('a', b.getChar());
		assertEquals('b', b.getChar());
		assertEquals('c', b.getChar());
		assertEquals('d', b.getChar());
		assertEquals('\0', b.getChar());
		b.close();
	}

	/**
	 * Wird nach einmaligem Aufruf von {@link Buffer#ungetChar()} der korrekte char geliefert?
	 */
	@Test
	public void testA04() {
		Buffer b = new Buffer(PATH + FILE_A);
		assertEquals('a', b.getChar());
		for (int i = 0; i < 4; i++) {
			b.getChar();
		}
		b.ungetChar();
		assertEquals('d', b.getChar());
		b.close();
	}

	/**
	 * K&ouml;nnen {@link Buffer#getChar()} und {@link Buffer#ungetChar()} beliebig oft korrekt
	 * aufgerufen werden?
	 */
	@Test
	public void testA05() {
		Buffer b = new Buffer(PATH + FILE_A);
		assertEquals('a', b.getChar());
		for (int i = 0; i < 10; i++) {
			b.getChar();
		}
		for (int i = 0; i < 20; i++) {
			b.ungetChar();
		}
		assertFalse(b.ungetChar());
		assertEquals('a', b.getChar());
		b.close();
	}

	/**
	 * K&ouml;nnen {@link Buffer#getChar()} und {@link Buffer#ungetChar()} beliebig oft korrekt
	 * aufgerufen werden?
	 */
	@Test
	public void testA06() {
		Buffer b = new Buffer(PATH + FILE_A);
		assertEquals('a', b.getChar());
		for (int i = 0; i < 10; i++) {
			b.getChar();
		}
		for (int i = 0; i < 20; i++) {
			b.ungetChar();
		}
		for (int i = 0; i < 30; i++) {
			b.getChar();
		}
		assertEquals('\0', b.getChar());
		assertTrue(b.ungetChar());
		assertEquals('d', b.getChar());
		b.close();
	}

	/**
	 * Kann von Start an nicht zur&uuml;ckgegangen werden?
	 */
	@Test
	public void testA07() {
		Buffer b = new Buffer(PATH + FILE_A);
		assertFalse(b.ungetChar());
		b.close();
	}

	/**
	 * Weiterer Test.
	 */
	@Test
	public void testA08() {
		Buffer b = new Buffer(PATH + FILE_A);
		b.getChar();
		b.getChar();
		b.ungetChar();
		b.ungetChar();
		assertFalse(b.ungetChar());
		b.close();
	}

}
