package com.example.demo.gui.component.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.example.demo.model.Person;

public class TablePanel extends JPanel {
	private JTable table;
	private PersonTableModel tableModel;

	public TablePanel() {
		tableModel = new PersonTableModel();
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void displayData(List<Person> people) {
		tableModel.setPeople(people);
		tableModel.fireTableDataChanged();
	}
}
