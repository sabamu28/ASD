package edu.mum.cs.cs525.project.creditCard.commands;

import edu.mum.cs.cs525.project.Framework.Commands.ICommand;
import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.creditCard.model.CreditCardSystem;

public class GenerateMonthlyBillingReportCommand implements ICommand {

	private CreditCardSystem creditCardSystem; 
	IAccount account;
	
	public GenerateMonthlyBillingReportCommand(CreditCardSystem creditCardSystemMain,IAccount account) {
		this.creditCardSystem = creditCardSystemMain;
		this.account = account;
	}
	
	@Override
	public void execute() {
		creditCardSystem.generateMonthlyBillingReport(account);
	}
}