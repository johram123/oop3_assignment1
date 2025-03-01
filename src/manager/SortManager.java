package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.BaseAreaCompare;
import shapes.*;
import shapes.VolumeCompare;
import utilities.SortAlgorithm;


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
     * Sort shapes in the shapes array
     */
    
	private void sortShapes() 
	{
		if(compareType == 'h' || compareType == 'H')
		{
			if(sortType == 'b' || sortType == 'B')
			{
				SortAlgorithm.bubbleSort(shapes);
			}
			else if (sortType == 'q' || sortType == 'Q') 
			{  
                SortAlgorithm.quickSort(shapes, 0, shapes.length - 1);
            }
		}
		else if(compareType == 'a' || compareType == 'A')
		{
			if(sortType == 'b' || sortType == 'B')
			{
				SortAlgorithm.bubbleSort(shapes);
			}
			else if (sortType == 'q' || sortType == 'Q') 
			{  
				BaseAreaCompare bac = new BaseAreaCompare();
                SortAlgorithm.quickSort(shapes, 0, shapes.length - 1, bac);
            }
		}
		else if(compareType == 'v' || compareType == 'V')
		{
			if(sortType == 'b' || sortType == 'B')
			{
				SortAlgorithm.bubbleSort(shapes);
			}
			else if (sortType == 'q' || sortType == 'Q') 
			{  
				VolumeCompare vc = new VolumeCompare();
                SortAlgorithm.quickSort(shapes, 0, shapes.length - 1, vc);
            }
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


