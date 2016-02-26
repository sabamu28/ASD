package edu.mum.cs.cs525.project.creditCard.controller;

import java.util.List;

import edu.mum.cs.cs525.project.Framework.Commands.AddInterestCommand;
import edu.mum.cs.cs525.project.Framework.Commands.CommandManager;
import edu.mum.cs.cs525.project.Framework.Commands.DepositCommand;
import edu.mum.cs.cs525.project.Framework.Commands.ICommand;
import edu.mum.cs.cs525.project.Framework.Commands.WithDrawCommand;
import edu.mum.cs.cs525.project.Framework.Factory.IAccountFactory;
import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.Model.ITransaction;
import edu.mum.cs.cs525.project.Framework.controller.Controller;
import edu.mum.cs.cs525.project.Framework.service.AccountService;
import edu.mum.cs.cs525.project.Framework.service.IAccountService;
import edu.mum.cs.cs525.project.Framework.service.IPartyService;
import edu.mum.cs.cs525.project.Framework.service.PartyService;
import edu.mum.cs.cs525.project.banking.model.BankSystem;
import edu.mum.cs.cs525.project.creditCard.commands.CreateAccountCommand;
import edu.mum.cs.cs525.project.creditCard.commands.GenerateMonthlyBillingReportCommand;
import edu.mum.cs.cs525.project.creditCard.factories.CreditCardAccountFactoryCreator;
import edu.mum.cs.cs525.project.creditCard.model.CreditCardAccount;
import edu.mum.cs.cs525.project.creditCard.model.CreditCardSystem;

public class CreditCardController extends Controller{

	private IAccountService accountService;
	private IPartyService partyService;

	private static CreditCardController CONTROLLER_INSTANCE;

	private CreditCardController() {
		super();
		accountService = new AccountService();
		partyService = new PartyService();
	}

	public static synchronized CreditCardController getInstance() {
		if (CONTROLLER_INSTANCE == null)
			CONTROLLER_INSTANCE = new CreditCardController();

		return CONTROLLER_INSTANCE;
	}

	public void createCCardAccount(String customerType, String accountNo, String accountType, 
			String name, String email,
			String street, String city, String state, String zip, String expDate) {
		party = partyService.createParty("Person", name, email, street, city, zip, "", 0);

		// Just for test
		account = createCreditCardAccount(accountType, expDate, accountNo);
		account.addParties(party);
		// start command
		ICommand createAccountCommand = new CreateAccountCommand(party, account);
		cmdManager.submit(createAccountCommand);

	}

	public IAccount createCreditCardAccount(String type, String expDate, String number) {
		IAccountFactory factory = null;

		if (type.equalsIgnoreCase("G")) {
			factory = CreditCardAccountFactoryCreator.getInstance().createGoldCreditCardFactory(number, 0, expDate, 0);
		} else if (type.equalsIgnoreCase("S")) {
			factory = CreditCardAccountFactoryCreator.getInstance().createSilverCreditCardFactory(number, 0, expDate,
					0);
		} else {
			factory = CreditCardAccountFactoryCreator.getInstance().createBronzeCreditCardFactory(number, 0, expDate,
					0);
		}
		return factory.createAccount();
	}
	 public void deposite(String AccountNumber, double amount){

	        //start command
	        ICommand depositeCommand = new DepositCommand(CreditCardSystem.getInstance(),AccountNumber, amount );
	        cmdManager.submit(depositeCommand);

	    }
	    
	    public void withdraw(String accountNumber, double amount ){
	    	 ICommand command = new WithDrawCommand(CreditCardSystem.getInstance(), accountNumber, amount);
	    	 CommandManager.getInstance().submit(command);
	    }
	    
	    public void addInterestForAllAccounts(){
	   	 ICommand command = new AddInterestCommand(CreditCardSystem.getInstance());
	   	cmdManager.submit(command);
	   }

	    public double getUpdatedBalaced(String accountNumber) {

	        account = CreditCardSystem.getInstance().getCurrentAccount(accountNumber);

	        if(account != null)
	            return account.getCurrentBalance();

	        return 0.0;
	    }
	    
	    public String generateMonthlyBillingReport(String accountNumber){
	    	
	      // here we are creating a single instance of the CreditCardSystem
	    	//using the singleton pattern
	      account = CreditCardSystem.getInstance().getCurrentAccount(accountNumber);
	      	//
	      
	      // here we are using the command patter 
	      // the controller being our client and the command manager as the Invoker
	      // both the Account service(credit card system) and the account as our receivers
	      // and generate monthly bill being the action
	      ICommand command = new GenerateMonthlyBillingReportCommand((CreditCardSystem) CreditCardSystem.getInstance(),account );
		  
	      
	      // get an instance of the command manger and invoke the submit method
	      cmdManager.submit(command);

	     return	CreditCardSystem.getInstance().getReport();

	    }

		public List<ITransaction> GetAllTransaction(String accnr) {
			return  CreditCardSystem.getInstance().getAllTransactions(accnr);
		}
	    
	    

}
