package utilities;

import java.util.Comparator;
import shapes.BaseAreaCompare;
import shapes.VolumeCompare;
import shapes.Shape;

/**
 * Sorting algorithms using Comparable or Comparator
 * @author Shawn, Johram, Lloyd
 */

public class SortAlgorithm 
{
	// WILL HAVE TOTAL 12 SORTING ALGORITHM METHODS 2 for each type 1 Comparable for Comparable and 2nd for Comparator
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) 
    {
        
    }
    
    /**
     * Sorts an array of Shapes using the Quick Sort 
     * @param arr array of shapes to be sorted
     * @param lowIndex starting index of the array
     * @param highIndex end index of the array
     */
    
    public static void quickSort(Shape[] arr, int lowIndex, int highIndex) 
    {
        // if statement for recursion
        if (lowIndex < highIndex) {
            int partitionIndex = partition(arr, lowIndex, highIndex);

            quickSort(arr, lowIndex, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, highIndex);
        }
    }
    
    /**
     * Partitions the array
     * @param arr arr array of shapes to be sorted
     * @param lowIndex start index of the array
     * @param highIndex end index of the array
     * @return partitioned index
     */
    
    public static int partition(Shape[] arr, int lowIndex, int highIndex) 
    {
        Shape pivot = arr[highIndex]; 
        int leftPointer = lowIndex - 1;  

        
        for (int rightPointer = lowIndex; rightPointer < highIndex; rightPointer++) 
        {
            // if statement used to check if the next element is smaller than pivot
            if (arr[rightPointer].compareTo(pivot) < 0) 
            { 
                leftPointer++;  
                // swap is used to maintain partition
                swap(arr, leftPointer, rightPointer);  
            }
        }

        // arranging the array to ensure that pivot is at its correct position
        swap(arr, leftPointer + 1, highIndex);
        return leftPointer + 1;  
    }
    
    /**
     * Swaps elements in an array
     * @param arr array of shapes
     * @param lowIndex start index of the array
     * @param highIndex end index of the array
     */
    
    public static void swap(Shape[] arr, int leftPointer, int rightPointer) 
    {
        Shape temp = arr[leftPointer];
        
        // Swapping the values at leftPointer and rightPointer
        arr[leftPointer] = arr[rightPointer];
        arr[rightPointer] = temp;
    }

    /**
     * Sorts an array of shapes using the quick qort with Comparator
     * @param shapes array of shapes that will be  sorted
     * @param lowIndex start index of the array
     * @param highIndex end index of the array
     * @param c comparator is used to compare shapes
     */
    
    public static void quickSort(Shape[] shapes, int lowIndex, int highIndex, Comparator<Shape> c) 
    {
        if (lowIndex < highIndex) 
        {
            int partitionIndex = partition(shapes, lowIndex, highIndex, c);
            quickSort(shapes, lowIndex, partitionIndex - 1, c);
            quickSort(shapes, partitionIndex + 1, highIndex, c);
        }
    }
    
    
    /**
     * * Partitions the array using quick sort and comparator
     * @param shapes array of shapes that will be  sorted
     * @param lowIndex start index of the array
     * @param highIndex end index of the array
     * @param c comparator is used to compare shapes
     * @return the partition index
     */
    
    public static int partition(Shape[] shapes, int lowIndex, int highIndex, Comparator<Shape> c) 
    {
        Shape pivot = shapes[highIndex]; 
        int leftPointer = lowIndex - 1;  

        for (int rightPointer = lowIndex; rightPointer < highIndex; rightPointer++) 
        {
         
            if (c.compare(shapes[rightPointer], pivot) < 0) 
            { 
                leftPointer++;
              
                swap(shapes, leftPointer, rightPointer);  
            }
        }

        swap(shapes, leftPointer + 1, highIndex);
        return leftPointer + 1;  
    }

}
