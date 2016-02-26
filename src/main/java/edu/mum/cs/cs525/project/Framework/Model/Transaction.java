package edu.mum.cs.cs525.project.Framework.Model;

import java.util.Date;


public  abstract class Transaction implements ITransaction {
	
	private double amount;
	private Date date;
	
	public Transaction(double amount, Date date) {
		this.amount = amount;
		this.date = date;
	}

    @Override
	public abstract String getType();
    @Override
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
