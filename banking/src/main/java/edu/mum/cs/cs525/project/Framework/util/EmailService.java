package edu.mum.cs.cs525.project.Framework.util;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import edu.mum.cs.cs525.project.Framework.Model.Account;
import edu.mum.cs.cs525.project.Framework.Model.IParty;
import edu.mum.cs.cs525.project.Framework.Model.Party;
import edu.mum.cs.cs525.project.Framework.Model.Transaction;
import edu.mum.cs.cs525.project.banking.viewModel.Mail;

public class EmailService implements Observer {

	private Account account = null;

	public EmailService(Account account) {
		this.account = account;
	}

	public void sendEmail(Transaction tr) throws AddressException, MessagingException {
		String subject = null;
		String body = null;
		ArrayList<String> tos = new ArrayList<String>();
		if (account.getParties() != null) {
			for (IParty party : account.getParties()) {
				tos.add(((Party) party).getEmail());
				if ("W".equalsIgnoreCase(tr.getType())) {
					subject = "Money is withdrawn";
					body = "Hello Mr. " + ((Party) party).getName()+" , $"+tr.getAmount()+" has been withdrawn. Now your balance is "+account.getBalance();
				} else if ("D".equalsIgnoreCase(tr.getType())) {
					subject = "Money is deposited";
					body = "Hello Mr. " + ((Party) party).getName()+" , $"+tr.getAmount()+" has been deposited. Now your balance is "+account.getBalance();
				} else {
					subject = "Balance is changed";
					body = "Hello Mr. " + ((Party) party).getName()+" , $"+tr.getAmount()+" has been changed. Now your balance is "+account.getBalance();
				}
			}

		}

		Mail mail = new Mail(subject, tos, null, body);

		System.out.println("This email is sent to");
		System.out.println(subject);
		System.out.println(body);
		System.out.println("Sending.....");
		Mailer.generateAndSendEmail(mail);

	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("observer is called");
		if (o== account) {
			Transaction tr = (Transaction) arg;
			System.out.println("send email");
			try {
				sendEmail(tr);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
