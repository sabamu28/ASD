package edu.mum.cs.cs525.project.creditCard.factories;


import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.creditCard.model.SilverCreditCard;

import java.util.Date;

public class SilverCreditCardFactory extends AccountFactory {

	private String number; 
	private double balance;
	private double interestRate;
	private String expirationDate;
	private double minPayment;
	
	public SilverCreditCardFactory(String number, double balance, String expirationDate, double minPayment) {
		this.number = number;
		this.balance = balance;
		this.interestRate = .08;
		this.expirationDate = expirationDate;
		this.minPayment = minPayment;
	}
	
	public IAccount createAccount() {
		return new SilverCreditCard(number, balance , interestRate, minPayment);
	}
}