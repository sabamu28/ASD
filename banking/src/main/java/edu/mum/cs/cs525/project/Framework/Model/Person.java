package edu.mum.cs.cs525.project.Framework.Model;

import java.time.LocalDate;

public class Person extends Party {
	public String birthDate;
	public Person(String name, String email, String street, String city, String zip, String birthDate) {
		super(name, email, street, city, zip);
		this.birthDate=birthDate;
	}

}
