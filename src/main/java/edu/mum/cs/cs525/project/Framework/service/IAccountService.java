package edu.mum.cs.cs525.project.Framework.service;

import java.util.Date;
import java.util.List;

import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.Model.ITransaction;

public interface IAccountService {
//	IAccount createBankAccount(String accountNo,  String type);
//	IAccount createCreditCardAccount(String type, String expDate, String number );
	void addInterestForAllAccount();
	void withdraw(String aountNr,double amount);
	void deposit(String accountNr, double amount);
	List<ITransaction> getAllTransactions(String accnr);
//	String generateMonthlyBillingReport(String accountNumber);
}
