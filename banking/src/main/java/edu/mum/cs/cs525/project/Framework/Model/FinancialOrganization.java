package edu.mum.cs.cs525.project.Framework.Model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import edu.mum.cs.cs525.project.Framework.Factory.AccountFactoryCreator;
import edu.mum.cs.cs525.project.Framework.Factory.CompanyFactory;
import edu.mum.cs.cs525.project.Framework.Factory.IAccountFactory;
import edu.mum.cs.cs525.project.Framework.Factory.IPartyFactory;
import edu.mum.cs.cs525.project.Framework.Factory.PartyFactoryCreator;

public class FinancialOrganization {

	private List<IAccount> accountList;
    // private List<IRule> ruleList=new  ArrayList<IRule>();
	private String name;
	private String email;	
	private String street;
	private String zip;
	private String city;
	//private Address address;	
	private String birthdate;
	private int employeesNo;
    //private IAccount account;
	
	public FinancialOrganization() {
		accountList = new ArrayList<IAccount>();
		//this.addRules();
	}

	public IParty createPerson(String s) {
		IPartyFactory factory=null;
		if(s.equalsIgnoreCase("P")){
			factory = PartyFactoryCreator.getInstance().CreateCompanyFactory(name, email, street, city, zip, employeesNo);
		}
		else {
			factory= PartyFactoryCreator.getInstance().CreatePersonFactory(name, email, street, city, zip, birthdate);
		}
		return factory.createParty();
	}

	/*public IAccount createAccount(String type,String accountNo) {
            
                 IAccountFactory factory = AccountFactoryCreator.getInstance().createAccountFactory(accountNo);
                return  factory.createAccount();
	}*/
	/*public  void addRules() {
		this.ruleList.add(DefaultRuleFactory.createRule());
		
	}
	public List<IRule> getRules() {
		return ruleList;
		
	}*/

	public void addCustomerAccount(IAccount account, IParty party) {
			
		account.addParties(party);
		//customer.addAccount(account);
		if(accountList==null){
			accountList=new ArrayList<IAccount>();
		}
		accountList.add(account);
		
	}
	
	public void addInterestForAllAccounts() {
		
		if (accountList != null) {
			
			Iterator<IAccount> iterator = accountList.iterator();
			while (iterator.hasNext()) {
				IAccount currentAccount = iterator.next();
				currentAccount.addInterest();
			}
		}
	}
	
	public void deposit(IAccount account, double amount) {
		account.deposit(amount);
	}
	
	public void withdraw(IAccount account, double amount) {
		account.withdraw(amount);
	}
	
	public void generateAccountsReport() {
		// TODO
	}
	
	public List<IAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<IAccount> accountList) {
		this.accountList = accountList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public int getEmployeesNo() {
		return employeesNo;
	}

	public void setEmployeesNo(int employeesNo) {
		this.employeesNo = employeesNo;
	}
        
//        public IAccount getAccount(){
//            return account;
//        }
	
}
