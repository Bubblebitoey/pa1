import javax.lang.model.type.UnionType;

public class UnitFactory {

	private static UnitFactory instance;
	UnitType[] type = new UnitType[4];

	// constructor
	private UnitFactory() {

	}

	public static UnitFactory getInstance() {
		if (instance == null) return instance = new UnitFactory();
		return instance;
	}

	/**
	 *
	 * @return all units
	 */
	public UnitType[] getUnitTypes() {
		return type;
	}

	/**
	 *
	 * @param unitType each unit
	 * @return unit in category of each unit
	 */
	public Unit[] getUnits(UnitType unitType) {
		if (unitType.equals(UnitType.Area))
			return Area.values();
		else if(unitType.equals(UnitType.Length))
			return Length.values();
		else if(unitType.equals(UnitType.Volume))
			return Volume.values();
		else if(unitType.equals(UnitType.Weight))
			return Weight.values();
		else return null;

	}


}
