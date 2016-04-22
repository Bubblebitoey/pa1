
public class UnitConverter {
	
	/**
	 * 
	 * @param amount the number that user input to change
	 * @param fromUnit unit that user want to convert
	 * @param toUnit unit that user want to convert to
	 * @return answer of number after converted unit
	 */
	public double convert(double amount, Unit fromUnit, Unit toUnit) {
		return amount * fromUnit.getValue() / toUnit.getValue();
	}
	
	/**
	 * 
	 * @return recieve all units from class Length
	 */
	public Unit[] getUnits() {
		return Length.values();
	}

}
