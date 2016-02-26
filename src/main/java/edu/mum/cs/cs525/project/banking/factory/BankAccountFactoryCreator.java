package edu.mum.cs.cs525.project.banking.factory;

import edu.mum.cs.cs525.project.Framework.Factory.AccountFactoryCreator;
import edu.mum.cs.cs525.project.Framework.Factory.DefaultAccountFactory;
import edu.mum.cs.cs525.project.Framework.Factory.IAccountFactory;

public class BankAccountFactoryCreator extends AccountFactoryCreator{
	private static BankAccountFactoryCreator instance = null;

	private BankAccountFactoryCreator() {

	}

	public static BankAccountFactoryCreator getInstance() {
		if (instance == null) {
			instance = new BankAccountFactoryCreator();
		}
		return instance;
	}
	
	public  IAccountFactory createSavingAccountFactory(String accountNo,double balance, double interestRate){
		return new SavingAccountFactory(accountNo, balance,interestRate);
	}
	public  IAccountFactory createCheckingAccountFactory(String accountNo,double balance, double interestRate){
		return new CheckingAccountFactory(accountNo, balance,interestRate);
	}
}
