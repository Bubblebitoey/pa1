
public class App {
	
	
	public static void main (String[]args) {
		UnitConverter converter = new UnitConverter();
		ConverterUI view = new ConverterUI(converter);
		view.run();
	}

}
