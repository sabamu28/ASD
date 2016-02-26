package edu.mum.cs.cs525.project.creditCard.model;


import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.Framework.service.AccountService;

/**
 * Created by Razib Mollick on 1/31/2016.
 */
public class CreditCardSystem extends AccountService {

    private static AccountService instance;
    public CreditCardSystem(){
        super();


    }

    public static AccountService getInstance(){
        if (instance == null)
            instance = new CreditCardSystem();

        return instance;

    }
    
//    String report;

	public String generateMonthlyBillingReport(IAccount account) {
		
		
		String report = ((CreditCardAccount) account).generateMonthlyBillingReport();
		super.setReport(report);
		return report;
		
	}
	
	
}
