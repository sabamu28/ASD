package edu.mum.cs.cs525.project.Framework.Commands;

import edu.mum.cs.cs525.project.Framework.service.AccountService;

public class AddInterestCommand implements ICommand{


		private AccountService accountService;
		
		public AddInterestCommand(AccountService accountService) {
			this.accountService = accountService;
		}
		@Override
		public void execute() {
			accountService.addInterestForAllAccount();
		}
		
}
