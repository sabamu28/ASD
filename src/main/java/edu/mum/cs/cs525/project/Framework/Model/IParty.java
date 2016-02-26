package edu.mum.cs.cs525.project.Framework.Model;

public interface IParty {
	// how about sending some transaction data in send email
	void addAccount(IAccount account);
	void removeAccount(IAccount accoutn);
}
