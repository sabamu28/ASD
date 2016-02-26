package edu.mum.cs.cs525.project.banking.model;

import java.util.ArrayList;

import edu.mum.cs.cs525.project.Framework.Model.Account;
import edu.mum.cs.cs525.project.Framework.Model.IParty;

public abstract class BankAccount extends Account {

	public BankAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}
	
	public void addInterest(){
		double newBalance=getBalance();
		newBalance+=(getBalance()*getInterestRate())/100;
		this.setBalance(newBalance);	
	}
	
	public abstract double getInterestRate();
	
}
