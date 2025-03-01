package shapes;

/**
 * Class representing a Square Prism with a height and side length
 * @author Shawn, Lloyd, Johram
 */

public class SquarePrism extends Prism
{
	
	/**
     * Creates a Square Prism with the specified height and side length
     * @param height height of square prism
     * @param side side length of square prism
     */

	public SquarePrism(double height, double side) 
	{
		super(height, side);
	}

	@Override
	public double calcBaseArea() 
	{
		return getSide() * getSide();
	}

	@Override
	public String toString() 
	{
		return "SquarePrism [calcBaseArea()=" + calcBaseArea() + ", getSide()=" + getSide() + ", calcVolume()="
				+ calcVolume() + ", getHeight()=" + getHeight() + "]";
	}
	
	
}
