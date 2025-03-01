package shapes;

/**
 * Class representing an octagonal Prism with a height and side length
 * @author Shawn, Johram, Lloyd
 */

public class OctagonalPrism extends Prism 
{
	
	/**
	 * Creates an octagonal Prism with the  height and side length
	 * @param height height of octagonal prism
	 * @param side side of octagonal prism
	 */
	
    public OctagonalPrism(double height, double side) 
    {
        super(height, side);
    }

    @Override
    public double calcBaseArea() 
    {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
    }

	@Override
	public String toString() {
		return "OctagonalPrism [calcBaseArea()=" + calcBaseArea() + ", getSide()=" + getSide() + ", calcVolume()="
				+ calcVolume() + ", getHeight()=" + getHeight() + "]";
	}

   
}
