package Views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComponentUI;

public class IconedButtonUI extends ButtonUI {

    // private static final ModifButtonUI buttonUI = new ModifButtonUI();

    private String iconPath;

    public IconedButtonUI(String iconPath) {
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