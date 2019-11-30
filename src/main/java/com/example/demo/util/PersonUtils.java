package com.example.demo.util;

import java.lang.reflect.Field;

import com.example.demo.model.Person;

public class PersonUtils {
	private static final Field[] fields = Person.class.getDeclaredFields();

	public static String[] getFieldNames() {
		Field[] fields = Person.class.getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i <= fields.length - 1; i++) {
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	public static String getFieldValue(Person p, int index) {
		String ret = "error";
		Field f = fields[index];
		f.setAccessible(true);
		try {
			ret = f.get(p).toString();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
