package shapes;

/**
 * Class representing a Shape with height
 *@author Shawn, Johram, LLoyd
 */

public abstract class Shape implements Comparable<Shape>
{
	private double height;
	
	/**
	 * Creates a Shape with a specified height
	 * @param height height of Shape
	 */
	
	public Shape(double height) 
	{
		super();
		this.height = height;
	}
	
	/**
	 * Returns the Shape's height
	 * @return height of Shape
	 */
	
	public double getHeight() 
	{
		return height;
	}

	@Override
	public int compareTo(Shape other) 
	{
		if(this.height > other.height)
		{
			return 1;
		}
		if(this.height < other.height)
		{
			return -1;
		}
		return 0;
	}
	
	/**
	 * Returns the calculated base area of the shape
	 * @return base area
	 */
	
	public abstract double calcBaseArea();
	
	/**
	 * Returns the calculated volume of Shape
	 * @return volume
	 */
	
	public abstract double calcVolume();
	
}
