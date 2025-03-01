package shapes;

/**
 * Class representing a Prism with height and side length
 * @author Shawn, Lloyd, Johram
 */

public abstract class Prism extends Shape
{

	private double side;

	/**
	 * Creates a Prism with height and side length
	 * @param height height of prism
     * @param side side length of prism
	 */
	
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}

	/**
	 * Returns side length
	 * @return side length 
	 */
	
	public double getSide() {
		return side;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight();
	}	
}
