package edu.mum.cs.cs525.project.creditCard.model;

public class BronzeCreditCard extends CreditCardAccount{
    private double interestRate;
    private double minPayment;

    public BronzeCreditCard(String accountNumber, double balance,  double inRate, double minPay) {

        super(accountNumber, balance);
        this.interestRate = inRate;
        this.minPayment = minPay;
    }

    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setMinPayment(double minPayment) {
        this.minPayment = minPayment;
    }

    public double getMinPayment() {
        return minPayment;
    }

    public double getMonthlyInterest() {
        return interestRate;
    }

}
