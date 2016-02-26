package edu.mum.cs.cs525.project.Framework.service;

import edu.mum.cs.cs525.project.Framework.Model.IParty;

public interface IPartyService {
	IParty createParty(String type,String name, String email, String street, String city, String zip, String birthdate,int noOfEmployee);
}
