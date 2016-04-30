
public enum Weight implements Unit{
	
	KILOGRAM("Kilogram", 1),
	NEWTON("Newton", 0.102),
	GRAM("Gram", 0.001),
	TONNE("Tonne", 1000),
	MILLIGRAM("Milligram", Math.pow(10, -6));
	
	public final String name;
	public final double value;
	
	Weight(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
}
