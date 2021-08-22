package Views;

import static Tools.Nums.*;
import static Tools.ComponentHelper.*;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.SpringLayout;
import javax.swing.ImageIcon;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Tools.ComponentHelper;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public abstract class Template extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = -9036920661440733679L;

    public static final Rectangle SCREEN_SIZE = GraphicsEnvironment.getLocalGraphicsEnvironment()
	    .getMaximumWindowBounds();
    public static final Rectangle FRAME_SIZE = new Rectangle(toInt(SCREEN_SIZE.getWidth() * 0.8),
	    toInt(SCREEN_SIZE.getHeight()));
    public static final int COMPONENT_MARGIN = 15;
    public static int TITLEBAR_HEIGHT = 40;

    protected SpringLayout springLayout;

    protected JLabel mainMenuBackground;
    protected JPanel titlebar;
    protected JLabel frameIcon;
    protected JLabel lblReactive;
    protected JButton exitButton;

    private static final String BCKGND_PIC_PATH = "./res/menu.jpg";
    private static final String FRAME_ICON_PATH = "./res/frame_icon.png";
    private static final String X_ICON_PATH = "./res/x.png";
    private static final String TITLE = "REACTIVE";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Template frame = new Template();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
    }

    /**
     * Create the frame.
     */
    public Template() {

	initFrame();
	//addTitleBar(springLayout);

    }

    protected abstract void addBody();

    private void initFrame() {
	setUndecorated(true);
	setIconImage(new ImageIcon(FRAME_ICON_PATH).getImage());
	setTitle(TITLE);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(toInt(FRAME_SIZE.getWidth()), toInt(FRAME_SIZE.getHeight()));
	centralize(this, toInt(SCREEN_SIZE.getWidth()), toInt(SCREEN_SIZE.getHeight()));
	springLayout = new SpringLayout();
	getContentPane().setLayout(springLayout);

	FrameDragListener frameDragListener = new FrameDragListener(this);
	addMouseListener(frameDragListener);
	addMouseMotionListener(frameDragListener);
	addBody();
	/*
	 * Note: Add background at the end, cuz swing paints components in reverse order
	 * you added them. So if you see only background pic you know why
	 */
	mainMenuBackground = new JLabel("");
	mainMenuBackground.setAlignmentY(Component.BOTTOM_ALIGNMENT);

	springLayout.putConstraint(SpringLayout.NORTH, mainMenuBackground, 0, SpringLayout.NORTH, getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, mainMenuBackground, 0, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, mainMenuBackground, 0, SpringLayout.SOUTH, getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, mainMenuBackground, 0, SpringLayout.EAST, getContentPane());
	mainMenuBackground.setOpaque(true);
	getContentPane().add(mainMenuBackground, "background");

	setLabelIcon(mainMenuBackground, BCKGND_PIC_PATH, new Rectangle(getSize()));
    }

    protected void addTitleBar(SpringLayout springLayout) {
	titlebar = new JPanel();
	int ACTUAL_TITLEBAR_HEIGHT = toInt((SCREEN_SIZE.getHeight() - TITLEBAR_HEIGHT));
	titlebar.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 0, true),
		new MatteBorder(2, 0, 0, 0, (Color) new Color(128, 128, 128))));
	springLayout.putConstraint(SpringLayout.NORTH, titlebar, 0, SpringLayout.NORTH, getContentPane());
	springLayout.putConstraint(SpringLayout.WEST, titlebar, 0, SpringLayout.WEST, getContentPane());
	springLayout.putConstraint(SpringLayout.SOUTH, titlebar, -ACTUAL_TITLEBAR_HEIGHT, SpringLayout.SOUTH,
		getContentPane());
	springLayout.putConstraint(SpringLayout.EAST, titlebar, 0, SpringLayout.EAST, getContentPane());
	getContentPane().add(titlebar);
	titlebar.setLayout(null);

	frameIcon = new JLabel("");
	frameIcon.setBounds(0, 0, 40, 40);
	titlebar.add(frameIcon);
	setLabelIcon(frameIcon, FRAME_ICON_PATH,
		new Rectangle(toInt(40 * 0.7), toInt(frameIcon.getBounds().getHeight() * 0.7)));
	centralizeY(frameIcon, 40);
	centralizeX(frameIcon, 45);

	lblReactive = new JLabel(TITLE);
	lblReactive.setAlignmentY(2.0f);
	lblReactive.setFont(new Font("HP Simplified Light", Font.BOLD, 18));
	lblReactive.setBounds(50, 5, 131, 30);
	titlebar.add(lblReactive);

	exitButton = new JButton("New button");
	exitButton.setUI(new IconedButtonUI(X_ICON_PATH));
	exitButton.setBorder(null);
	exitButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	    }
	});
	exitButton.setBorderPainted(false);
	exitButton.setBounds(1055, 3, 35, 35);
	Image newImage = new ImageIcon("./res/x.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
	exitButton.setIcon(new ImageIcon(newImage));
	exitButton.addMouseListener(new MouseListener() {

	    @Override
	    public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
		exitButton.setBounds(1057, 5, 30, 30);

	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		exitButton.setBounds(1055, 3, 35, 35);

	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {

	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
		System.exit(0);

	    }
	});
	titlebar.add(exitButton);

    }
}
/*
 * 

 */
