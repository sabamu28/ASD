package edu.mum.cs.cs525.project.creditCard.ui.ccard;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.banking.controller.BankController;
import edu.mum.cs.cs525.project.banking.model.BankSystem;
import edu.mum.cs.cs525.project.banking.ui.bank.JDialog_Report;
import edu.mum.cs.cs525.project.creditCard.controller.CreditCardController;
import edu.mum.cs.cs525.project.creditCard.model.CreditCardSystem;

/**
 * A basic JFC based application.
 */
public class CardFrm extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	String customerType, clientName, street, city, zip, state, accountType, amountDeposit, expdate, ccnumber, email,
			localDate;
	int noEmployee;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	CardFrm thisframe;
	private Object rowdata[];
	

	public CardFrm() {
		thisframe = this;

		setTitle("Credit Card Application-Earth.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(675, 400);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 600, 380);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("Name");
		model.addColumn("CC number");
		model.addColumn("Exp date");
		model.addColumn("Type");
		model.addColumn("Balance");
		rowdata = new Object[7];
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		// rowdata = new Object[8];

		JButton_NewCCAccount.setText("Add Credit-card account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24, 20, 192, 33);
		
		JButton_GenBill.setText("Generate Report");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240, 20, 192, 33);
		
//		JButton_MonBill
		JButton_MonBill.setText("Generate Monthly Bill");
		JButton_MonBill.setActionCommand("jbutton");
		JPanel1.add(JButton_MonBill);
		JButton_MonBill.setBounds(460, 20, 192, 33);
		
		
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);

		JButton_Deposit.setBounds(468, 90, 96, 33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 140, 96, 33);
		
		JButton_Addinterest.setBounds(468, 190, 96, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 240, 96, 31);

		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_MonBill.addActionListener(lSymAction);

	}

	/*****************************************************
	 * The entry point for this application. Sets the Look and Feel to the
	 * System Look and Feel. Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			// Create a new instance of our application's frame, and make it
			// visible.
			(new CardFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_MonBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false); // hide the Frame
			this.dispose(); // free the system resources
			System.exit(0); // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == CardFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill)
				JButtonGenerateBill_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			else if (object == JButton_MonBill)
				JButtonGetMonthlyBill_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.show();

		if (newaccount) {

			// controller
			CreditCardController.getInstance().createCCardAccount(customerType, ccnumber, accountType, clientName,
					email, street, city, state, zip, localDate);

			// add row to table
			rowdata[0] = clientName;
			rowdata[1] = ccnumber;
			rowdata[2] = expdate;
			rowdata[3] = accountType;
			rowdata[4] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}

	}
///
//Monthly bill generating code
	
void JButtonGetMonthlyBill_actionPerformed(java.awt.event.ActionEvent event) {
		
		System.out.println("*******  Monthly Bill!  ****** \n");
		
		// generated report string
		
		System.out.println(
		"String generatedReport = " +

		"generatedReport += getLastBalance() + \n" +
		"generatedReport += getTotalMonthlyCharges() + \n" +
		"generatedReport += getTotalMonthlyCredits() + \n" +
		"generatedReport += getNewMonthlyBalance() + n" +
		"generatedReport += getMonthlyAmountDue() + \n" +

		"return generatedReport;");
		
		// selecting a row from the table
		
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			
			// get the account number from from the table selection
			String accountNumber = (String) model.getValueAt(selection, 1);
			
			//get and instance of the singleton method and call the method
			String reportString = CreditCardController.getInstance().generateMonthlyBillingReport(accountNumber);
			

			
			
			
			
			JOptionPane.showMessageDialog(JButton_MonBill,""+reportString, "Monthly Report of "+accountNumber ,
					 JOptionPane.OK_OPTION);
			}
//			}
		
		}
	
	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event) {
		
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 1);

			JDialogGenBill pac = new JDialogGenBill(thisframe,accnr);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
			}
		
		}
		
//		



	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {

			String accountNr = (String) model.getValueAt(selection, 1);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(thisframe, accountNr);
			dep.setBounds(430, 25, 275, 180);
			dep.show();
			// **************

			long deposit = Long.parseLong(amountDeposit);
			CreditCardController.getInstance().deposite(ccnumber, deposit);
			double newAmount = CreditCardController.getInstance().getUpdatedBalaced(ccnumber);
			model.setValueAt(String.valueOf(newAmount), selection, 4);

		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String name = (String) model.getValueAt(selection, 1);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(thisframe, name);
			wd.setBounds(430, 15, 275, 180);
			wd.show();

			long deposit = Long.parseLong(amountDeposit);
			CreditCardController.getInstance().withdraw(ccnumber, deposit);
			double newAmount = CreditCardController.getInstance().getUpdatedBalaced(ccnumber);
			model.setValueAt(String.valueOf(newAmount), selection, 4);
			if (newAmount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw,
						" " + name + " Your balance is negative: $" + String.valueOf(newAmount) + " !",
						"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
			}
		}

	}
	
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
		CreditCardController.getInstance().addInterestForAllAccounts();
		List<IAccount> accounts=CreditCardSystem.getInstance().getAccountList();
		if(accounts != null &&!accounts.isEmpty()) {
			int i = 0;
			for (IAccount account1 : accounts) {
				model.setValueAt(account1.getCurrentBalance(), i++, 4);
			}
		}

	}

}
