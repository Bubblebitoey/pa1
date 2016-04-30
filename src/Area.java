
public enum Area implements Unit{

	/**
	 * declare variables
	 */
	SQUAREMETER("SquareMeter", 1),
	SQUAREDECIMETER("SquareDecimeter", 0.01),
	SQUAREKILOMETER("SquareKilometer", Math.pow(10, 6)),
	SQUARECENTIMETER("SquareCentimeter", Math.pow(10, -4)),
	SQUAREMILLIMETER("SquareMillimeter", Math.pow(10, -6)),
	SQUAREFOOT("SquareFoot", 0.0929),
	SQUAREINCH("SquareInch", 6.452 * Math.pow(10,-4)),
	NGAN("Ngan", 400);

	/**
	 * Attributes
	 */
	public final String name;
	public final double value;

	/**
	 * Constructors
	 * @param name name of units
	 * @param value standard value of unit
	 */
	Area(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 *
	 * @return get value of unit
	 */
	public double getValue() {
		return value;
	}
}
