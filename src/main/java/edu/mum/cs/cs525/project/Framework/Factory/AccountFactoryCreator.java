package edu.mum.cs.cs525.project.Framework.Factory;

public class AccountFactoryCreator {
	//private static AccountFactoryCreator instance = null;
	  /* private AccountFactoryCreator() {
	      // Exists only to defeat instantiation.
	   }
	   public static AccountFactoryCreator getInstance() {
	      if(instance == null) {
	         instance = new AccountFactoryCreator();
	      }
	      return instance;
	   }*/
	public  IAccountFactory createAccountFactory(String accountNo){
		return new DefaultAccountFactory(accountNo+ "", 0);
	}
}

