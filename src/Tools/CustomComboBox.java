package Tools;

import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * A custom combo box with its own renderer and editor.
 * 
 * @author wwww.codejava.net
 *
 */
@SuppressWarnings({ "serial", "rawtypes", "unchecked" })
public class CustomComboBox extends JComboBox {
    private DefaultComboBoxModel model;

    public CustomComboBox(int w, int h) {
	model = new DefaultComboBoxModel();
	setPreferredSize(new Dimension(w, h));
	setModel(model);
	int iconsize = (int) (h * 0.8);
	setRenderer(new CustomItemRenderer(iconsize, iconsize));
	setEditor(new CustomItemEditor(iconsize, iconsize));
    }

    /**
     * Add an array items to this combo box. Each item is an array of two String
     * elements: - first element is country name. - second element is path of an
     * image file for country flag.
     * 
     * @param items
     */

    public void addItems(String[][] items) {
	for (String[] anItem : items) {
	    model.addElement(anItem);
	}
    }
}