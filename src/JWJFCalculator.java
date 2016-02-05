import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class JWJFCalculator {

	private JFrame frame;
	private JTextField txtEnterACalculation;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton clearButton;
	private JButton equalsButton;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;

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
		frame.getContentPane().add(panel2,  BorderLayout.EAST);
		panel2.setLayout(new GridLayout(2, 0, 0, 0));
		
		button = new JButton("1");
		panel.add(button);
		
		button_3 = new JButton("2");
		panel.add(button_3);
		
		btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		button_4 = new JButton("3");
		panel.add(button_4);
		
		button_1 = new JButton("2");
		panel.add(button_1);
		
		button_2 = new JButton("3");
		panel.add(button_2);
		
		btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("New button");
		panel.add(btnNewButton_10);
		
		clearButton = new JButton("C");
		panel2.add(clearButton);
		
		equalsButton = new JButton("=");
		panel2.add(equalsButton);
	}

}
