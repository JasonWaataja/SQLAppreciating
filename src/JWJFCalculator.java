import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JWJFCalculator {

	private static final int MAX_DIGITS = 10;

	private JFrame frame;
	private JTextField txtEnterACalculation;

	// buttons
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	private JButton zeroButton;
	private JButton plusButton;
	private JButton minusButton;
	private JButton clearButton;
	private JButton equalsButton;
	private JButton timesButton;
	private JButton divideButton;
	private JButton negativeButton;
	private JButton decimalButton;

	// whether or not it is still and integer
	private boolean isInt;

	// the last number to do an operation on
	private double lastNumber;

	// current number being entered
	private double currentNumber;

	// number of digits used so far
	private int usedDigits;

	// number of digits since decimal
	private int digitsSinceDecimal;

	// enum to represent the possible operations, minus, plus, times, divide
	private enum Operation {
		ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/"), NONE("");

		private final String symbol;

		private Operation(String symbol) {
			this.symbol = symbol;
		}

		public String toString() {
			return symbol;
		}
	}

	// has encountered a decimal yet, this is used because it won't allow to
	// enter more than one decimal point
	private boolean usedDecimal;

	// the last operation used
	private Operation lastOperation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JWJFCalculator window = new JWJFCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JWJFCalculator() {

		isInt = true;
		lastNumber = 0;
		currentNumber = 0;
		usedDecimal = false;
		usedDigits = 0;
		digitsSinceDecimal = 0;
		lastOperation = Operation.NONE;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtEnterACalculation = new JTextField();
		txtEnterACalculation.setText("Enter a calculation");
		frame.getContentPane().add(txtEnterACalculation, BorderLayout.NORTH);
		txtEnterACalculation.setColumns(10);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));

		JPanel panel2 = new JPanel();
		frame.getContentPane().add(panel2, BorderLayout.EAST);
		panel2.setLayout(new GridLayout(2, 0, 0, 0));

		sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(7);
			}
		});
		panel.add(sevenButton);

		eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(8);
			}
		});
		panel.add(eightButton);

		nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(9);
			}
		});
		panel.add(nineButton);

		plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processOperation(Operation.ADDITION);
			}
		});
		panel.add(plusButton);

		fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(4);
			}
		});
		panel.add(fourButton);

		fiveButton = new JButton("5");
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(5);
			}
		});
		panel.add(fiveButton);

		sixButton = new JButton("6");
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(6);
			}
		});
		panel.add(sixButton);

		minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processOperation(Operation.SUBTRACTION);
			}
		});
		panel.add(minusButton);

		oneButton = new JButton("1");
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				processNumber(1);
			}
		});
		panel.add(oneButton);

		twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(2);
			}
		});
		panel.add(twoButton);

		threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(3);
			}
		});
		panel.add(threeButton);

		timesButton = new JButton("*");
		timesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processOperation(Operation.MULTIPLICATION);
			}
		});
		panel.add(timesButton);

		negativeButton = new JButton("+/-");
		negativeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentNumber *= -1;
				displayNumber(currentNumber);
			}
		});
		panel.add(negativeButton);

		zeroButton = new JButton("0");
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processNumber(0);
			}
		});
		panel.add(zeroButton);

		decimalButton = new JButton(".");
		decimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usedDecimal = true;
				isInt = false;
				displayNumber(currentNumber);
			}
		});
		panel.add(decimalButton);

		divideButton = new JButton("/");
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processOperation(Operation.DIVISION);
			}
		});
		panel.add(divideButton);

		clearButton = new JButton("C");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startNewInput();
				lastNumber = 0;
				isInt = true;
				displayNumber(0);
			}
		});
		panel2.add(clearButton);

		equalsButton = new JButton("=");
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processEquals();
			}
		});
		panel2.add(equalsButton);
	}

	private void displayNumber(double number) {
		String output;
		if (isInt) {
			output = Integer.toString((int) number);
		} else {
			output = Double.toString(number);
		}
		boolean overflowed = false;
		String tester = output;
		int lengthBefore = output.length();
		tester.replace(".", "");
		tester.replace("-", "");
		String processedString = output;
		if (tester.length() > MAX_DIGITS) {
			overflowed = true;
			processedString = output.substring(0, MAX_DIGITS + output.length() - tester.length() + 1);
			processedString += " overflow";
		}
		this.txtEnterACalculation.setText(processedString);

	}

	// process an input if it was for a number
	private void processNumber(int input) {
		if (input >= 0 && input <= 9 && usedDigits < 10) {
			if (currentNumber != 0 && usedDigits == 0) {
				startNewInput();
			}
			/*
			 * different behaviour based on which side of the decimal
			 */
			double sign = (int )Math.signum(currentNumber);
			if (sign == 0)
				sign = 1;
			if (!usedDecimal) {
				if (!(currentNumber == 0 && usedDigits == 1)) {
					usedDigits++;
				}
				currentNumber = currentNumber * 10 + (sign * input);
			} else {
				usedDigits++;
				digitsSinceDecimal++;
				currentNumber += (Math.pow(10, -1 * digitsSinceDecimal)) * (sign *input);
			}
		}
		displayNumber(currentNumber);
	}

	private void startNewInput() {
		currentNumber = 0;
		usedDigits = 0;
		usedDecimal = false;
		digitsSinceDecimal = 0;
	}

	// does the action of the equals button
	private void processEquals() {
		if (usedDigits > 0) {
			if (lastOperation == Operation.DIVISION && currentNumber == 0) {
				this.txtEnterACalculation.setText("Can't divide by zero");
				startNewInput();
				lastNumber = currentNumber;
				lastOperation = Operation.NONE;
			} else {
				double result = currentNumber;
				switch (lastOperation) {
				case NONE:
					break;
				case ADDITION:
					result += lastNumber;
					break;
				case SUBTRACTION:
					result -= lastNumber;
					break;
				case MULTIPLICATION:
					result *= lastNumber;
					break;
				case DIVISION:
					result = (double) lastNumber / (double) result;
					isInt = false;
					break;
				}
				displayNumber(result);
				startNewInput();
				//lastNumber = result;
				currentNumber = result;
				lastOperation = Operation.NONE;
			}
		}

	}

	// processes an input if it is one of the operations
	private void processOperation(Operation operation) {
		if (lastOperation != Operation.NONE) {
			processEquals();
		} else {
			this.txtEnterACalculation.setText(operation.toString());
			lastNumber = currentNumber;
			startNewInput();
		}
		this.lastOperation = operation;
	}

}
