package edu.mum.cs.cs525.project.Framework.Model;

import java.util.Date;
public class Withdraw extends Transaction {

	public Withdraw(double amount, Date date) {
		super(amount, date);
	}

        @Override
	public String getType() {
		return "W";
	}
}