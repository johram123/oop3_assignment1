package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Implements the Merge Sort algorithm for sorting an array of Shape objects.
 * The code itself was taken from https://www.geeksforgeeks.org/merge-sort/?ref=shm,
 * but was modified to fit current context.
 * Merge Sort is a divide-and-conquer algorithm that recursively splits the array into 
 * smaller subarrays, sorts them, and merges them back together.
 * @author: Johram, Shawn, Lloyd
 */
public class MergeSort {
	
	/**
	 * Method that takes 4 parameters (Shape[], starting index, middle index, ending index)
	 * and uses a merge sort to sort them in a descending order using Comparable.\
	 * 
	 * Precondition: The array of Shape objects must not be null.
	 * 
	 * Postcondition: The array will be sorted in descending order based on the natural ordering 
	 * of Shape (or as defined by the Shape class's {@code compareTo()} method).
	 * 
	 * @param arr The main Shape array that contains elements to be merged.
	 * @param l The starting index of the left subarray
	 * @param m The midpoints which separates the subarrays
	 * @param r The ending index of the right subarray
	 */
	public static void merge(Shape arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        Shape L[] = new Shape[n1];
        Shape R[] = new Shape[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) > 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	/**
	 * Method that takes 4 parameters (Shape[], starting index, middle index, ending index)
	 * and uses a merge sort to sort them in a descending order using Comparable.
	 * 
	 * Precondition: The array of Shape objects must not be null.
	 * 
	 * Postcondition: The array will be sorted in descending order based on the natural ordering 
	 * of Shape (or as defined by the Shape class's {@code compareTo()} method).
	 *  
	 * @param arr The main Shape array that contains elements to be merged.
	 * @param l The starting index of the left subarray
	 * @param m The midpoints which separates the subarrays
	 * @param r The ending index of the right subarray
	 * @param c Defines the sorting order of the arrays
	 */
	public static void merge(Shape arr[], int l, int m, int r, Comparator<Shape> c)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        Shape L[] = new Shape[n1];
        Shape R[] = new Shape[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (c.compare(L[i], R[j]) > 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	/**
	 * Recursively divides the array into two halves until each half has one element.<
	 * Sorts each half separately.
	 * Merges the sorted halves back together.
	 * 
	 * Precondition:
	 * The array must not be null.
	 * The indices l and r must define a valid subarray range.
	 * 
	 * Postcondition:
	 * The elements in the specified range {@code l} to {@code r} will be sorted in ascending order
	 * based on the Shape class's {@code compareTo()} method.
	 * Sorting is performed recursively, and merging ensures that the final array is sorted.
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 */
	public static void sort(Shape[]arr, int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}