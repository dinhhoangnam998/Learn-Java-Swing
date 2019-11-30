package com.example.demo.gui.eventobject;

import java.util.EventObject;

import com.example.demo.model.Person;

public class AddPersonEvent extends EventObject {

	private Person person;

	public AddPersonEvent(Object source) {
		super(source);
	}

	public AddPersonEvent(Object source, Person person) {
		super(source);
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

}
