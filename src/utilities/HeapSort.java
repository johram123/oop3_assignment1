package utilities;

import java.util.Comparator;
import shapes.Shape;

/**
 * Implements the Heap Sort algorithm for sorting an array of Shape objects. 
 * The code itself was taken from https://www.geeksforgeeks.org/merge-sort/?ref=shm,
 * but was modified to fit current context.
 * Reverses the method of algorithm to achieve a descending order of array.
 * @author Johram, Shawn, Lloyd
 */
public class HeapSort {
	
	/**
     * Restores the heap property for a Min Heap, ensuring the smallest element remains at the root.
     *
     * @param arr The array representing the heap.
     * @param n The size of the heap.
     * @param i The root index of the subtree to heapify.
     */
	public static void heapify(Shape[] arr, int n, int i) {
	    // Initialize largest as root
	    int largest = i;

	    // Left and right children
	    int l = 2 * i + 1;
	    int r = 2 * i + 2;

	    // If left child is larger than root
	    if (l < n && arr[l].compareTo(arr[largest]) > 0) { 
	        largest = l;
	    }

	    // If right child is larger than largest so far
	    if (r < n && arr[r].compareTo(arr[largest]) > 0) { 
	        largest = r;
	    }

	    // If largest is not root, swap and heapify
	    if (largest != i) {
	        Shape temp = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = temp;

	        // Recursively heapify the affected sub-tree
	        heapify(arr, n, largest);
	    }
	}

	// Heapify method with Comparator
	public static void heapify(Shape[] arr, int n, int i, Comparator<Shape> c) {
	    int largest = i;
	    int l = 2 * i + 1;
	    int r = 2 * i + 2;

	    // If left child is larger than root
	    if (l < n && c.compare(arr[l], arr[largest]) > 0) { 
	        largest = l;
	    }

	    // If right child is larger than largest so far
	    if (r < n && c.compare(arr[r], arr[largest]) > 0) { 
	        largest = r;
	    }

	    // If largest is not root, swap and heapify
	    if (largest != i) {
	        Shape temp = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = temp;

	        // Recursively heapify the affected sub-tree using the comparator
	        heapify(arr, n, largest, c);
	    }
	}	
    
	
	/**
     * Sorts an array of Shape objects in descending order using Heap Sort.
     *
     * @param arr The array of Shape objects to be sorted.
     * @throws NullPointerException if the array is null.
     */
    // Main function to do heap sort
    public static void heapSort(Shape[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            Shape temp = arr[0]; 
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    public static void heapSort(Shape[] arr, Comparator<Shape> c) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            Shape temp = arr[0]; 
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0, c);
        }
    }
}
