package edu.mum.cs.cs525.project.Framework.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Party implements IParty {
	public String name;
	public String street;
	public String city;
	public String zip;
	public String email;

	private List<IAccount> accountList;

	public Party(String name, String email, String street, String city, String zip) {
		this.name = name;
		this.email = email;
		this.street = street;
		this.city = city;
		this.zip = zip;
		accountList = new ArrayList<IAccount>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = email;
	}

	@Override
	public void addAccount(IAccount account) {
		accountList.add(account);

	}

	@Override
	public void removeAccount(IAccount account) {
		accountList.remove(account);

	}

}
