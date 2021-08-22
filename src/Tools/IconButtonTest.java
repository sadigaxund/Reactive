package Tools;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;

public class IconButtonTest {

    private JFrame frame = new JFrame("sssssssss");
    private JButton tip1Null = new JButton(" test button ");

    public IconButtonTest() {

	tip1Null.setFont(new Font("Serif", Font.BOLD, 14));
	tip1Null.setForeground(Color.darkGray);
	tip1Null.setBounds(0, 0, 60, 60);
	frame.setLayout(null);
	tip1Null.addActionListener(new java.awt.event.ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	tip1Null.setBorderPainted(true);
	tip1Null.setFocusPainted(false);
	tip1Null.setHorizontalTextPosition(SwingConstants.CENTER);
	tip1Null.setVerticalTextPosition(SwingConstants.BOTTOM);
	tip1Null.setUI(new ModifButtonUI("./res/frame_icon.png"));

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(tip1Null, BorderLayout.CENTER);
	frame.setLocation(150, 150);
	frame.setPreferredSize(new Dimension(310, 300));
	frame.setLocationRelativeTo(null);
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String args[]) {
	EventQueue.invokeLater(new Runnable() {

	    @Override
	    public void run() {
		IconButtonTest taib = new IconButtonTest();
	    }
	});
    }
}

class ModifButtonUI extends ButtonUI {

    // private static final ModifButtonUI buttonUI = new ModifButtonUI();

    private String iconPath;

    public ModifButtonUI(String iconPath) {
	this.iconPath = iconPath;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
	BufferedImage img = null;
	try {
	    img = ImageIO.read(new File(iconPath));
	} catch (IOException e) {
	}
	int iconW = (int) (c.getWidth() * 0.9);
	int iconH = (int) (c.getHeight() * 0.9);
	int iconX = (c.getWidth() - iconW) / 2;
	int iconY = (c.getHeight() - iconH) / 2;
	Image image = img.getScaledInstance(iconW, iconH, Image.SCALE_SMOOTH);
	BufferedImage buffered = new BufferedImage(iconW + iconX, iconH + iconY, BufferedImage.TYPE_INT_ARGB);
	buffered.getGraphics().drawImage(image, iconX, iconY, null);
	img = buffered;

	/* Draw the image, applying the filter */
	((Graphics2D) g).drawImage(img, null, 0, 0);
    }

}
