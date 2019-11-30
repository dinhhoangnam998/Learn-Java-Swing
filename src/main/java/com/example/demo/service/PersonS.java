package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PersonR;

@Service
public class PersonS {

	@Autowired
	public PersonR personR;
}
