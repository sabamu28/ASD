package edu.mum.cs.cs525.project.creditCard.viewModel;

public class CreditCardMonthlyReport {
	public double previousBalance;
	public double totalCharges;
	public double totalCredits;
	public double newBalance;
	public double totalDue;
	public double getPreviousBalance() {
		return previousBalance;
	}
	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}
	public double getTotalCharges() {
		return totalCharges;
	}
	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}
	public double getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(double totalCredits) {
		this.totalCredits = totalCredits;
	}
	public double getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
	public double getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(double totalDue) {
		this.totalDue = totalDue;
	}
	
}
