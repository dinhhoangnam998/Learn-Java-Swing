package com.example.demo.gui.component.form;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public abstract class FormTabPanel extends JPanel {
	protected JLabel nameLabel;
	protected JLabel ageLabel;
	protected JTextField nameField;
	protected JTextField ageField;

	protected JButton btn;

	protected GridBagConstraints gc;
	
	protected void buildTemplate() {
		init();
		buildComponent();
	}

	protected void init() {
		Dimension dim = getPreferredSize();
		dim.width = 400;
		setPreferredSize(dim);

		Border innerBorder = BorderFactory.createTitledBorder("Query Person");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.NONE;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 20, 0, 0);
	}

	protected void buildComponent() {
		nameLabel = new JLabel("Name:");
		nameField = new JTextField("Hoang Nam", 10);
		nameLabel.setLabelFor(nameField);
		nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		addRow(nameLabel, nameField);

		ageLabel = new JLabel("Age:");
		ageField = new JTextField("21", 10);
		ageLabel.setLabelFor(ageField);
		ageLabel.setDisplayedMnemonic(KeyEvent.VK_A);
		addRow(ageLabel, ageField);

	}

	protected void addRow(JComponent c1, JComponent c2) {
		gc.gridy++;
		gc.gridx = 0;
		add(c1, gc);
		gc.gridx = 1;
		add(c2, gc);
	}

}
