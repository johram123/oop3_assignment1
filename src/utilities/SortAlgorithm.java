package utilities;

import java.util.Comparator;
import shapes.BaseAreaCompare;
import shapes.VolumeCompare;
import shapes.Shape;

public class SortAlgorithm {

   
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
    
    
    
    
    
    
    
 // bubble sort
    public static void bubbleSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Use the comparator to compare shapes in descending order
                if (comparator.compare(shapes[j], shapes[j + 1]) < 0) {
                    // Swap shapes[j] and shapes[j + 1]
                    Shape temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) break;
        }
    }

    // selection sort
    public static void selectionSort(Shape[] shapes, Comparator<Shape> comparator) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                // Use the comparator to find the maximum element
                if (comparator.compare(shapes[j], shapes[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            // Swap the found maximum element with the first unsorted element
            Shape temp = shapes[maxIndex];
            shapes[maxIndex] = shapes[i];
            shapes[i] = temp;
        }
    }
    
    
    
    
    

    public static void swap(Shape[] arr, int leftPointer, int rightPointer) 
    {
        Shape temp = arr[leftPointer];
        
        // Swapping the values at leftPointer and rightPointer
        arr[leftPointer] = arr[rightPointer];
        arr[rightPointer] = temp;
    }

    public static void quickSort(Shape[] shapes, int lowIndex, int highIndex, Comparator<Shape> c) 
    {
        if (lowIndex < highIndex) 
        {
            int partitionIndex = partition(shapes, lowIndex, highIndex, c);
            quickSort(shapes, lowIndex, partitionIndex - 1, c);
            quickSort(shapes, partitionIndex + 1, highIndex, c);
        }
    }

    
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
