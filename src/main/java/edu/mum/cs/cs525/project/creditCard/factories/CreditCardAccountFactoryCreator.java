package edu.mum.cs.cs525.project.creditCard.factories;

import java.util.Date;

import edu.mum.cs.cs525.project.Framework.Factory.AccountFactoryCreator;
import edu.mum.cs.cs525.project.Framework.Factory.IAccountFactory;

public class CreditCardAccountFactoryCreator extends AccountFactoryCreator{
	private static CreditCardAccountFactoryCreator instance = null;

	private CreditCardAccountFactoryCreator() {

	}

	public static CreditCardAccountFactoryCreator getInstance() {
		if (instance == null) {
			instance = new CreditCardAccountFactoryCreator();
		}
		return instance;
	}
	
	public  IAccountFactory createBronzeCreditCardFactory(String number, double balance, String expirationDate, double minPayment){
		return new BronzeCreditCardFactory(number,balance,expirationDate,minPayment);
	}
	public  IAccountFactory createGoldCreditCardFactory(String number, double balance, String expirationDate, double minPayment){
		return new GoldCreditCardFactory(number,balance,expirationDate,minPayment);
	}
	public  IAccountFactory createSilverCreditCardFactory(String number, double balance, String expirationDate, double minPayment){
		return new SilverCreditCardFactory(number,balance,expirationDate,minPayment);
	}
}
