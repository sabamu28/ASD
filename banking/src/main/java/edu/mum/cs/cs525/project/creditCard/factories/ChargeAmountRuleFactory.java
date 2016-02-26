package edu.mum.cs.cs525.project.creditCard.factories;


import edu.mum.cs.cs525.project.Framework.Model.IRule;
import edu.mum.cs.cs525.project.creditCard.model.ChargeAmountRule;

public class ChargeAmountRuleFactory {

	public static IRule createRule() {
		return new ChargeAmountRule();
	}
}