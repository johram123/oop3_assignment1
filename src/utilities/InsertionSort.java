package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Implements the Insertion Sort algorithm for sorting an array of Shape objects.
 * The code itself was taken from https://www.geeksforgeeks.org/merge-sort/?ref=shm,
 * but was modified to fit current context.
 * @author: Johram, Shawn, Lloyd
 */

public class InsertionSort {
	
	/**
	 * Method that takes a Shape object array and uses an
	 * insertion sort to sort them in a descending order using comparable.
	 * @param arr
	 */
	public static void insertionSort(Shape[] arr) 
	{
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Shape key = arr[i];
            int j = i - 1;

            while (j >= 0 && key.compareTo(arr[j]) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
	}
	
	/**
	 * Method that takes a Shape object array and uses an
	 * insertion sort to sort them in a descending order using comparator
	 * @param arr
	 */
	public static void insertionSort(Shape[]arr, Comparator<Shape> c) 
	{
		int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Shape key = arr[i];
            int j = i - 1;

            while (j >= 0 && c.compare(key, arr[j]) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
	}
}