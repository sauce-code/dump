package sort.api;

/**
 * Defines methods for sorting arrays.
 * 
 * @author Torben Kr&auml;ger
 */
public interface ArraySort {

	/**
	 * Sorts a array of type {@link Comparable}.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public <T extends Comparable<T>> void sort(T[] array);

	/**
	 * Sorts a array of type char.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public void sort(char[] array);

	/**
	 * Sorts a array of type byte.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public void sort(byte[] array);

	/**
	 * Sorts a array of type short.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public void sort(short[] array);

	/**
	 * Sorts a array of type int.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public void sort(int[] array);

	/**
	 * Sorts a array of type long.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public void sort(long[] array);

	/**
	 * Sorts a array of type float.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public void sort(float[] array);

	/**
	 * Sorts a array of type double.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public void sort(double[] array);

}
