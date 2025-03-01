package shapes;

/**
 * Class representing a Triangular Prism with a height and side length
 * @author Shawn, Johram, Lloyd
 */

public class TriangularPrism extends Prism 
{

	/**
     * Creates a Triangular Prism with the specified height and side length
     * @param height height of triangular prism
     * @param side side length of triangular prism
     */
	
    public TriangularPrism(double height, double side) 
    {
        super(height, side);
    }

    @Override
    public double calcBaseArea() 
    {
        return Math.pow(getSide(), 2) * Math.sqrt(3) / 4;
    }

	@Override
	public String toString() {
		return "TriangularPrism [calcBaseArea()=" + calcBaseArea() + ", getSide()=" + getSide() + ", calcVolume()="
				+ calcVolume() + ", getHeight()=" + getHeight() + "]";
	}
    
    
}
