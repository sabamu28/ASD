package edu.mum.cs.cs525.project.banking.factory;

import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.banking.model.CheckingAccount;

public class CheckingAccountFactory extends AccountFactory{
	private String number; 
	private double balance;
	private double interestRate;
	
	public CheckingAccountFactory(String number, double balance, double interestRate) {
		this.number = number;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public IAccount createAccount() {
            System.out.println("New Checking account created" + number+" "+balance+" "+ interestRate);
		return new CheckingAccount(number, balance, interestRate);
	}
}
