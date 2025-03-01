package utilities;

import java.util.Comparator;
import shapes.Shape;

public class SortAlgorithm {

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
