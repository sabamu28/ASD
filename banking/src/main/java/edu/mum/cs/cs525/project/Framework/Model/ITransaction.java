package edu.mum.cs.cs525.project.Framework.Model;

import java.util.Date;

public interface ITransaction {
	public String getType();
	public double getAmount();
	public Date getDate();
}