package com.example.demo.gui.component.form;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.example.demo.gui.eventlistener.AddPersonSubmitListener;
import com.example.demo.gui.eventlistener.QueryPersonSubmitListener;

public class TabbedPanel extends JPanel {

	private JTabbedPane tabbedPane;
	private AddPersonFormPanel addPersonFormPanel;
	private QueryPersonFormPanel queryPersonFormPanel;

	public TabbedPanel(AddPersonSubmitListener addPersonSubmitHandler,
			QueryPersonSubmitListener queryPersonSubmitHandler) {

		tabbedPane = new JTabbedPane();
		addPersonFormPanel = new AddPersonFormPanel(addPersonSubmitHandler);
		tabbedPane.add("Add Person", addPersonFormPanel);

		queryPersonFormPanel = new QueryPersonFormPanel(queryPersonSubmitHandler);
		tabbedPane.add("Query Person", queryPersonFormPanel);

		setLayout(new BorderLayout());
		add(tabbedPane, BorderLayout.CENTER);

	}
}
