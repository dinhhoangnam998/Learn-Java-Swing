package com.example.demo.model;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;
	private int age;
	private boolean lincense;
	private String gender;
	private String phone1;
	private String phone2;

	public Person() {
		super();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isLincense() {
		return lincense;
	}

	public void setLincense(boolean lincense) {
		this.lincense = lincense;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", lincense=" + lincense + ", gender=" + gender + ", phone1="
				+ phone1 + ", phone2=" + phone2 + "]";
	}

}
