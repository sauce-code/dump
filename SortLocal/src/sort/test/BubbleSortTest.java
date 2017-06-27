package sort.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sort.impl.BubbleSort;
import static sort.test.data.Arrays.*;

/**
 * Tests the methods of class {@link BubbleSort}.
 * 
 * @author Torben Kr&uuml;ger
 */
public class BubbleSortTest {

	/**
	 * The instance of {@link BubbleSort} being used during the tests.
	 */
	private BubbleSort bs = new BubbleSort();

	/**
	 * Tests the method {@link BubbleSort#sort(Comparable[])}.
	 */
	@Test
	public void testSortArrayComparable() {
		Integer[] array = INTEGER.clone();
		bs.sort(array);
		assertArrayEquals(INTEGER_SORTED, array);
	}

	/**
	 * Tests the method {@link BubbleSort#sort(char[])}.
	 */
	@Test
	public void testSortArrayChar() {
		char[] array = CHAR.clone();
		bs.sort(array);
		assertArrayEquals(CHAR_SORTED, array);
	}

	/**
	 * Tests the method {@link BubbleSort#sort(byte[])}.
	 */
	@Test
	public void testSortArrayByte() {
		fail("not yet implemented");
	}

	/**
	 * Tests the method {@link BubbleSort#sort(short[])}.
	 */
	@Test
	public void testSortArrayShort() {
		fail("not yet implemented");
	}

	/**
	 * Tests the method {@link BubbleSort#sort(int[])}.
	 */
	@Test
	public void testSortArrayInt() {
		fail("not yet implemented");
	}

	/**
	 * Tests the method {@link BubbleSort#sort(long[])}.
	 */
	@Test
	public void testSortArrayLong() {
		fail("not yet implemented");
	}

	/**
	 * Tests the method {@link BubbleSort#sort(float[])}.
	 */
	@Test
	public void testSortArrayFloat() {
		fail("not yet implemented");
	}

	/**
	 * Tests the method {@link BubbleSort#sort(Double[])}.
	 */
	@Test
	public void testSortArrayDoueble() {
		fail("not yet implemented");
	}

}
