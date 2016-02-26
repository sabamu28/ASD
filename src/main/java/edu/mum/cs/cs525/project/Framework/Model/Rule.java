package edu.mum.cs.cs525.project.Framework.Model;


public abstract class Rule implements IRule {
	
//	private ICustomer customer;
	
	public Rule() {
		//this.customer = customer;
	}
	
	public abstract boolean checkAttribute(IAccount account);
	public abstract String getMsg();
	
	public void performAction(IParty party) {
		//party.sendEmail();
	}
}

