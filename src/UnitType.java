public enum UnitType {
	Length("length"),
	Area("Area"),
	Weight("Weight"),
	Volume("Volume");

	private String name;

	private UnitType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "UnitType{" + "name='" + name + '\'' + '}';
	}
}
