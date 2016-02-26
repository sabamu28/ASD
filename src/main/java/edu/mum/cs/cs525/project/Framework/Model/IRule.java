package edu.mum.cs.cs525.project.Framework.Model;



public interface IRule {
	public boolean checkAttribute(IAccount account);
	public void performAction(IParty party);
	public String getMsg();
}

