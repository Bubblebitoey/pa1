import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterUI extends JFrame {
	/***
	 * attributes for graphacal components
	 */
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

	/***
	 * this method use to run window
	 */
	public void run() {
		/**
		 * set size of window
		 */
		setSize(800, 100);
		setVisible(true);
	}

	/**
	 * initialize the components in the window
	 */
	private void initComponents() {

		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);

		firstInput = new JTextField("                             ");
		secondInput = new JTextField("                            ");
		unitconverter = new UnitConverter();

		// set p in first time
		leftToRight.setSelected(true);
		secondInput.setEnabled(false);

		/**
		 * add units into JComboBox
		 */
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

		/**
		 * make the button leftToright and rightToLeft can press only one button
		 */
		ButtonGroup group = new ButtonGroup();
		group.add(leftToRight);
		group.add(rightToLeft);

		/**
		 * add action for convert button
		 */
		ActionListener listener = new ConvertButtonListener();
		convertButton.addActionListener(listener);

		/**
		 * clear textfield to empty
		 */
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstInput.setText("");
				secondInput.setText("");
			}
		});

		/**
		 * when click leftToright button user allow to input number only in
		 * first textfield
		 */
		leftToRight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstInput.setEnabled(true);
				secondInput.setEnabled(false);
			}
		});

		/**
		 * when click rightToLeft button user allow to input number only in
		 * second textfield
		 */
		rightToLeft.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstInput.setEnabled(false);
				secondInput.setEnabled(true);
			}
		});

		/**
		 * add every components into window
		 */
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

	/**
	 * the action perform action when the "convert" button is pressed
	 */
	class ConvertButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			String s = "";
			Unit from, to;

			if (leftToRight.isSelected()) {
				s = firstInput.getText().trim();
				from = (Unit) firstUnit.getSelectedItem();
				to = (Unit) secondUnit.getSelectedItem();
			} else {
				s = secondInput.getText().trim();
				from = (Unit) secondUnit.getSelectedItem();
				to = (Unit) firstUnit.getSelectedItem();
			}

			if (s.length() > 0) {
				// if user not input number into textfield the program will show
				// error
				try {
					// parse String to double
					Double recieveWord = Double.valueOf(s);
					if (leftToRight.isSelected()) {
						secondInput.setText(unitconverter.convert(recieveWord, from, to) + "");
					} else {
						firstInput.setText(unitconverter.convert(recieveWord, from, to) + "");
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}

			}

		}
	}

	public static void main(String[] args) {
		UnitConverter converter = new UnitConverter();
		ConverterUI view = new ConverterUI(converter);
		view.run();
	}
}
