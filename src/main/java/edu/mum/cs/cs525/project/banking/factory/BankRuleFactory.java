package edu.mum.cs.cs525.project.banking.factory;

import edu.mum.cs.cs525.project.Framework.Model.IRule;
import edu.mum.cs.cs525.project.banking.model.NegativeAccountRule;
import edu.mum.cs.cs525.project.banking.model.TransactionAmountRule;

/**
 * Created by Razib Mollick on 1/31/2016.
 */
public class BankRuleFactory {
    public static IRule createNegativeRule() {
        return new NegativeAccountRule();
    }
    public static IRule createTransactionRule() {
        return new TransactionAmountRule();
    }
}
