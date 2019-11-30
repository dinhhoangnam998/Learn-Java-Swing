package com.example.demo.gui.component.form;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FormPanel extends JPanel {

	private JTabbedPane tabbedPane;
	private AddPersonFormPanel addPersonFormPanel;
	private QueryFormPanel queryFormPanel;

	public FormPanel() {
		tabbedPane = new JTabbedPane();
		
		// instance 2 tab here;
		
		tabbedPane.add("Add Person", addPersonFormPanel);
		tabbedPane.add("Query Person", queryFormPanel);
		
		setLayout(new BorderLayout());
		add(tabbedPane, BorderLayout.CENTER);

	}
}
