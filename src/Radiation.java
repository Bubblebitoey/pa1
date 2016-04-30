/**
 * Created by bubblebitoey on 30/4/59.
 */
public enum Radiation implements Unit {
	MICROGRAY("Microgray", 0.0001),
	MILLIGRAY("Milligray", 0.1),
	CENTIGRAY("Centigray", 1),
	GRAY("Gray", 100),
	RAD("Rad", 1);

	public final String name;
	public final double value;

	Radiation(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}