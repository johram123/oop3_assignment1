package utilities;

import shapes.Shape;

public class SortAlgorithm {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) 
    {
        
    }
    
    public static void quickSort(Shape[] arr, int lowIndex, int highIndex) 
    {
        // if statement for recursion
        if (lowIndex < highIndex) {
            int partitionIndex = partition(arr, lowIndex, highIndex);

            quickSort(arr, lowIndex, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, highIndex);
        }
    }

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

    public static void swap(Shape[] arr, int leftPointer, int rightPointer) 
    {
        Shape temp = arr[leftPointer];
        
        // Swapping the values at leftPointer and rightPointer
        arr[leftPointer] = arr[rightPointer];
        arr[rightPointer] = temp;
    }
}
