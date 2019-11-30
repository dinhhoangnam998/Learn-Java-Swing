package com.example.demo.gui.component.form;

import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;

import com.example.demo.gui.eventlistener.AddPersonSubmitListener;
import com.example.demo.gui.eventobject.AddPersonEvent;
import com.example.demo.model.Person;

public class AddPersonFormPanel extends AbstractTabPanel {

	private AddPersonSubmitListener addPersonSubmitHandler;

	private JLabel lincenseLabel;
	private JCheckBox lincenseCheckBox;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup genderRadioGroup;
	private JLabel phoneListLable;
	private JList<String> jList;
	private JLabel phoneComboxBoxLable;
	private JComboBox<String> jComboBox;

	protected JButton btn;
	private JButton cancelBtn;

	private GridBagConstraints gc;

	public AddPersonFormPanel(AddPersonSubmitListener addPersonSubmitHandler) {
		this.addPersonSubmitHandler = addPersonSubmitHandler;
		super.setBorder();
		super.initLayout();
		this.buildComponent();
		addEventCatcher();
	}

	@Override
	protected void buildComponent() {

		super.buildComponent();

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

	private void addEventCatcher() {
		btn.addActionListener(e -> {
			Person p = getFormInfo();
			AddPersonEvent fse = new AddPersonEvent(btn, p);
			addPersonSubmitHandler.formSubmitOccur(fse);
		});
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

}
