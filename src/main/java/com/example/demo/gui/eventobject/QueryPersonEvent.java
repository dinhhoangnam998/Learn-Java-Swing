package com.example.demo.gui.eventobject;

import java.util.EventObject;

import com.example.demo.model.Person;

public class QueryPersonEvent extends EventObject {
	private Person person;

	public QueryPersonEvent(Object source) {
		super(source);
	}

	public QueryPersonEvent(Object source, Person person) {
		super(source);
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
}
