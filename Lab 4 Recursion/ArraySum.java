/**
 * This class contains a method to calculate the 
 * sum of an array of elements from the last index 
 * recursively
 * @author Susan Searles
 *
 */
public class ArraySum {

	/**
	 * No-arg constructor
	 */
	public ArraySum() {
	}
	
	/**
	 * This method recursively calculates the sum
	 * of the array elements from the last index
	 * value.
	 * @param a name of the array of integers
	 * @param index last index in the array
	 * @return sum of array elements
	 */
	public int sumOfArray(Integer[] a, int index) {
		
		if (index < 0)
			return 0;
		else {
			return a[index]+ sumOfArray(a, index-1);

		}
	}
}
