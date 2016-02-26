package edu.mum.cs.cs525.project.Framework.Model;

import java.util.ArrayList;
import java.util.List;


public interface IAccount {
	void addTransactions(ITransaction transaction);
	void withdraw(double amount);
	void deposit(double amount);
	void addInterest();List<ITransaction> getTransactionList();
	double getCurrentBalance();
	void addParties(IParty party);
	String getAccountNumber();
}
