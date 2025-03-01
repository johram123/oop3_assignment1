package shapes;

/**
 * Class representing a Pentagonal Prism with a height and side length
 * @author Shawn, Johram, Lloyd
*/

public class PentagonalPrism extends Prism 
{

	  /**
     * Creates a Pentagonal Prism with the specified height and side length
     * @param height height of pentagonal prism
     * @param side side length of pentagonal prism
     */
	
    public PentagonalPrism(double height, double side) 
    {
        super(height, side);
    }

    @Override
    public double calcBaseArea() 
    {
        return 5 * Math.pow(getSide(), 2) * Math.tan(Math.toRadians(54)) / 4;
    }

	@Override
	public String toString() {
		return "PentagonalPrism [calcBaseArea()=" + calcBaseArea() + ", getSide()=" + getSide() + ", calcVolume()="
				+ calcVolume() + ", getHeight()=" + getHeight() + "]";
	}

   
}
