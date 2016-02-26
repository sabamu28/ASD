package edu.mum.cs.cs525.project.banking.model;

import java.util.ArrayList;

import edu.mum.cs.cs525.project.Framework.Model.ITransaction;

public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(String accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
		System.out.println("Currect Interest:" + interestRate);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
