package Tools;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CustomComboBoxTester extends JFrame {

    public CustomComboBoxTester() {
	super("Demo program for custom combobox");
	setLayout(new FlowLayout());

	LookAndFeel previousLF = UIManager.getLookAndFeel();
	CustomComboBox customCombobox = null;
	try {
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    customCombobox = new CustomComboBox(300, 50);
	    UIManager.setLookAndFeel(previousLF);
	} catch (Exception e) {
	}
	customCombobox.setEditable(true);
	customCombobox.addItems(countryList);

	add(customCombobox);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(400, 100);
	setLocationRelativeTo(null); // center on screen
    }

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		new CustomComboBoxTester().setVisible(true);
	    }
	});
    }

    private String[][] countryList = { { "USA", "./res/x.png" }, { "India", "in.png" }, { "Vietnam", "vn.png" },
	    { "Germany", "de.png" }, { "Canada", "ca.png" }, { "Japan", "jp.png" }, { "Great Britain", "gb.png" },
	    { "France", "fr.png" } };
}