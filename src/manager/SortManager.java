package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import shapes.*;
import utilities.*;


public class SortManager {
	
	public Shape[] shapes;
    private String fileName;
    private char compareType;
    private char sortType;
    
    /**
     * Creates a SortManager with the specified arguments.
     * @param args arguments
     */
    
    public SortManager(String[] args) {
        for (String s : args) 
        {
            if (s.startsWith("-f") || s.startsWith("-F")) 
            {
                fileName = s.substring(2);
            } 
            else if (s.startsWith("-t") || s.startsWith("-T")) 
            {
                compareType = s.substring(2).charAt(0);
            } 
            else if (s.startsWith("-s") || s.startsWith("-S")) 
            {
                sortType = s.substring(2).charAt(0);
            }
        }
        
        loadShapes();
        sortShapes();
        
    }
    
    /**
     * Sorts the shapes array based on the selected comparison type (Height, Base Area, or Volume)
     * and the chosen sorting algorithm (BubbleSort, QuickSort, HeapSort, etc.).
     */
    
	private void sortShapes() 
	{	
		 Comparator<Shape> comparator = null;
		 String typeOfSort = null; 
		 String typeOfCompare = null;

		    if (compareType == 'h' || compareType == 'H') {
		        typeOfCompare = "Height";
		    } 
		    else if (compareType == 'a' || compareType == 'A') {
		        comparator = new BaseAreaCompare();
		        typeOfCompare = "Area";
		    } 
		    else if (compareType == 'v' || compareType == 'V') {
		        comparator = new VolumeCompare();
		        typeOfCompare = "Volume";
		    } 

		    // Start timing
		    long startTime = System.nanoTime(); 

		    switch (Character.toLowerCase(sortType)) {
		        case 'b':
		            if (comparator == null) BubbleSort.bubbleSort(shapes);
		            else BubbleSort.bubbleSort(shapes, comparator);
		            typeOfSort = "BubbleSort";
		            break;
		        case 'q':
		            if (comparator == null) QuickSort.quickSort(shapes, 0, shapes.length - 1);
		            else QuickSort.quickSort(shapes, 0, shapes.length - 1, comparator);
		            typeOfSort = "QuickSort";
		            break;
		        case 'h':
		            if (comparator == null) HeapSort.heapSort(shapes);
		            else HeapSort.heapSort(shapes, comparator);
		            typeOfSort = "HeapSort";
		            break;
		        case 'i':
		            if (comparator == null) InsertionSort.insertionSort(shapes);
		            else InsertionSort.insertionSort(shapes, comparator);
		            typeOfSort = "InsertionSort";
		            break;
		        case 'm':
		            if (comparator == null) MergeSort.sort(shapes, 0, shapes.length - 1);
		            else MergeSort.sort(shapes, 0, shapes.length - 1, comparator);
		            typeOfSort = "MergeSort";
		            break;
		        case 's':
		            if (comparator == null) SelectionSort.selectionSort(shapes);
		            else SelectionSort.selectionSort(shapes, comparator);
		            typeOfSort = "SelectionSort";
		            break;
		    }

		    long endTime = System.nanoTime(); 
		    long duration = (endTime - startTime) / 1_000_000; 
		    
		    System.out.println("\nSorted Shapes Output:");
		    System.out.println("First: " + shapes[0] + " " + typeOfCompare + " " + getCalculation(shapes[0], compareType));  // First shape

		    /**
		     * for (int i = 1000; i < shapes.length - 1; i += 1000) {
		        System.out.println("Shape at index " + i + ": " + typeOfCompare + " " + getCalculation(shapes[i], compareType));
		    }
			*/
		    for (Shape shape : shapes)
		    {
		    	System.out.println(shape.calcVolume());
		    }
		    
		    if (shapes.length > 1) {
		        System.out.println("Last: " + " " + shapes[shapes.length - 1] + " " + typeOfCompare + " " + getCalculation(shapes[shapes.length - 1], compareType) );  // Last shape
		    }
		    
		    System.out.println("Sorting completed using " + typeOfSort + " in " + duration + " milliseconds.");
	}
	
	
	/**
	  * Returns a string representation of the calculated value based on the given comparison type.
	  * This method dynamically calculates and returns a string representation of 
	  * the height, base area, or volume of a given shape
	  * @param shape The shape whose property is being calculated.
	  * @param compareType The comparison type ('h' for height, 'a' for base area, 'v' for volume).
	  * @return A string containing the calculated height, base area, or volume.
	  * Returns "Unknown comparison type" if an invalid type is provided.
	 */
	private String getCalculation(Shape shape, char compareType) {
	    switch (Character.toLowerCase(compareType)) {
	        case 'h': // Compare by Height
	            return String.valueOf(shape.getHeight());
	        case 'a': // Compare by Base Area
	        	return String.valueOf(shape.calcBaseArea());	     
	        case 'v': // Compare by Volume
	        	return String.valueOf(shape.calcVolume()); 
	        default:
	            return "Unknown comparison type";
	    }
	}
	
	/**
	 * Loads the shapes into the shapes array
	 * @throws FileNotFoundExceprion
	 */
	
	private void loadShapes() 
	{		
		try 
		{
			File file = new File(fileName);
			Scanner readFile = new Scanner(file);
			int numOfShapes = Integer.parseInt(readFile.nextLine());
			shapes = new Shape[numOfShapes];
			int counter = 0; 
			
			while (readFile.hasNext())
			{
				String line = readFile.nextLine();
				String[] field = line.split(" ");
				String shape = field[0];
				
				switch (shape)
				{
					case "Cone":
						shapes[counter] = new Cone(Double.parseDouble(field[1]), Double.parseDouble(field[2]));
						counter++;
						break;
					case "Cylinder":
						shapes[counter] = new Cylinder(Double.parseDouble(field[1]), Double.parseDouble(field[2]));
						counter++;
						break;
					case "Pyramid":
						shapes[counter] = new Pyramid(Double.parseDouble(field[1]), Double.parseDouble(field[2]));
						counter++;
						break;
					case "SquarePrism":
						shapes[counter] = new SquarePrism(Double.parseDouble(field[1]), Double.parseDouble(field[2]));
						counter++;
						break;
					case "TriangularPrism":
						shapes[counter] = new TriangularPrism(Double.parseDouble(field[1]), Double.parseDouble(field[2]));
						counter++;
						break;
					case "PentagonalPrism":
		        		shapes[counter] = new PentagonalPrism(Double.parseDouble(field[1]), Double.parseDouble(field[2]));
		        		counter++;
		        		break;
					case "OctagonalPrism":
						shapes[counter] = new OctagonalPrism(Double.parseDouble(field[1]), Double.parseDouble(field[2]));
						counter++;
						break;
				}	
			}
			readFile.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		
	}
}


