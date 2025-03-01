package manager;

import shapes.BaseAreaCompare;
import shapes.Shape;
import shapes.VolumeCompare;
import utilities.SortAlgorithm;

/**
 * Sort management of shapes based on specified criteria
 * @author Shawn, Johram, Lloyd
 */

public class SortManager {
	
	private Shape[] shapes;
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
	 */
	
	private void loadShapes() 
	{
		// TODO Auto-generated method stub
		
	}
}


