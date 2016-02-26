package edu.mum.cs.cs525.project.banking.model;

import edu.mum.cs.cs525.project.Framework.Factory.IAccountFactory;
import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.service.AccountService;
import edu.mum.cs.cs525.project.banking.factory.BankAccountFactoryCreator;
import edu.mum.cs.cs525.project.banking.factory.BankRuleFactory;

/**
 * Created by Razib Mollick on 1/31/2016.
 */
public class BankSystem extends AccountService{

    private static AccountService instance;
    public BankSystem(){
        super();
        this.addRules();

    }

    public static AccountService getInstance(){
        if (instance == null)
            instance = new BankSystem();

        return instance;

    }



    public void addRules() {
        getRules().add(BankRuleFactory.createNegativeRule());
        getRules().add(BankRuleFactory.createTransactionRule());
        //super.setRules(rules);
        //super.addRules();
    }
}
