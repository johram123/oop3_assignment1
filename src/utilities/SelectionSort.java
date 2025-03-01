package utilities;

import java.util.Comparator;

/**
 * Sorts an array using Selection Sort
 * @param <T> elements to be sorted
 * @param arr array to be sorted
 * @author Shawn, Johram, Lloyd
 */

public class SelectionSort {	
	// Selection Sort using comparable (height)
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            T temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Sorts an array using Selection Sort comparator.
     * @param <T> elements to be sorted
     * @param arr array to be sorted
     * @param comparator comparator to compare elements
     */
	
    // Selection Sort using comparator (base area/volume)
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(arr[j], arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            T temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
