package edu.mum.cs.cs525.project.banking.model;

import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.Model.Rule;

/**
 * Created by Razib Mollick on 1/31/2016.
 */
public class TransactionAmountRule extends Rule {
    @Override
    public boolean checkAttribute(IAccount account) {
        return account.getTransactionList().get(account.getTransactionList().size() - 1).getAmount() > 500.0;
    }

    @Override
    public String getMsg() {
        return "Transaction above $500!!!";
    }
}
