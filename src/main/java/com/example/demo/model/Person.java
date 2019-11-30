package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Proxy(lazy = false)
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private boolean lincense;
	private String gender;
	private String phone1;
	private String phone2;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, boolean lincense, String gender, String phone1, String phone2) {
		super();
		this.name = name;
		this.age = age;
		this.lincense = lincense;
		this.gender = gender;
		this.phone1 = phone1;
		this.phone2 = phone2;
	}

}
