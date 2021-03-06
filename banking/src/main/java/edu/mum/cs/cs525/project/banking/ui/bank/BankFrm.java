package edu.mum.cs.cs525.project.banking.ui.bank;

import edu.mum.cs.cs525.project.Framework.Model.IAccount;
import edu.mum.cs.cs525.project.banking.controller.BankController;
import edu.mum.cs.cs525.project.banking.model.BankSystem;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * A basic JFC based application.
 */
public class BankFrm extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/****
	 * init variables in the object
	 ****/
	String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit, email, localDate,birthDate;

	int noEmployee;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	BankFrm myframe;
	private Object rowdata[];

	public BankFrm() {
		myframe = this;

		setTitle("Bank Application-Earth.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(675, 400);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		rowdata = new Object[8];
		newaccount = false;

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
		// rowdata = new Object[8];

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);

		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240, 20, 192, 33);

		JButton_Report.setText("Generate Report");
		JPanel1.add(JButton_Report);
		JButton_Report.setBounds(456, 20, 192, 33);

		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 90, 96, 33);

		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468, 140, 96, 33);
		
		JButton_Addinterest.setBounds(468, 190, 96, 33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);

		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 240, 96, 31);
		JButton_Exit.setBackground(Color.red);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		// $$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Report.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);

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
			(new BankFrm()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			// Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Report = new javax.swing.JButton();
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
			if (object == BankFrm.this)
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
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Report)
				JButton_Report_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	// When the Exit button is pressed this code gets executed
	// this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * JDialog_AddPAcc type object is for adding personal information
		 * construct a JDialog_AddPAcc type object set the boundaries and show
		 * it
		 */

		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount) {
			// add row to table

			BankController.getInstance().createAccount("person", accountnr, accountType,
					clientName, email, street, city, state, zip, localDate, noEmployee);

			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "P";
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}

	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount) {

			BankController.getInstance().createAccount("company", accountnr, accountType,
					clientName, email, street, city, state, zip, localDate, noEmployee);


			// add row to table
			rowdata[0] = accountnr;
			rowdata[1] = clientName;
			rowdata[2] = city;
			rowdata[3] = "C";
			rowdata[4] = accountType;
			rowdata[5] = "0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newaccount = false;
		}

	}
	void JButton_Report_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 * construct a JDialog_AddCompAcc type object set the boundaries and
		 * show it
		 */
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

		JDialog_Report pac = new JDialog_Report(myframe,accnr);
		pac.setBounds(450, 20, 300, 330);
		pac.show();
		}
		
		

	}

	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
			dep.setBounds(430, 15, 275, 180);
			dep.show();



			long deposit = Long.parseLong(amountDeposit);
			BankController.getInstance().deposite(accnr, deposit);
			double newAmount = BankController.getInstance().getUpdatedBalaced(accnr);
			model.setValueAt(String.valueOf(newAmount), selection, 5);
			// compute new amount

//			String samount = (String) model.getValueAt(selection, 5);
//			long currentamount = Long.parseLong(samount);
//			long newamount = currentamount + deposit;
//			model.setValueAt(String.valueOf(newamount), selection, 5);
		}

	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			// Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 275, 180);
			wd.show();

			   // compute new amount
            long withdraw = Long.parseLong(amountDeposit);
            BankController.getInstance().withdraw(accnr,withdraw);
            double newAmount = BankController.getInstance().getUpdatedBalaced(accnr);
			model.setValueAt(String.valueOf(newAmount), selection, 5);
            if (newAmount < 0) {
                JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + newAmount+ " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
		}

	}

	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts",
				"Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
		BankController.getInstance().addInterestForAllAccounts();
		List<IAccount> accounts=BankSystem.getInstance().getAccountList();
		if(accounts != null &&!accounts.isEmpty()) {
			int i = 0;
			for (IAccount account1 : accounts) {
				model.setValueAt(account1.getCurrentBalance(), i++, 5);
			}
		}

	}
}
