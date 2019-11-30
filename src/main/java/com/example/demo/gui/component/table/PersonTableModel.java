package com.example.demo.gui.component.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.example.demo.model.Person;
import com.example.demo.util.PersonUtils;

public class PersonTableModel extends AbstractTableModel {
	private List<Person> people = new ArrayList<Person>();
	private String[] columns = PersonUtils.getFieldNames();

	public PersonTableModel() {
		super();
	}

	public PersonTableModel(List<Person> people) {
		super();
		this.people = people;
	}

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return people.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person p = people.get(rowIndex);
		return PersonUtils.getFieldValue(p, columnIndex);
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

}
