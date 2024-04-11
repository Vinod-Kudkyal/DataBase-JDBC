package jdbc_database;

import javax.swing.JApplet;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;

public class AppletPgm extends JApplet {

	/**
	 * Create the applet.
	 */
	public AppletPgm() {
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		getContentPane().add(rdbtnNewRadioButton, BorderLayout.CENTER);

	}

}
