package shapes;

public class SquarePrism extends Prism
{

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
	public String toString() {
		return "SquarePrism";
	}
}
