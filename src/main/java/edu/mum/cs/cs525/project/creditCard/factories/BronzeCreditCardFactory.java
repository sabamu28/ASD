package edu.mum.cs.cs525.project.creditCard.factories;


import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.creditCard.model.BronzeCreditCard;

import java.util.Date;

public class BronzeCreditCardFactory extends AccountFactory {

	private String number; 
	private double balance;
	private double interestRate;
	private String expirationDate;
	private double minPayment;
	
	public BronzeCreditCardFactory(String number, double balance, String expirationDate, double minPayment) {
		this.number = number;
		this.balance = balance;
		this.interestRate = 0.1;
		this.expirationDate = expirationDate;
		this.minPayment = minPayment;
	}
	
	public IAccount createAccount() {
		return new BronzeCreditCard(number, balance, interestRate, minPayment);
	}
}