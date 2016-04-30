
public enum Weight implements Unit{

	/**
	 * decalre variables
	 */
	KILOGRAM("Kilogram", 1),
	NEWTON("Newton", 0.102),
	GRAM("Gram", 0.001),
	TONNE("Tonne", 1000),
	MILLIGRAM("Milligram", Math.pow(10, -6)),
	LONGTON("LongTon", 1016),
	LONGHUNDREDWEIGHT("LongHundredweight", 50.8),
	Chang("Chang", 1.22);

	/**
	 * Attributes
	 */
	public final String name;
	public final double value;

	/**
	 * Constructor
	 * @param name name of unit
	 * @param value standard value of unit
	 */
	Weight(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 *
	 * @return value of unit
	 */
	public double getValue() {
		return value;
	}
}
