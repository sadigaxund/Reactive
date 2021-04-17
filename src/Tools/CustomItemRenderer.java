package Tools;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Customer renderer for JComboBox
 * 
 * @author www.codejava.net
 *
 */
public class CustomItemRenderer extends JPanel implements ListCellRenderer {
    private JLabel labelItem = new JLabel();

    private int w, h;

    public CustomItemRenderer(int w, int h) {
	setLayout(new GridBagLayout());
	this.w = w;
	this.h = h;
	GridBagConstraints constraints = new GridBagConstraints();
	constraints.fill = GridBagConstraints.HORIZONTAL;
	constraints.weightx = 1.0;
	constraints.insets = new Insets(2, 2, 2, 2);

	labelItem.setOpaque(true);
	labelItem.setHorizontalAlignment(JLabel.LEFT);

	add(labelItem, constraints);
	setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
	    boolean cellHasFocus) {
	String[] countryItem = (String[]) value;

	// set country name
	labelItem.setText(countryItem[0]);

	// set country flag
	Tools.ComponentHelper.setLabelIcon(labelItem, countryItem[1], new Rectangle(w, h));

	if (isSelected) {
	    labelItem.setBackground(new Color(101, 53, 196));
	    labelItem.setForeground(Color.YELLOW);
	    labelItem.setFont(new Font("HP Simplified", Font.BOLD, 19));
	    labelItem.setHorizontalAlignment(SwingConstants.LEFT);
	} else {
	    labelItem.setBackground(new Color(159, 125, 227));
	    labelItem.setForeground(Color.WHITE);
	    labelItem.setFont(new Font("HP Simplified", Font.PLAIN, 15));
	    labelItem.setHorizontalAlignment(SwingConstants.LEFT);
	}

	return this;
    }

}