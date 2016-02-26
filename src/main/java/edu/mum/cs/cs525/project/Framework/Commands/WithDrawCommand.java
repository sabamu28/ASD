package edu.mum.cs.cs525.project.Framework.Commands;

import edu.mum.cs.cs525.project.Framework.service.AccountService;

public class WithDrawCommand implements ICommand{

	private AccountService accountService;

	private String accountNumber;
	private double withdrawAmount;

	public WithDrawCommand(AccountService aService, String accountNr, double withdrawAmount) {

		this.accountService = aService;

		this.accountNumber = accountNr;
		this.withdrawAmount = withdrawAmount;
	}

	@Override
	public void execute() {
		accountService.withdraw(accountNumber,withdrawAmount);
		
	}

}
