package edu.mum.cs.cs525.project.creditCard.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.cs525.project.Framework.Model.Account;
import edu.mum.cs.cs525.project.Framework.Model.ITransaction;

public abstract class CreditCardAccount extends Account {

	public double lastBalance;
	public LocalDate expiredDate;

	public double getLastBalance() {
		return lastBalance;
	}

	public void setLastBalance(double lastBalance) {
		this.lastBalance = lastBalance;
	}

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}

	public CreditCardAccount(String accountNumber, double balance) {
		super(accountNumber, balance);
	}

	public double getTotalMonthlyCharges() {

		double totalMonthlyCharges = 0;

		List<ITransaction> transactionList = getTransactionList();

		for (int i = 0; i < transactionList.size(); i++) {
			if (transactionList.get(i).getType().equals("W"))
				totalMonthlyCharges += transactionList.get(i).getAmount();
		}

		return totalMonthlyCharges;
	}

	public double getTotalMonthlyCredits() {

		double totalMonthlyCredits = 0;

		List<ITransaction> transactionList = getTransactionList();

		for (int i = 0; i < transactionList.size(); i++) {
			if (transactionList.get(i).getType().equals("D"))
				totalMonthlyCredits += transactionList.get(i).getAmount();
		}

		return totalMonthlyCredits;
	}

	public double getNewMonthlyBalance() {

		double newMonthlyBalance = 0;
		newMonthlyBalance = getLastBalance() - getTotalMonthlyCredits() + getTotalMonthlyCharges()
				+ getInterestRate() * (getLastBalance() - getTotalMonthlyCredits());

		return newMonthlyBalance;
	}

	

	public double getMonthlyAmountDue() {

		double monthlyAmountDue = 0;
		monthlyAmountDue = getMinPayment() * getNewMonthlyBalance();

		return monthlyAmountDue;
	}

	private double getMinPayment() {
		return 0;
	}

	public String generateMonthlyBillingReport() {

		String generatedReport = "";

		generatedReport += getLastBalance() + "\n";
		generatedReport += getTotalMonthlyCharges() + "\n";
		generatedReport += getTotalMonthlyCredits() + "\n";
		generatedReport += getNewMonthlyBalance() + "\n";
		generatedReport += getMonthlyAmountDue() + "\n";

		return generatedReport;
	}

	public void addInterest() {

		double newBalance = 0;
		newBalance = getBalance() + ((getBalance() * getInterestRate()) / 100);

		setBalance(newBalance);
	}

	public abstract double getInterestRate();

}
