package utilities;

import java.util.Comparator;

/**
 * Implements the Bubble Sort algorithm.
 * @param <T> type of elements to be sorted
 * @param arr array to be sorted
 * @author Shawn, Johram, Lloyd
 */

public class BubbleSort {
	// Bubble Sort using Comparable (height)
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

     /**
     * Sorts an array using Bubble Sort with comparator.
     * @param <T> elements to be sorted
     * @param arr array to be sorted
     * @param comparator comparator to compare elements
     */
	
    // Bubble Sort using Comparator (base area/volume)
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
