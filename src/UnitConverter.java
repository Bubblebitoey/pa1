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

	public UnitType[] getUnitTypes() {
		return unitFactory.getUnitTypes();
	}

	public Unit[] getUnit(UnitType type) {
		return unitFactory.getUnits(type);
	}

	/**
	 * @return recieve all units from class Length
	 */
	public Unit[] getUnitsLength() {
		return Length.values();
	}
	
	public Unit[] getUnitsArea() {
		return Area.values();
	}

	public Unit[] getUnitsRad() {
		return Radiation.values();
	}

	public Unit[] getUnitsWeight() {
		return Weight.values();
	}
}
