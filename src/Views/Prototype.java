package Views;

import static Tools.Nums.*;
import static Tools.ComponentHelper.*;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import Tools.CustomComboBox;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;

public class Prototype extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -9036920661440733679L;

    public static final Rectangle SCREEN_SIZE = GraphicsEnvironment.getLocalGraphicsEnvironment()
	    .getMaximumWindowBounds();
    public static final int COMPONENT_MARGIN = 15;
    public static int TITLEBAR_HEIGHT = 40;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Prototype frame = new Prototype();
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
    public Prototype() {
	setUndecorated(true);
	setIconImage(new ImageIcon(".\\res\\frame_icon.png").getImage());
	setTitle("Reactive");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(toInt(SCREEN_SIZE.getWidth() * 0.8), toInt(SCREEN_SIZE.getHeight()));
	centralize(this, toInt(SCREEN_SIZE.getWidth()), toInt(SCREEN_SIZE.getHeight()));
	SpringLayout springLayout = new SpringLayout();
	getContentPane().setLayout(springLayout);

	FrameDragListener frameDragListener = new FrameDragListener(this);
	addMouseListener(frameDragListener);
	addMouseMotionListener(frameDragListener);

	addButtons(springLayout);

	JLabel mainMenuBackground = new JLabel("");
	mainMenuBackground.setAlignmentY(Component.BOTTOM_ALIGNMENT);

	springLayout.putConstraint(SpringLayout.NORTH, mainMenuBackground, 0, SpringLayout.NORTH, getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, mainMenuBackground, 0, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, mainMenuBackground, 0, SpringLayout.SOUTH, getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, mainMenuBackground, 0, SpringLayout.EAST, getContentPane());
	mainMenuBackground.setOpaque(true);
	getContentPane().add(mainMenuBackground, "name_24510291925800");

	setLabelIcon(mainMenuBackground, "./res/menu.jpg", new Rectangle(getSize()));

    }

    @SuppressWarnings({ "unused" })
    private void addButtons(SpringLayout springLayout) {

	int xMargin = toInt(getSize().getWidth()) / 3;
	int buttonW = 35;
	int buttonH = 30;

	JPanel panel = new JPanel();
	panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	panel.setOpaque(false);
	int panelHeight = toInt((SCREEN_SIZE.getHeight()) - (buttonH * 5 + COMPONENT_MARGIN * 2.5) * 2) + 5;
	springLayout.putConstraint(SpringLayout.WEST, panel, xMargin, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, panel, -COMPONENT_MARGIN, SpringLayout.SOUTH,
		getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, panel, -xMargin, SpringLayout.EAST, getContentPane());
	springLayout.putConstraint(SpringLayout.NORTH, panel, panelHeight, SpringLayout.NORTH, getContentPane());

	panel.setLayout(null);

	JPanel titlebar = new JPanel();
	TITLEBAR_HEIGHT = toInt((SCREEN_SIZE.getHeight() - TITLEBAR_HEIGHT));

	titlebar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true),
		new MatteBorder(2, 0, 0, 0, (Color) new Color(128, 128, 128))));
	springLayout.putConstraint(SpringLayout.NORTH, titlebar, 0, SpringLayout.NORTH, getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, titlebar, 0, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, titlebar, -TITLEBAR_HEIGHT, SpringLayout.SOUTH,
		getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, titlebar, 0, SpringLayout.EAST, getContentPane());
	getContentPane().add(titlebar);
	titlebar.setLayout(null);

	JLabel frameIcon = new JLabel("");
	frameIcon.setBounds(0, 0, 40, 40);
	titlebar.add(frameIcon);
	setLabelIcon(frameIcon, "./res/frame_icon.png",
		new Rectangle(toInt(40 * 0.7), toInt(frameIcon.getBounds().getHeight() * 0.7)));
	centralizeY(frameIcon, 40);
	centralizeX(frameIcon, 45);

	JLabel lblReactive = new JLabel("REACTIVE");
	lblReactive.setAlignmentY(2.0f);
	lblReactive.setFont(new Font("HP Simplified Light", Font.BOLD, 18));
	lblReactive.setBounds(50, 5, 131, 30);
	titlebar.add(lblReactive);
	getContentPane().add(panel);

	String[][] countryList = { { "Alchemistry", "./res/icons/015-dna.png" },
		{ "Chemical Bonds", "./res/icons/049-molecule.png" },
		{ "Balance Reactions", "./res/icons/025-molecule.png" } };

	/* ======================================== */

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

	/* ======================================== */

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
/*
 * 

 */
