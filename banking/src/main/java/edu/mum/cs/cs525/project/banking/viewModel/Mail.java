package edu.mum.cs.cs525.project.banking.viewModel;

import java.util.ArrayList;

public class Mail {
	
	public String subject;
	public ArrayList<String> tos;
	public ArrayList<String> bccs;
	public String body;
	public Mail(String subject, ArrayList<String> tos, ArrayList<String> bccs, String body) {
		super();
		this.subject = subject;
		this.tos = tos;
		this.bccs = bccs;
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	public ArrayList<String> getTos(){
		return tos;
	}
	public void addTos(String email){
		tos.add(email);
	}
	public ArrayList<String> getBccss(){
		return tos;
	}
	public void addBccs(String email){
		bccs.add(email);
	}
	
}
