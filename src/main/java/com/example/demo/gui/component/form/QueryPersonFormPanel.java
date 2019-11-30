package com.example.demo.gui.component.form;

import javax.swing.JButton;

import com.example.demo.gui.eventlistener.QueryPersonSubmitListener;
import com.example.demo.gui.eventobject.QueryPersonEvent;
import com.example.demo.model.Person;

public class QueryPersonFormPanel extends AbstractTabPanel {
	private JButton btn;
	private JButton cancelBtn;
	private QueryPersonSubmitListener handler;

	public QueryPersonFormPanel(QueryPersonSubmitListener handler) {
		this.handler = handler;
		super.setBorder();
		super.initLayout();
		this.buildComponent();
		addEventCatcher();
	}

	@Override
	protected void buildComponent() {
		super.buildComponent();
		btn = new JButton("Oke");
		cancelBtn = new JButton("Cancel");
		addRow(btn, cancelBtn);
	}

	private void addEventCatcher() {
		btn.addActionListener(e -> {
			Person person = getFormInfo();
			QueryPersonEvent qe = new QueryPersonEvent(btn, person);
			handler.queryPersonOccur(qe);
		});

	}

	private Person getFormInfo() {
		String name = nameField.getText();
		int age = Integer.parseInt(ageField.getText());
		Person p = new Person(name, age);
		return p;
	}

}
