package shapes;

/**
 * Class representing a Cone with a radius
 * @author Shawn, Johram, LLoyd
 */

public class Cone extends Shape
{
	private double radius;
	
	/**
	 * Creates a Cone with specified height and radius
	 * @param height height of Cone
	 * @param radius radius of Cone
	 */
	
	public Cone(double height, double radius) 
	{
		super(height);
		this.radius = radius;
	}
	
	/**
	 * Returns the Cone radius
	 * @return cone radius
	 */
	
	public double getRadius() 
	{
		return radius;
	}

	@Override
	public double calcBaseArea() {
		
		return Math.PI * radius * radius;
	}

	@Override
	public double calcVolume() {
		return calcBaseArea() * getHeight() / 3;
	}

	@Override
	public String toString() 
	{
		return "Cone [radius=" + radius + ", getRadius()=" + getRadius() + ", calcBaseArea()=" + calcBaseArea()
				+ ", calcVolume()=" + calcVolume() + ", getHeight()=" + getHeight() + "]";
	}
	
	
	
}
