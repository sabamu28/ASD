package edu.mum.cs.cs525.project.creditCard.model;

import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.Model.Rule;

public class ChargeAmountRule extends Rule {

	
	public ChargeAmountRule() {

	}
	
	public boolean checkAttribute(IAccount account) {
		
		if (account.getTransactionList().get(account.getTransactionList().size() - 1).getAmount() > 500.0)
			return true;
		
		return false;
	}

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return " Transaction above $500";
	}
}