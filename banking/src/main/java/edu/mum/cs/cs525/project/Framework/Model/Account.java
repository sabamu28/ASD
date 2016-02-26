package edu.mum.cs.cs525.project.Framework.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public abstract class Account extends Observable implements IAccount {

	public String accountNumber;
	public double balance;
	public ArrayList<IParty> parties;
	public ArrayList<ITransaction> transactions;

	public Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.parties = new ArrayList<IParty>();
		this.transactions = new ArrayList<ITransaction>();
		System.out.println("New account created :" + accountNumber + " balance:" + balance);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<IParty> getParties() {
		return parties;
	}

	@Override
	public void addParties(IParty party) {
		parties.add(party);
	}

	public ArrayList<ITransaction> getTransactions() {
		return transactions;
	}

	@Override
	public void addTransactions(ITransaction transaction) {
		transactions.add(transaction);
	}

	@Override
	public void deposit(double amount) {
		ITransaction depositTransaction = new Deposit(amount, new Date());
		addTransactions(depositTransaction);
		balance += amount;
		sendNotification(depositTransaction);

	}

	@Override
	public void withdraw(double amount) {
		ITransaction withdrawTransaction = new Withdraw(amount, new Date());
		addTransactions(withdrawTransaction);
		balance -= amount;
		sendNotification(withdrawTransaction);
	}

	@Override
	public abstract void addInterest(); // using template method
	// @Override
	// public void notifyObserver(); // using template method

	@Override
	public double getCurrentBalance() {
		return getBalance();
	}

	@Override
	public List<ITransaction> getTransactionList() {
		return transactions;
	}

	public void sendNotification(ITransaction trans) {
		IParty party = getParties().get(0);
		if (party instanceof Person) {
			if (trans.getAmount() >= 500) {
				setChanged();
				notifyObservers(trans);
			}
		} else {
			setChanged();
			notifyObservers(trans);
		}
	}

}
