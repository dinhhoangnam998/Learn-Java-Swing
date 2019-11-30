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

import com.example.demo.gui.eventlistener.FormSubmitListener;
import com.example.demo.gui.eventobject.FormSubmitEvent;
import com.example.demo.model.Person;

public class AddPersonFormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel ageLabel;
	private JTextField nameField;
	private JTextField ageField;

	private JButton btn;
	private JButton cancelBtn;

	private FormSubmitListener formSubmitHandler;

	private JLabel lincenseLabel;
	private JCheckBox lincenseCheckBox;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup genderRadioGroup;
	private JLabel phoneListLable;
	private JList<String> jList;
	private JLabel phoneComboxBoxLable;
	private JComboBox<String> jComboBox;

	private GridBagConstraints gc;

	public AddPersonFormPanel(FormSubmitListener formSubmitHandler) {
		this.formSubmitHandler = formSubmitHandler;
		init();
		buildComponent();
		catchEvent();

	}

	private void init() {
		Dimension dim = getPreferredSize();
		dim.width = 400;
		setPreferredSize(dim);

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
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

	private void buildComponent() {
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

		lincenseLabel = new JLabel("Accept Lincense");
		lincenseCheckBox = new JCheckBox();
		lincenseCheckBox.setSelected(true);
		addRow(lincenseLabel, lincenseCheckBox);

		male = new JRadioButton("male");
		male.setActionCommand("Male");
		female = new JRadioButton("female");
		female.setActionCommand("Female");

		genderRadioGroup = new ButtonGroup();
		genderRadioGroup.add(male);
		genderRadioGroup.add(female);
		male.setSelected(true);
		addRow(male, female);

		String[] phones = { "Apple", "Samsung", "Xiaommi" };

		phoneListLable = new JLabel("JList");
		jList = new JList<String>(phones);
		jList.setSelectedIndex(1);
		addRow(phoneListLable, jList);

		phoneComboxBoxLable = new JLabel("JComboBox");
		jComboBox = new JComboBox<String>(phones);
		addRow(phoneComboxBoxLable, jComboBox);

		btn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		addRow(btn, cancelBtn);
	}

	private void addRow(JComponent c1, JComponent c2) {
		gc.gridy++;
		gc.gridx = 0;
		add(c1, gc);
		gc.gridx = 1;
		add(c2, gc);
	}

	private Person getFormInfo() {
		String name = nameField.getText();
		int age = Integer.parseInt(ageField.getText());
		boolean lincense = lincenseCheckBox.isSelected();
		String gender = genderRadioGroup.getSelection().getActionCommand();
		String phone1 = jList.getSelectedValue();
		String phone2 = (String) jComboBox.getSelectedItem();
		Person p = new Person(name, age, lincense, gender, phone1, phone2);
		return p;
	}

	private void catchEvent() {
		btn.addActionListener(e -> {
			Person p = getFormInfo();
			FormSubmitEvent fse = new FormSubmitEvent(btn, p);
			formSubmitHandler.formSubmitOccur(fse);
		});
	}
}
