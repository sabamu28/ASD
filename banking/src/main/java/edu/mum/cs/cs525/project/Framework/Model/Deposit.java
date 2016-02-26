package edu.mum.cs.cs525.project.Framework.Model;

import java.util.Date;

public class Deposit extends Transaction {

	public Deposit(double amount, Date date) {
		super(amount, date);
	}

	public String getType() {
		return "D";
	}
}