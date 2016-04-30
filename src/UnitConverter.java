public class UnitConverter {
	private UnitFactory unitFactory = UnitFactory.getInstance();

	/**
	 * @param amount
	 * 		the number that user input to change
	 * @param fromUnit
	 * 		unit that user want to convert
	 * @param toUnit
	 * 		unit that user want to convert to
	 * @return answer of number after converted unit
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		return amount * fromUnit.getValue() / toUnit.getValue();
	}

	/**
	 *
	 * @return unit types from unit factory
	 */
	public UnitType[] getUnitTypes() {
		return unitFactory.getUnitTypes();
	}

	/**
	 *
	 * @param type unit in UnitType
	 * @return each unit from unit factory
	 */
	public Unit[] getUnit(UnitType type) {
		return unitFactory.getUnits(type);
	}

	/**
	 * @return recieve all units from class Length
	 */
	public Unit[] getUnitsLength() {
		return Length.values();
	}

	/**
	 *
	 * @return recieve all units from class Area
	 */
	public Unit[] getUnitsArea() {
		return Area.values();
	}

	/**
	 *
	 * @return recieve all units from class Volume
	 */
	public Unit[] getUnitsVolume() { return Volume.values(); }

	/**
	 *
	 * @return recieve all units from class Weight
	 */
	public Unit[] getUnitsWeight() {
		return Weight.values();
	}
}
