package utilities;

import java.util.Comparator;
import shapes.Shape;


public class QuickSort 
{
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
