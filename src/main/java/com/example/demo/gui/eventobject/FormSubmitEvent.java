package com.example.demo.gui.eventobject;

import java.util.EventObject;

import com.example.demo.model.Person;

public class FormSubmitEvent extends EventObject {

	private Person person;

	public FormSubmitEvent(Object source) {
		super(source);
	}

	public FormSubmitEvent(Object source, Person person) {
		super(source);
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

}
