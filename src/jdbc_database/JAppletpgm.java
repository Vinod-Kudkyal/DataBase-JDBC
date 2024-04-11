package jdbc_database;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JApplet;

public class JAppletpgm extends JApplet {
	@Override
	public void init() {
		// TODO Auto-generated method stub
		String[] c = {"Solapur" , "Pune" , "Banglore" , "Mumbai"};
        JLabel a = new JLabel();
        a.setBounds(170 , 100 , 200 , 20);
        add(a);
        JComboBox city = new JComboBox<>(c);
        city.setBounds(50 , 100 , 100 , 20);
        add(city);
        city.addItemListener(new ItemListener () {
            public void itemStateChanged(ItemEvent e) {
                a.setText("You are in "+city.getSelectedItem());
            }
        });
        setLayout(null);
		super.init();
	}
}
//<applet code="JAppletpgm.class" width=300 height =300/>