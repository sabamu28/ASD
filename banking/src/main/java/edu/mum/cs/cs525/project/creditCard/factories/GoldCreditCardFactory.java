package edu.mum.cs.cs525.project.creditCard.factories;


import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.creditCard.model.GoldCreditCard;

import java.util.Date;

public class GoldCreditCardFactory extends AccountFactory {

	private String number; 
	private double balance;
	private double interestRate;
	private String expirationDate;
	private double minPayment;
	
	public GoldCreditCardFactory(String number, double balance, String expirationDate,  double minPayment) {
		this.number = number;
		this.balance = balance;
		this.interestRate = .06;
		this.expirationDate = expirationDate;
		this.minPayment = minPayment;
	}
	
	public IAccount createAccount() {
		return new GoldCreditCard(number, balance, interestRate, minPayment);
	}
}