package edu.mum.cs.cs525.project.Framework.Model;

public class Company extends Party {
	public int noOfEmployee;
	public Company(String name, String email, String street, String city, String zip, int noOfEmployee) {
		super(name, email, street, city, zip);
		this.noOfEmployee=noOfEmployee;
	}

}
