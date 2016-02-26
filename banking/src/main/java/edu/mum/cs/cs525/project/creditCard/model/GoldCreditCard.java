package edu.mum.cs.cs525.project.creditCard.model;

public class GoldCreditCard extends CreditCardAccount{
	double monthlyInterest;
	double minimumPayment;
	
	public double getMonthlyInterest() {
		return monthlyInterest;
	}

	public void setMonthlyInterest(double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}

	public double getMinimumPayment() {
		return minimumPayment;
	}

	public void setMinimumPayment(double minimumPayment) {
		this.minimumPayment = minimumPayment;
	}

	public GoldCreditCard(String accountNumber, double balance,  double inRate, double minPay) {
		super(accountNumber, balance);
		this .monthlyInterest = inRate;
		this.minimumPayment = minPay;
	}

	@Override
	public double getInterestRate() {
		// TODO Auto-generated method stub
		return monthlyInterest;
	}

}
