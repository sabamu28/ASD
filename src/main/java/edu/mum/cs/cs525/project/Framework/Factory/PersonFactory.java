package edu.mum.cs.cs525.project.Framework.Factory;

import java.time.LocalDate;
import java.util.Date;

import edu.mum.cs.cs525.project.Framework.Model.IParty;
import edu.mum.cs.cs525.project.Framework.Model.Person;

public class PersonFactory implements IPartyFactory {
	
	
	private String name;
	private String email;
	private String birthdate;
	private String city;
	private String zip;
	private String street;
	
	public PersonFactory(String name, String email, String street, String city, String zip, String birthdate) {
		
		this.name = name;
		this.email = email;
		this.city=city;
		this.zip=zip;
		this.street=street;
		this.birthdate=birthdate;
	}
	

	@Override
	public IParty createParty() {
		// TODO Auto-generated method stub
		return new Person(name, email,street,city,zip, birthdate);
	}

}
