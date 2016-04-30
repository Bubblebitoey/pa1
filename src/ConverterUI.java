
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
	private JComboBox<Unit> firstUnit = new JComboBox<>();
	private JComboBox<Unit> secondUnit=new JComboBox<>();
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

		addUnit(UnitType.Length);

		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("menu");
		JMenuItem itemLength = new JMenuItem("Length");
		itemLength.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUnit(UnitType.Length);
			}
		});
		JMenuItem itemArea = new JMenuItem("Area");
		itemArea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUnit(UnitType.Area);
			}
		});
		JMenuItem itemWeight = new JMenuItem("Weight");
		itemWeight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUnit(UnitType.Weight);
			}
		});
		JMenuItem itemVolume = new JMenuItem("Volume");
		itemVolume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUnit(UnitType.Volume);
			}
		});
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(itemLength);
		menu.add(itemArea);
		menu.add(itemVolume);
		menu.add(itemWeight);
		menu.add(exit);

		menuBar.add(menu);

		setJMenuBar(menuBar);

		firstInput = new JTextField("                             ");
		secondInput = new JTextField("                            ");
		unitconverter = new UnitConverter();

		// set p in first time
		leftToRight.setSelected(true);
		secondInput.setEnabled(false);

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

	public void addUnit(UnitType type) {
		firstUnit.removeAllItems();
		secondUnit.removeAllItems();

				Unit[] units1 = unitconverter.getUnit(type);
				for (Unit u : units1)
					firstUnit.addItem(u);

				Unit[] units2 = unitconverter.getUnit(type);
				for (Unit u : units2)
					secondUnit.addItem(u);
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
						secondInput.setText(String.format("%.5g", unitconverter.convert(recieveWord, from, to)));
					} else {
						firstInput.setText(String.format("%.5g", unitconverter.convert(recieveWord, from, to)));
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}

			}

		}
	}

	class ItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent evt) {
			//check that what user select
		}
	}
}
