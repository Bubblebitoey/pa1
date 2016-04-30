
public enum Area implements Unit{
	
	SQUAREMETER("SquareMeter", 1),
	SQUAREDECIMETER("SquareDecimeter", 0.01),
	SQUAREKILOMETER("SquareKilometer", Math.pow(10, 6)),
	SQUARECENTIMETER("SquareCentimeter", Math.pow(10, -4)),
	SQUAREMILLIMETER("SquareMillimeter", Math.pow(10, -6)),
	SQUAREFOOT("SquareFoot", 0.0929),
	SQUAREINCH("SquareInch", 6.452 * Math.pow(10,-4)),
	NGAN("Ngan", 400);
	
	public final String name;
	public final double value;
	
	Area(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
}
