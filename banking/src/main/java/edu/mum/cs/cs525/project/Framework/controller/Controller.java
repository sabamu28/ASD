package edu.mum.cs.cs525.project.Framework.controller;

import edu.mum.cs.cs525.project.Framework.Commands.CommandManager;
import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.Model.IParty;
import edu.mum.cs.cs525.project.Framework.service.IAccountService;
import edu.mum.cs.cs525.project.Framework.service.IPartyService;

public abstract class Controller {
	 public CommandManager cmdManager;
	 public IParty party;
	 public IAccount account;

	public Controller( ) {
		cmdManager = CommandManager.getInstance();
	}

}
