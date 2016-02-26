package edu.mum.cs.cs525.project.Framework.service;


import edu.mum.cs.cs525.project.Framework.Model.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccountService implements IAccountService {
	
	private String report;

	private List<IAccount> accountList;

	public List<IAccount> getAccountList() {
		return accountList;
	}

	private List<IRule> ruleList = new ArrayList<IRule>();

//	public IAccount createBankAccount(String accountNo, String type) {
//		IAccountFactory factory = null;
//		if (type.equalsIgnoreCase("Ch")) {
//			factory = BankAccountFactoryCreator.getInstance().createCheckingAccountFactory(accountNo + "", 0, .1);
//		} else {
//			factory = BankAccountFactoryCreator.getInstance().createSavingAccountFactory(accountNo + "", 0, .2);
//		}
//
//		return factory.createAccount();
//	}

	@Override
	public void addInterestForAllAccount() {
		if (accountList != null) {
			Iterator<IAccount> iterator = accountList.iterator();
			while (iterator.hasNext()) {
				IAccount currentAccount = iterator.next();
				currentAccount.addInterest();
			}
		}

	}

	@Override
	public void deposit(String accountNr, double amount) {

		IAccount currentAccount;
		if (accountList != null) {

			Iterator<IAccount> iterator = accountList.iterator();
			while (iterator.hasNext()) {
				currentAccount = iterator.next();
				if (currentAccount.getAccountNumber().equalsIgnoreCase(accountNr)) {
					currentAccount.deposit(amount);
				}
			}
		}

	}

	public List<IRule> getRules() {
		return ruleList;

	}

	public IAccount getCurrentAccount(String accountNr) {

		IAccount currentAccount;
		if (accountList != null) {

			Iterator<IAccount> iterator = accountList.iterator();
			
			while (iterator.hasNext()) {
				currentAccount = iterator.next();
				if (currentAccount.getAccountNumber().equalsIgnoreCase(accountNr)) {
					return currentAccount;
				}
			}
		}

		return null;
	}

	public void addCustomerAccount(IAccount account, IParty party) {

		account.addParties(party);
		party.addAccount(account);
		if (accountList == null) {
			accountList = new ArrayList<IAccount>();
		}
		accountList.add(account);

		System.out.println("New Account has been Saved in List");
	

	}

	public void withdraw(String accountNumber, double withdrawAmount) {
		IAccount currentAccount;
		if (accountList != null) {

			Iterator<IAccount> iterator = accountList.iterator();
			while (iterator.hasNext()) {
				currentAccount = iterator.next();
				if (currentAccount.getAccountNumber().equalsIgnoreCase(accountNumber)) {
					currentAccount.withdraw(withdrawAmount);
				}
			}
		}
	}

//	@Override
//	public IAccount createCreditCardAccount(String type, String expDate, String number) {
//		IAccountFactory factory = null;
//
//		if (type.equalsIgnoreCase("G")) {
//			factory = CreditCardAccountFactoryCreator.getInstance().createGoldCreditCardFactory(number, 0, expDate, 0);
//		} else if (type.equalsIgnoreCase("S")) {
//			factory = CreditCardAccountFactoryCreator.getInstance().createSilverCreditCardFactory(number, 0, expDate,
//					0);
//		} else {
//			factory = CreditCardAccountFactoryCreator.getInstance().createBronzeCreditCardFactory(number, 0, expDate,
//					0);
//		}
//		return factory.createAccount();
//	}

	@Override
	public List<ITransaction> getAllTransactions(String accnr) {
		IAccount currentAccount;
		if (accountList != null) {

			Iterator<IAccount> iterator = accountList.iterator();
			while (iterator.hasNext()) {
				currentAccount = iterator.next();
				if (currentAccount.getAccountNumber().equalsIgnoreCase(accnr)) {
					return currentAccount.getTransactionList();

				}
			}
		}
		return null;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	

	

}
