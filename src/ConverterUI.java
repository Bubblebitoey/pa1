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
	private JRadioButton leftToRight = new JRadioButton("Left->Right");
	private JRadioButton rightToLeft = new JRadioButton("Right->Left");

	private Unit from;
	private Unit to;

	public void run() {
		setSize(800, 100);
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

		ButtonGroup group = new ButtonGroup();
		group.add(leftToRight);
		group.add(rightToLeft);

		ActionListener listener = new ConvertButtonListener();

		convertButton.addActionListener(listener);
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstInput.setText("");
				secondInput.setText("");
			}
		});

		secondInput.setEnabled(false);
		leftToRight.setSelected(true);

		leftToRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstInput.setEnabled(true);
				secondInput.setEnabled(false);
			}
		});

		rightToLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstInput.setEnabled(false);
				secondInput.setEnabled(true);
			}
		});

		this.add(firstInput);
		this.add(firstUnit);
		this.add(equalSign);
		this.add(secondInput);
		this.add(secondUnit);
		this.add(convertButton);
		this.add(clearButton);
		this.add(leftToRight);
		this.add(rightToLeft);

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

			from = (Unit) firstUnit.getSelectedItem();
			to = (Unit) secondUnit.getSelectedItem();

			System.out.println("actionPerformed: input=" + s);

			if (s.length() > 0) {
				try {
					Double recieveWord = Double.valueOf(s);
					if (leftToRight.isSelected()) {
						secondInput.setText(unitconverter.convert(recieveWord, from, to) + "");
					} else {
						firstInput.setText(unitconverter.convert(recieveWord, to, from) + "");
					}

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}

		}
	}
}
