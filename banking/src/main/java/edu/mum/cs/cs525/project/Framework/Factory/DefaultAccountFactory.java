package edu.mum.cs.cs525.project.Framework.Factory;

import edu.mum.cs.cs525.project.Framework.Model.DefaultAccount;
import edu.mum.cs.cs525.project.Framework.Model.IAccount;

public class DefaultAccountFactory implements IAccountFactory {
	String number;
	double balance;
	public DefaultAccountFactory(String number, double balance){
		this.number=number;
		this.balance=balance;
	}
	@Override
	public IAccount createAccount() {
		return new DefaultAccount(number, balance);
	}


	
	
}