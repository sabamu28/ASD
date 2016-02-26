package edu.mum.cs.cs525.project.Framework.Factory;

import java.time.LocalDate;

public class PartyFactoryCreator {
	  private static PartyFactoryCreator instance = null;
	   private PartyFactoryCreator() {
	      // Exists only to defeat instantiation.
	   }
	   public static PartyFactoryCreator getInstance() {
	      if(instance == null) {
	         instance = new PartyFactoryCreator();
	      }
	      return instance;
	   }
	   public IPartyFactory CreatePersonFactory(String name, String email, String street, String city, String zip, String birthdate){
		   return new PersonFactory(name, email, street, city, zip, birthdate);
	   }
	   public IPartyFactory CreateCompanyFactory(String name, String email, String street, String city, String zip, int noOfEmployee){
		   return new CompanyFactory(name, email, street, city, zip, noOfEmployee);
	   }
	   
}
