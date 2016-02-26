package edu.mum.cs.cs525.project.banking.ui.bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.mum.cs.cs525.project.Framework.Model.ITransaction;
import edu.mum.cs.cs525.project.Framework.Model.Transaction;
import edu.mum.cs.cs525.project.banking.controller.BankController;
import edu.mum.cs.cs525.project.banking.ui.bank.JDialog_Withdraw.SymAction;

public class JDialog_Report extends javax.swing.JDialog {
	private BankFrm parentframe;
	private String accnr;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane pane;
	private JPanel topPanel;
	private Object rowdata[];

	public JDialog_Report(BankFrm parentframe, String accnr) {
		super(parentframe);
		this.parentframe = parentframe;
		this.accnr = accnr;

		// Set the frame characteristics
		setTitle("Account No:"+accnr);
		setSize(300, 200);
		setBackground(Color.gray);

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		// Create columns names
		model = new DefaultTableModel();
		model.addColumn("Date");
		model.addColumn("Amount");
		model.addColumn("Type");
		rowdata = new Object[3];
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		List<ITransaction> transactions = BankController.getInstance().GetAllTransaction(accnr);
		if (transactions != null) {
			for (ITransaction trans : transactions) {
				Object[] o = new Object[5];
				rowdata[0] = formatter.format(trans.getDate());;
				rowdata[1] = trans.getAmount();
				rowdata[2] = trans.getType();
				// Create a new table instance
				model.addRow(rowdata);
			}
		}
		// table.getSelectionModel().setAnchorSelectionIndex(-1);
		table = new JTable(model);
		// Add the table to a scrolling pane
		pane = new JScrollPane(table);
		topPanel.add(pane, BorderLayout.CENTER);

		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		// getContentPane().add(JButton_Cancel);

		// JButton_Cancel.setBounds(156, 84, 84, 24);

		// JTextField_NAME.setText(accnr);

		SymAction lSymAction = new SymAction();
		JButton_Cancel.addActionListener(lSymAction);

	}

	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			JButton_Cancel_actionPerformed(event);
		}
	}

	void JButton_Cancel_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();

	}

}
