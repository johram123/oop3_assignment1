package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Implements the Insertion Sort algorithm for sorting an array of Shape objects.
 * The code itself was taken from https://www.geeksforgeeks.org/merge-sort/?ref=shm,
 * but was modified to fit current context. This class provides a static method to sort an array using the 
 * insertion sort technique, which builds a sorted sequence one element at a time by shifting larger
 * elements to the left.
 * @author: Johram, Shawn, Lloyd
 */

public class InsertionSort {
	
	/**
	 * Method that takes a Shape object array and uses an
	 * insertion sort to sort them in a descending order using Comparable.
	 * 
	 * Precondition: The array of Shape objects must not be null.
	 * Postcondition: The array will be sorted in descending order based on the natural ordering 
	 * 
	 * of Shape (or as defined by the Shape class's {@code compareTo()} method).
	 * @param arr Shape arrays to be sorted
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
	 *
	 * Precondition: The array of Shape objects must not be null.
	 * Postcondition: The array will be sorted in descending order based on the custom ordering 
	 * 
	 * @param arr Shape arrays to be sorted
	 * @param c Defines the sorting order of the arrays
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