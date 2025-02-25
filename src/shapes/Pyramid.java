package shapes;

/**
 * Class representing a Pyramid with a side length
 * @author Shawn, Johram, LLoyd
 */
public class Pyramid extends Shape 
{
    private double sideLength;

    /**
     * Creates a Pyramid with specified height and side length
     * @param height height of Pyramid
     * @param sideLength side length of Pyramid's base
     */
    public Pyramid(double height, double sideLength) 
    {
        super(height);
        this.sideLength = sideLength;
    }

    /**
     * Returns the Pyramid side length
     * @return pyramid side length
     */
    public double getSideLength() 
    {
        return sideLength;
    }

    @Override
    public double calcBaseArea() 
    {
        return sideLength * sideLength;
    }

    @Override
    public double calcVolume() 
    {
        return calcBaseArea() * getHeight() / 3;
    }

    @Override
    public String toString() {
        return "Pyramid [sideLength=" + sideLength + ", getSideLength()=" + getSideLength() + ", calcBaseArea()=" 
                + calcBaseArea() + ", calcVolume()=" + calcVolume() + ", getHeight()=" + getHeight() + "]";
    }
}
