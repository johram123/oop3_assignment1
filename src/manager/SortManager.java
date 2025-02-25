package manager;

import shapes.Shape;
import utilities.SortAlgorithm;

//refer to demo001 BasicFileIO.java for a simple example on how to
// read data from a text file

// refer to demo01 Test.java for an example on how to parse command
// line arguments and benchmarking tests

// refer to demo02 Student.java for comparable implementation, and
// NameCompare.java or GradeCompare for comparator implementations

// refer to demo02 KittySort.java on how to use a custom sorting
// algorithm on a list of comparables to sort using either the
// natural order (comparable) or other orders (comparators)
public class SortManager {
	
	private Shape[] shapes;
    private String fileName;
    private char compareType;
    private char sortType;

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
	}

	private void loadShapes() 
	{
		// TODO Auto-generated method stub
		
	}
}


