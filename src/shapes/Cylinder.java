package shapes;

/**
 * Class representing a Cylinder with a radius
 * @author Shawn, Johram, LLoyd
 */
public class Cylinder extends Shape 
{
    private double radius;

    /**
     * Creates a Cylinder with specified height and radius
     * @param height height of Cylinder
     * @param radius radius of Cylinder
     */
    public Cylinder(double height, double radius) 
    {
        super(height);
        this.radius = radius;
    }

    /**
     * Returns the Cylinder radius
     * @return cylinder radius
     */
    public double getRadius() 
    {
        return radius;
    }

    @Override
    public double calcBaseArea() 
    {
        return Math.PI * radius * radius;
    }

    @Override
    public double calcVolume() 
    {
        return calcBaseArea() * getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder [radius=" + radius + ", getRadius()=" + getRadius() + ", calcBaseArea()=" + calcBaseArea()
                + ", calcVolume()=" + calcVolume() + ", getHeight()=" + getHeight() + "]";
    }
}
