package Views;

import static Tools.Nums.*;
import static Tools.ComponentHelper.*;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.CardLayout;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class MainMenu extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -9036920661440733679L;

    public static final Rectangle SCREEN_SIZE = GraphicsEnvironment.getLocalGraphicsEnvironment()
	    .getMaximumWindowBounds();
    public static final int COMPONENT_MARGIN = 15;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    MainMenu frame = new MainMenu();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public MainMenu() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(toInt(SCREEN_SIZE.getWidth() * 0.8), toInt(SCREEN_SIZE.getHeight()));
	centralize(this, toInt(SCREEN_SIZE.getWidth()), toInt(SCREEN_SIZE.getHeight()));
	SpringLayout springLayout = new SpringLayout();
	getContentPane().setLayout(springLayout);
	addButtons(springLayout);
	JLabel mainMenuBackground = new JLabel("");
	springLayout.putConstraint(SpringLayout.NORTH, mainMenuBackground, 0, SpringLayout.NORTH, getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, mainMenuBackground, 0, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, mainMenuBackground, 0, SpringLayout.SOUTH, getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, mainMenuBackground, 0, SpringLayout.EAST, getContentPane());
	mainMenuBackground.setOpaque(true);
	getContentPane().add(mainMenuBackground, "name_24510291925800");

	setLabelIcon(mainMenuBackground, "./res/menu.jpg", new Rectangle(getSize()));

	JLabel lblNewLabel = new JLabel("REACTIVE CHEMISTRY");
	getContentPane().add(lblNewLabel);
	springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 50, SpringLayout.NORTH, getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 50, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel,50, SpringLayout.SOUTH,
		getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 50, SpringLayout.EAST, getContentPane());

    }

    private void addButtons(SpringLayout springLayout) {
	JPanel panel = new JPanel();
	panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panel.setOpaque(false);
	int buttonH = 40;
	int xMargin = toInt(getSize().getWidth()) / 3;
	getContentPane().add(panel);
	System.out.println(getSize().getWidth() / 2);
	springLayout.putConstraint(SpringLayout.NORTH, panel, toInt(getSize().getWidth() / 2 - buttonH * 5),
		SpringLayout.NORTH, getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, panel, xMargin, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, panel, -COMPONENT_MARGIN, SpringLayout.SOUTH, getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, panel, -xMargin, SpringLayout.EAST, getContentPane());
	panel.setLayout(null);

	JButton btnNewButton = new JButton("Exit");
	btnNewButton.setBounds(10, 277, 328, buttonH);
	panel.add(btnNewButton);

	JButton btnCredits = new JButton("Credits");
	btnCredits.setBounds(10, 226, 328, buttonH);
	panel.add(btnCredits);

	JButton btnNewButton_1_1 = new JButton("Settings");
	btnNewButton_1_1.setBounds(10, 175, 328, buttonH);
	panel.add(btnNewButton_1_1);

	JButton btnNewButton_1_1_1 = new JButton("Start");
	btnNewButton_1_1_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	btnNewButton_1_1_1.setBounds(10, 73, 328, buttonH);
	panel.add(btnNewButton_1_1_1);

	JComboBox comboBox = new JComboBox();
	comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	comboBox.setModel(
		new DefaultComboBoxModel(new String[] { "Alchemistry", "Covalent Bonds", "Balance Reactions" }));
	comboBox.setBounds(10, 11, 328, 50);
	panel.add(comboBox);

	JButton btnNewButton_1_1_2 = new JButton("Periodic Table");
	btnNewButton_1_1_2.setBounds(10, 124, 328, buttonH);
	panel.add(btnNewButton_1_1_2);

    }
}
/*
 * 

 */
