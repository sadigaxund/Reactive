package Tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import Utils.JImages;

public class ComponentHelper {

    public static void centralize(Component c, int w, int h) {
	c.setLocation((w - c.getWidth()) / 2, (h - c.getHeight()) / 2);
    }

    public static void centralizeX(Component c, int w) {
	c.setLocation((w - c.getWidth()) / 2, c.getY());
    }

    public static void centralizeY(Component c, int h) {
	c.setLocation(c.getX(), (h - c.getHeight()) / 2);
    }

    public static void setLabelIcon(JLabel lbl, String iconPath, Rectangle d) {
	lbl.setBounds(d); // SMILE FACE LOCATION
	Image newImage = new ImageIcon(iconPath).getImage().getScaledInstance((int) d.getWidth(), (int) d.getHeight(),
		Image.SCALE_SMOOTH);
	// Image smileFaceIcon = JImages.scaleImage(, );
	lbl.setIcon(new ImageIcon(newImage));
    }

    public static void setButtonIcon(JButton btn, String iconPath, Rectangle d) {
	// btn.setBounds(d); // SMILE FACE LOCATION
	Image smileFaceIcon = JImages.scaleImage(new ImageIcon(iconPath).getImage(), (int) d.getWidth(),
		(int) d.getHeight());
	btn.setIcon(new ImageIcon(smileFaceIcon));
    }

    public static class FrameDragListener extends MouseAdapter {

	private final JFrame frame;
	private Point mouseDownCompCoords = null;

	public FrameDragListener(JFrame frame) {
	    this.frame = frame;
	}

	public void mouseReleased(MouseEvent e) {
	    mouseDownCompCoords = null;
	}

	public void mousePressed(MouseEvent e) {
	    mouseDownCompCoords = e.getPoint();
	}

	public void mouseDragged(MouseEvent e) {
	    Point currCoords = e.getLocationOnScreen();
	    frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
	}
    }

    public static class StyledButtonUI extends BasicButtonUI {

	@Override
	public void installUI(JComponent c) {
	    super.installUI(c);
	    AbstractButton button = (AbstractButton) c;
	    button.setOpaque(false);
	    button.setBorder(new EmptyBorder(5, 15, 5, 15));
	}

	@Override
	public void paint(Graphics g, JComponent c) {
	    AbstractButton b = (AbstractButton) c;
	    paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
	    super.paint(g, c);
	}

	private void paintBackground(Graphics g, JComponent c, int yOffset) {
	    Dimension size = c.getSize();
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g.setColor(c.getBackground().darker());
	    g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
	    g.setColor(c.getBackground());
	    g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
	}
    }

}
