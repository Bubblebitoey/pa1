import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterUI extends JFrame {
	private JButton convertButton = new JButton("Convert!");
	private UnitConverter unitconverter;
	private JTextField firstInput;
	private JTextField secondInput;
	private JComboBox<Unit> firstUnit;
	private JComboBox<Unit> secondUnit;
	private JLabel equalSign = new JLabel("=");
	private JButton clearButton = new JButton("Clear");

	public void run() {
		setVisible(true);
	}

	private void initComponents() {

		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);

		firstInput = new JTextField("                             ");
		secondInput = new JTextField("                            ");
		unitconverter = new UnitConverter();

		firstUnit = new JComboBox<Unit>();
		Unit[] lengths = unitconverter.getUnits();
		for (Unit u : lengths)
			firstUnit.addItem(u);
		firstUnit = new JComboBox<Unit>(lengths);

		secondUnit = new JComboBox<Unit>();
		Unit[] lengths1 = unitconverter.getUnits();
		for (Unit u : lengths)
			secondUnit.addItem(u);
		secondUnit = new JComboBox<Unit>(lengths1);

		ActionListener listener = new ConvertButtonListener();

		convertButton.addActionListener(listener);
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		this.add(firstInput);
		this.add(firstUnit);
		this.add(equalSign);
		this.add(secondInput);
		this.add(secondUnit);
		this.add(convertButton);
		this.add(clearButton);

		this.pack();
	}

	public ConverterUI(UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	class ConvertButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			String s = firstInput.getText().trim();

			System.out.println("actionPerformed: input=" + s);

			if (s.length() > 0) {
				try {
					Double recieveWord = Double.valueOf(s);
					Unit unit1 = (Unit) firstUnit.getSelectedItem();
					Unit unit2 = (Unit) secondUnit.getSelectedItem();

					secondInput.setText(unitconverter.convert(recieveWord, unit1, unit2) + "");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
	}
}
