/**
 * Created by bubblebitoey on 30/4/59.
 */
public enum Volume implements Unit {
	LITER("Liter", 1),
	CENTILITER("Centiliter", 0.01),
	MICROLITER("Microliter", Math.pow(10,-6)),
	GALLON("Gallon", 3.785),
	PECK("Peck", 9.092),
	KWIAN("Kwian", 2000);

	public final String name;
	public final double value;

	Volume(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}