==================================================
              Sorting Program - ReadMe
==================================================

How to Install and Use the Sorting Program:

1. Import the Project:
   - Open Eclipse.
   - Go to File > Import > General > Existing Projects into Workspace.
   - Select the root directory of your projec
   - Click Finish to import the project.

2. Set Up the Project Structure:
   - Right-click the "src" folder in the Project Explorer.
   - Select Build Path > Use as Source Folder.
   - Right-click the "res" folder.
   - Select Build Path > Include.

3. Set Up Run Configurations:
   - Go to Run > Run Configurations.
   - In the left pane, right-click Java Application and select New.
   - Name the configuration
   - Under Main Class, click Search and select AppDriver from the appDomain package.
   - Go to the Arguments tab.
   - In the Program arguments field, enter the command-line arguments. For example:
     ```
     -fres/shapes1.txt -th -sb
     ```
     - -fres/shapes1.txt: Specifies the file to read.
     - -th: Sorts by height.
     - -sb: Uses BubbleSort.

4. Run the Project:
   - Click Apply and then Run.
   - The program will execute, and you should see the output in the Eclipse console.

==================================================
Command-Line Arguments:
- -f<file_name>: The name of the shape file (e.g., shapes1.txt).
- -t<compare_type>: The comparison type (h=height, a=base area, v=volume).
- -s<sort_type>: The sorting algorithm (b=BubbleSort, q=QuickSort, h=HeapSort, i=InsertionSort, m=MergeSort, s=SelectionSort).
