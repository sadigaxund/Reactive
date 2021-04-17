package Tools;

import java.awt.Component;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 * Editor for JComboBox
 * 
 * @author wwww.codejava.net
 *
 */
public class CustomItemEditor extends BasicComboBoxEditor {
    private JPanel panel = new JPanel();
    private JLabel labelItem = new JLabel();
    private String selectedValue;
    private int w, h;

    public CustomItemEditor(int w, int h) {
	this.w = w;
	this.h = h;
	panel.setLayout(new GridBagLayout());
	GridBagConstraints constraints = new GridBagConstraints();
	constraints.fill = GridBagConstraints.HORIZONTAL;
	constraints.weightx = 1.0;
	constraints.insets = new Insets(2, 5, 2, 2);

	labelItem.setOpaque(false);
	labelItem.setHorizontalAlignment(JLabel.LEFT);
	labelItem.setForeground(Color.WHITE);
	labelItem.setFont(new Font("HP Simplified Light", Font.BOLD, 15));
	labelItem.setHorizontalAlignment(SwingConstants.LEFT);
	labelItem.setSize(w, h);
	
	panel.add(labelItem, constraints);
	panel.setBackground(new Color(101, 53, 196));
    }

    public Component getEditorComponent() {
	return this.panel;
    }

    public Object getItem() {
	return this.selectedValue;
    }

    public void setItem(Object item) {
	if (item == null) {
	    return;
	}
	String[] countryItem = (String[]) item;
	selectedValue = countryItem[0];
	labelItem.setText(selectedValue);
	Tools.ComponentHelper.setLabelIcon(labelItem, countryItem[1], new Rectangle(w, h));
    }
}