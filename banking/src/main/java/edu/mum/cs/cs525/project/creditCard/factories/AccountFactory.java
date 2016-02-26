package edu.mum.cs.cs525.project.creditCard.factories;


import edu.mum.cs.cs525.project.Framework.Factory.IAccountFactory;
import edu.mum.cs.cs525.project.Framework.Model.IAccount;

public abstract class AccountFactory implements IAccountFactory {
	public abstract IAccount createAccount();
}