package edu.mum.cs.cs525.project.Framework.Commands;

import edu.mum.cs.cs525.project.Framework.service.AccountService;
import edu.mum.cs.cs525.project.Framework.service.IAccountService;

public class DepositCommand implements ICommand{

	private AccountService accountService;

	private String accountNumber;
	private double depositAmount;

	public DepositCommand(AccountService aService, String accountNr, double depositAmount) {

		this.accountService = aService;

		this.accountNumber = accountNr;
		this.depositAmount = depositAmount;
	}

	@Override
	public void execute() {
		accountService.deposit(accountNumber,depositAmount);
		
	}

}
