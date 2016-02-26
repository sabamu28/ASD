package edu.mum.cs.cs525.project.banking.commands;


import edu.mum.cs.cs525.project.Framework.Commands.ICommand;
import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.Model.IParty;
import edu.mum.cs.cs525.project.Framework.service.AccountService;
import edu.mum.cs.cs525.project.banking.model.BankSystem;

public class CreateAccountCommand implements ICommand {

	private AccountService acountService;
	private IParty party;
	private IAccount account;

	
	public CreateAccountCommand(IParty party, IAccount account) {

	    this.party = party;
        this.account = account;
        this.acountService = BankSystem.getInstance();
	}

	@Override
	public void execute() {
        acountService.addCustomerAccount(account, party);
	}
}