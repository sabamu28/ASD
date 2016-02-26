package edu.mum.cs.cs525.project.banking.factory;

import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.banking.model.SavingsAccount;

public class SavingAccountFactory extends AccountFactory{
	private String number; 
	private double balance;
	private double interestRate;
	
	public SavingAccountFactory(String number, double balance, double interestRate) {
		this.number = number;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public IAccount createAccount() {
            System.out.println("New Saving account created" + number+" "+balance+" "+ interestRate);
		return new SavingsAccount(number, balance, interestRate);
	}
}
