package edu.mum.cs.cs525.project.banking.controller;

import java.util.List;

import edu.mum.cs.cs525.project.Framework.Commands.AddInterestCommand;
import edu.mum.cs.cs525.project.Framework.Commands.CommandManager;
import edu.mum.cs.cs525.project.Framework.Commands.DepositCommand;
import edu.mum.cs.cs525.project.Framework.Commands.ICommand;
import edu.mum.cs.cs525.project.Framework.Commands.WithDrawCommand;
import edu.mum.cs.cs525.project.Framework.Factory.IAccountFactory;
import edu.mum.cs.cs525.project.Framework.Model.*;
import edu.mum.cs.cs525.project.Framework.controller.Controller;
import edu.mum.cs.cs525.project.Framework.service.AccountService;
import edu.mum.cs.cs525.project.Framework.service.IAccountService;
import edu.mum.cs.cs525.project.Framework.service.IPartyService;
import edu.mum.cs.cs525.project.Framework.service.PartyService;
import edu.mum.cs.cs525.project.Framework.util.EmailService;
import edu.mum.cs.cs525.project.banking.commands.CreateAccountCommand;
import edu.mum.cs.cs525.project.banking.factory.BankAccountFactoryCreator;
import edu.mum.cs.cs525.project.banking.model.BankSystem;

public class BankController extends Controller {

	private IAccountService accountService;
	private IPartyService partyService;

	private static BankController CONTROLLER_INSTANCE;

	private BankController() {
		super();
		accountService = new AccountService();
		partyService = new PartyService();
	}

	public static synchronized BankController getInstance() {
		if (CONTROLLER_INSTANCE == null)
			CONTROLLER_INSTANCE = new BankController();

		return CONTROLLER_INSTANCE;
	}

	public void createAccount(String customerType, String accountNo, String accountType, String name, String email,
			String street, String city, String state, String zip, String birthDate, int noEmployee) {
		party = partyService.createParty(customerType, name, email, street, city, zip, birthDate, noEmployee);
		account = createBankAccount(accountNo, accountType);
		
		// start command
		ICommand createAccountCommand = new CreateAccountCommand(party, account);
		cmdManager.submit(createAccountCommand);
		
		//
		//account.addParties(party);
		Account thisAccount=(Account)account;
		EmailService service=new EmailService(thisAccount);
		thisAccount.addObserver(service);
	}

	public IAccount createBankAccount(String accountNo, String type) {
		IAccountFactory factory = null;
		if (type.equalsIgnoreCase("Ch")) {
			factory = BankAccountFactoryCreator.getInstance().createCheckingAccountFactory(accountNo + "", 0, .1);
		} else {
			factory = BankAccountFactoryCreator.getInstance().createSavingAccountFactory(accountNo + "", 0, .2);
		}

		return factory.createAccount();
	}

	public void deposite(String AccountNumber, double amount) {

		// start command
		ICommand depositeCommand = new DepositCommand(BankSystem.getInstance(), AccountNumber, amount);
		cmdManager.submit(depositeCommand);

	}

	public void withdraw(String accountNumber, double amount) {
		ICommand command = new WithDrawCommand(BankSystem.getInstance(), accountNumber, amount);
		cmdManager.submit(command);
	}

	public void addInterestForAllAccounts() {
		ICommand command = new AddInterestCommand(BankSystem.getInstance());
		cmdManager.submit(command);
	}

	public double getUpdatedBalaced(String AccountNumber) {
		account = BankSystem.getInstance().getCurrentAccount(AccountNumber);

		if (account != null)
			return account.getCurrentBalance();

		return 0.0;
	}

	public List<ITransaction> GetAllTransaction(String accontNo) {
		return BankSystem.getInstance().getAllTransactions(accontNo);
	}

}
