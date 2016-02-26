package edu.mum.cs.cs525.project.Framework.Model;

import java.util.ArrayList;

import edu.mum.cs.cs525.project.Framework.Model.Account;
import edu.mum.cs.cs525.project.Framework.Model.ITransaction;

public class DefaultAccount extends Account {

	public DefaultAccount(String number, double balance) {
		super(number, balance);
	}

	public void addInterest() {
	}

	@Override
	public ArrayList<ITransaction> getTransactionList() {
		// TODO Auto-generated method stub
		return null;
	}

}
