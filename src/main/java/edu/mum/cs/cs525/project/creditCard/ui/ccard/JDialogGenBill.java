package edu.mum.cs.cs525.project.creditCard.ui.ccard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;

import edu.mum.cs.cs525.project.Framework.Model.ITransaction;
import edu.mum.cs.cs525.project.creditCard.controller.CreditCardController;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class JDialogGenBill extends javax.swing.JDialog {
	private CardFrm parentframe;
	private String accnr;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane pane;
	private JPanel topPanel;
	private Object rowdata[];
	String billstring;

	public JDialogGenBill(CardFrm parentframe, String accnr) {
		super(parentframe);
		this.parentframe = parentframe;
		this.accnr = accnr;

		// Set the frame characteristics
		setTitle("Report");
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
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
	        
		List<ITransaction> transactions = CreditCardController.getInstance().GetAllTransaction(accnr);
		if (transactions != null) {
			for (ITransaction trans : transactions) {
				Object[] o = new Object[5];
				rowdata[0] = DATE_FORMAT.format(trans.getDate());
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