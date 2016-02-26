package edu.mum.cs.cs525.project.Framework.service;

import edu.mum.cs.cs525.project.Framework.Factory.IPartyFactory;
import edu.mum.cs.cs525.project.Framework.Factory.PartyFactoryCreator;
import edu.mum.cs.cs525.project.Framework.Model.IParty;

public class PartyService implements IPartyService {

	@Override
	public IParty createParty(String type, String name, String email, String street, String city, String zip,
			String birthdate, int noOfEmployee) {
		IPartyFactory factory;
        if ("person".equalsIgnoreCase(type)) {
        	factory=PartyFactoryCreator.getInstance().CreatePersonFactory(name, email, street, city, zip, birthdate);
        } else {
        	factory=PartyFactoryCreator.getInstance().CreateCompanyFactory(name, email, street, city, zip, noOfEmployee);
        }
        return factory.createParty();

	}
};
