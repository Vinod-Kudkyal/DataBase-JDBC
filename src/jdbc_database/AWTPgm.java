package jdbc_database;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class AWTPgm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AWTPgm window = new AWTPgm();
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
	public AWTPgm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		frame.getContentPane().add(rdbtnNewRadioButton, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		frame.getContentPane().add(rdbtnNewRadioButton_1, BorderLayout.WEST);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		frame.getContentPane().add(rdbtnNewRadioButton_2, BorderLayout.EAST);
	}

}
