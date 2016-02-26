package edu.mum.cs.cs525.project.Framework.Factory;

import java.time.LocalDate;
import java.util.Date;

import edu.mum.cs.cs525.project.Framework.Model.Company;
import edu.mum.cs.cs525.project.Framework.Model.IParty;

public class CompanyFactory implements IPartyFactory {

	private String name;
	private String email;
	private String city;
	private String zip;
	private String street;
	private int noOfEmployee;
	
	public CompanyFactory(String name, String email, String street, String city, String zip, int noOfEmployee) {
		
		this.name = name;
		this.email = email;
		this.city=city;
		this.zip=zip;
		this.street=street;
		this.noOfEmployee=noOfEmployee;
	}
	

	@Override
	public IParty createParty() {
		// TODO Auto-generated method stub
		return new Company(name,email,street,city,zip,noOfEmployee);
	}

	
}
