

public enum Length implements Unit{
	/**
	 * declared variables
	 */
	METER("Meter", 1.0),
	FOOT("Foot", 0.3084),
	CENTIMETER("Centimeter", 0.01),
	KILOMETER("Kilometer", 1000.0),
	MILE("Mile", 1609.344),
	WA("Wa", 2.0);

	/**
	 * attributes
	 */
	public final String name;
	public final double value;

	/**
	 * 
	 * @param name name of units
	 * @param value standard value of units
	 */
	Length(String name, double value) {
		this.name = name;
		this.value = value;
	}
	/**
	 * get value of units
	 */
	public double getValue() {
		return value;
	}
}

