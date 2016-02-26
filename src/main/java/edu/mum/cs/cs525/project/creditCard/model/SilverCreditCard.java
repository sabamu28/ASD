package edu.mum.cs.cs525.project.creditCard.model;

public class SilverCreditCard extends CreditCardAccount{
	private double interestRate;
    private double minPayment;

    public double getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(double minPayment) {
        this.minPayment = minPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }



	public SilverCreditCard(String accountNumber, double balance, double inRate, double minPay) {
		super(accountNumber, balance);
		this .interestRate = inRate;
        this.minPayment=minPay;

	}

}
