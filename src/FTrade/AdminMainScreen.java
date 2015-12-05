package FTrade;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.opencsv.CSVReader;
import javax.swing.ListSelectionModel;


public class AdminMainScreen {

	private JFrame frame;
	private JTable accountTable;
	private JTable ticketTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainScreen window = new AdminMainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminMainScreen() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 25);
		frame.getContentPane().add(tabbedPane);
		
		JPanel TicketPanel = new JPanel();
		tabbedPane.addTab("Tickets", null, TicketPanel, null);
		TicketPanel.setLayout(null);
		
		//row column
		final Object[][] rowTickets = {};
		final Object[] columnTickets = {"UserName","Password", "E-mail"};
	    DefaultTableModel model;
	    model = new DefaultTableModel(rowTickets, columnTickets){
	    	   public boolean isCellEditable(int rowTickets, int columnTickets){
	    	        return false;
	    	   }
	    	};
	    CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("tickets/tickets.csv"), ',' , '"');
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	       
	      //Read CSV line by line and use the string array as you want
	      String[] nextLine;
	      try {
			while ((nextLine = reader.readNext()) != null) {
			     if (nextLine != null) {
			    	 String temp =  Arrays.toString(nextLine);
				        String[] tokens = temp.split(",");
						StringBuilder sb = new StringBuilder();
						for(int i =0; i <tokens.length;i++)//checks for comma 
						{
							
							if(i == tokens.length -1)
							{
								model.addRow(new Object[]{tokens[0], tokens[1],tokens[2]});
							}
						}
						
			     }
			   }
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	      
	      JScrollPane scrollPane_1 = new JScrollPane();
	      scrollPane_1.setBounds(0, 0, 255, 233);
	      TicketPanel.add(scrollPane_1);
	      
	      ticketTable = new JTable();
	      scrollPane_1.setViewportView(ticketTable);
	      ticketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   
	      ticketTable.setModel(model);
		
		//Account Tab
		JPanel AccountFrame = new JPanel();
		tabbedPane.addTab("Accounts", null, AccountFrame, null);
		AccountFrame.setLayout(null);
		
		final Object[][] rowData = {};
		final Object[] columnNames = {"UserName","Password", "E-mail"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 284, 233);
		AccountFrame.add(scrollPane);
		
		accountTable = new JTable();
		accountTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(accountTable);
	    DefaultTableModel model1;
	    model1 = new DefaultTableModel(rowData, columnNames){
	    	   public boolean isCellEditable(int rowData, int columnNames){
	    	        return false;
	    	   }
	    	};
	    CSVReader reader1 = null;
		try {
			reader1 = new CSVReader(new FileReader("accounts/accounts.csv"), ',' , '"');
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	       
	      //Read CSV line by line and use the string array as you want
	      
	      try {
			while ((nextLine = reader1.readNext()) != null) {
			     if (nextLine != null) {
			    	 String temp =  Arrays.toString(nextLine);
				        String[] tokens = temp.split(",");
						StringBuilder sb = new StringBuilder();
						for(int i =0; i <tokens.length;i++)//checks for comma 
						{
							
							if(i == tokens.length -1)
							{
								model1.addRow(new Object[]{tokens[0], tokens[1],tokens[2]});
							}
						}
						
			     }
			   }
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	   
	      accountTable.setModel(model1);
		
		
		
		accountTable.setBounds(0, 0, 255, 233);
		
		
		
		
		
		
		
		
	}
}


