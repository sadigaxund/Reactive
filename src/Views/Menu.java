package Views;

import static Tools.ComponentHelper.setLabelIcon;
import static Tools.Nums.toInt;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import Tools.CustomComboBox;
import Tools.ComponentHelper.StyledButtonUI;

public class Menu extends Template {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Menu frame = new Menu();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public Menu() {
	super();

    }

    @Override
    protected void addBody() {

	int xMargin = toInt(getSize().getWidth()) / 3;
	int buttonW = 35;
	int buttonH = 30;

	JPanel panel = new JPanel();
	panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panel.setOpaque(false);
	int panelHeight = toInt((SCREEN_SIZE.getHeight()) - (buttonH * 5 + COMPONENT_MARGIN * 2.5) * 2) + 5;
	springLayout.putConstraint(SpringLayout.WEST, panel, xMargin + COMPONENT_MARGIN/2, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, panel, -COMPONENT_MARGIN*5, SpringLayout.SOUTH,
		getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, panel, -xMargin + COMPONENT_MARGIN/2, SpringLayout.EAST, getContentPane());
	springLayout.putConstraint(SpringLayout.NORTH, panel, getHeight() - 425, SpringLayout.NORTH, getContentPane()); // FIXME: Absolute coordinates

	panel.setLayout(null);
	getContentPane().add(panel);

	addTitleBar(springLayout);
	String[][] countryList = { { "Alchemistry", "./res/icons/015-dna.png" },
		{ "Covalent Bonds", "./res/icons/049-molecule.png" },
		{ "Balance Reactions", "./res/icons/025-molecule.png" } };

	/* ===================FUCKS UP===================== */

	CustomComboBox comboBox = null;
	LookAndFeel previousLF = UIManager.getLookAndFeel();
	try {
	    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    comboBox = new CustomComboBox(300, 50);
	    UIManager.setLookAndFeel(previousLF);
	} catch (Exception e) {
	}
	comboBox.addItems(countryList);

	comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	comboBox.setBounds(10, COMPONENT_MARGIN, 344, 50);
	comboBox.setBackground(new Color(153, 104, 189));
	comboBox.setForeground(Color.white);
	panel.add(comboBox);

	/* ===================FUCKS UP===================== */

	JButton btnNewButton_1_1_1 = new JButton("START");
	btnNewButton_1_1_1.setBounds(10, comboBox.getY() + comboBox.getHeight() + COMPONENT_MARGIN, 344, 40);// ===================FUCKS
													     // UP=====================
	// btnNewButton_1_1_1.setBounds(10, COMPONENT_MARGIN, 344, 40);

	panel.add(btnNewButton_1_1_1);
	btnNewButton_1_1_1.setUI(new StyledButtonUI());
	btnNewButton_1_1_1.setBackground(new Color(153, 104, 189));
	btnNewButton_1_1_1.setForeground(Color.white);
	btnNewButton_1_1_1.setFont(new Font("HP Simplified Light", Font.BOLD, 18));

	JButton btnNewButton_1_1_2 = new JButton("PERIODIC TABLE");
	btnNewButton_1_1_2.setBounds(10, btnNewButton_1_1_1.getY() + btnNewButton_1_1_1.getHeight() + COMPONENT_MARGIN,
		344, 40);
	btnNewButton_1_1_2.setUI(new StyledButtonUI());
	btnNewButton_1_1_2.setBackground(new Color(153, 104, 189));
	btnNewButton_1_1_2.setForeground(Color.white);
	btnNewButton_1_1_2.setFont(new Font("HP Simplified Light", Font.BOLD, 18));
	panel.add(btnNewButton_1_1_2);

	JButton btnNewButton_1_1 = new JButton("SETTINGS");
	btnNewButton_1_1.setBounds(10, btnNewButton_1_1_2.getY() + btnNewButton_1_1_2.getHeight() + COMPONENT_MARGIN,
		344, 40);
	btnNewButton_1_1.setUI(new StyledButtonUI());
	btnNewButton_1_1.setBackground(new Color(153, 104, 189));
	btnNewButton_1_1.setForeground(Color.white);
	btnNewButton_1_1.setFont(new Font("HP Simplified Light", Font.BOLD, 18));
	panel.add(btnNewButton_1_1);

	JButton btnCredits = new JButton("CREDITS");
	btnCredits.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	btnCredits.setBounds(10, btnNewButton_1_1.getY() + btnNewButton_1_1.getHeight() + COMPONENT_MARGIN, 344, 40);
	btnCredits.setUI(new StyledButtonUI());
	btnCredits.setBackground(new Color(153, 104, 189));
	btnCredits.setForeground(Color.white);
	btnCredits.setFont(new Font("HP Simplified Light", Font.BOLD, 18));
	panel.add(btnCredits);

	JButton btnNewButton = new JButton("EXIT");
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	btnNewButton.setBounds(10, btnCredits.getY() + btnCredits.getHeight() + COMPONENT_MARGIN, 344, 40);
	btnNewButton.setUI(new StyledButtonUI());
	btnNewButton.setBackground(new Color(153, 104, 189));
	btnNewButton.setForeground(Color.white);
	btnNewButton.setFont(new Font("HP Simplified Light", Font.BOLD, 18));
	panel.add(btnNewButton);

	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	getContentPane().add(lblNewLabel);
	springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, COMPONENT_MARGIN * 8, SpringLayout.NORTH,
		getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, COMPONENT_MARGIN * 4, SpringLayout.WEST,
		getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel,
		springLayout.getConstraints(panel).getHeight().getValue() - COMPONENT_MARGIN, SpringLayout.SOUTH,
		getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -50, SpringLayout.EAST, getContentPane());
	int w = springLayout.getConstraints(panel).getWidth().getValue();
	int h = springLayout.getConstraints(panel).getHeight().getValue();
	setLabelIcon(lblNewLabel, "./res/logo.png", new Rectangle(-toInt(w * 0.60), -toInt(h / 2 * 1.1)));
	
    }

  
}
