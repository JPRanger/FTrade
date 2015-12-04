package FTrade;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.util.Arrays;
import java.util.Random;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;




import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import com.opencsv.CSVReader;

public class MainScreen {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtSearch;
	private JButton btnSearch;
	private String[] names = {"Coca-Cola","Apple","Google","Microsoft","Sony",
			"IBM","Hewlett-Packard","Toshiba","Orcale",
			"Amazon","EBay","UPS","FedEx","Toyota","GMC","Tesla","Starbucks"};
	//Test cases: a,os
	private JButton[] results = new JButton[names.length];
	private JTextField titleField;
	private JTextArea descField;
	//string stores news for JLabels
	private String headLines1 =  "\u2022 American Airlines tops profit estimates";
	private String headLines2 =  "\u2022 Microsoft to lay off 1,000 more workers: reports";
	private String headLines3 =  "\u2022 Tesla to make cars in China within two years";
	private String headLines4 =  "\u2022 Goldman: Euro could end 2015 at $1.05";
	private String headLines5 =  "\u2022 Exxon Mobil (XOM) Stock Falls Along With Oil Prices";
	private String headLines6 =	 "\u2022 Report claims iPhone 6s isn�t selling as fast as Apple thought it would";
	private String headLines7 =  "\u2022 Following sales slump Macy's may slash prices for Christmas";
	private String headLines8 =  "\u2022 Oracle's Amazon-killer might really be 6 months away";
	private String headLines9 =  "\u2022 Cyber Monday Set to be Bigger Driver of Online Holiday Sales \r\n";
	private String headLines10 = "\u2022 Will Higher Store Traffic Boost Walmart�s 3Q16 Same-Store Sales?";
	private String headLines11 = "\u2022 Takata fined millions over airbags";
	private String headLines12 = "\u2022 Oil down 2%; worries of another rise in US crude stockpiles";
	private String headLines13 = "\u2022 Dell-EMC merger faces several lawsuits from shareholders";
	private String headLines14 = "\u2022FedEx, UPS Gear Up For The Most Important Quarter Of The Year";
	private String headLines15 = "\u2022 Toshiba Shares Fall After Loss, Lawsuits";
	private String headLines16 = "\u2022 Hewlett Packard Enterprise, HP Inc. Announce Dividends ";
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainScreen01 window = new MainScreen01();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public MainScreen() {
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
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		frame.setLocationRelativeTo( null );
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setToolTipText("");
		tabbedPane.addTab("News", null, panel, null);
		panel.setLayout(null);

		
		
		JLabel lblNews = new JLabel("News");
		lblNews.setFont(new Font("Thames", Font.BOLD | Font.ITALIC, 25));
		lblNews.setBounds(38, 11, 91, 32);
		panel.add(lblNews);
		
		final JLabel lblHeadLine1 = new JLabel();
		lblHeadLine1.setText(headLines1);
		lblHeadLine1.setBounds(23, 54, 381, 32);
		panel.add(lblHeadLine1);
		
		final JLabel lblHeadLine2 = new JLabel();
		lblHeadLine2.setText(headLines2);
		lblHeadLine2.setBounds(23, 91, 381, 32);
		panel.add(lblHeadLine2);
		
		final JLabel lblHeadLine3 = new JLabel();
		lblHeadLine3.setText(headLines3);
		lblHeadLine3.setBounds(23, 134, 381, 32);
		panel.add(lblHeadLine3);
		
		final JLabel lblHeadLine4 = new JLabel();
		lblHeadLine4.setText(headLines4);
		lblHeadLine4.setBounds(23, 177, 381, 32);
		panel.add(lblHeadLine4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("image/bkgd.jpg"));
		lblNewLabel_2.setBounds(0, 0, 429, 233);
		panel.add(lblNewLabel_2);
		Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	 Random randomGenerator = new Random();
            	int textChange = randomGenerator.nextInt(4);
            	switch(textChange){
            	case 0:
            		lblHeadLine1.setText(headLines9);
            		lblHeadLine2.setText(headLines10);
            		lblHeadLine3.setText(headLines11);
            		lblHeadLine4.setText(headLines12);            		
            		lblHeadLine1.repaint();
            		break;
            	case 1:
            		lblHeadLine1.setText(headLines1);
            		lblHeadLine2.setText(headLines2);
            		lblHeadLine3.setText(headLines3);
            		lblHeadLine4.setText(headLines4);
            		break;
            	case 2:
            		lblHeadLine1.setText(headLines5);
            		lblHeadLine2.setText(headLines6);
            		lblHeadLine3.setText(headLines7);
            		lblHeadLine4.setText(headLines8);
            		lblHeadLine1.repaint();
            		break;
            	case 3:
            		lblHeadLine1.setText(headLines13);
            		lblHeadLine2.setText(headLines14);
            		lblHeadLine3.setText(headLines15);
            		lblHeadLine4.setText(headLines16);            		
            		lblHeadLine1.repaint();
            }
        }});
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start(); 
		


		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Trade", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Filter", "Price", "Volume", "Name"}));
		comboBox.setBounds(294, 11, 129, 20);
		panel_1.add(comboBox);
		
		final Object[][] rowData = {};
		final Object[] columnNames = {"Name", "Price","Volume"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 284, 233);
		panel_1.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
	    DefaultTableModel model;
	    model = new DefaultTableModel(rowData, columnNames){
	    	   public boolean isCellEditable(int rowData, int columnNames){
	    	        return false;
	    	   }
	    	};
	    CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("tickets/quotes.csv"), ',' , '"');
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
								model.addRow(new Object[]{tokens[0], tokens[1], tokens[2]});
							}
						}
						
			     }
			   }
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	   
	   table.setModel(model);
		
		
		
		
		JPanel panel_3 = new JPanel();
		
		tabbedPane.addTab("Graph", null, panel_3, null);
		panel_3.setLayout(null);
		
		final String [] ticketString = {"General Concern", "Payment Issue", "Account"}; 
		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(0, 0, 89, 23);
//		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tickets", null, panel_2, null);
		panel_2.setLayout(null);
		
		titleField = new JTextField();
		titleField.setBounds(126, 51, 126, 20);
		panel_2.add(titleField);
		titleField.setColumns(10);
		
		descField = new JTextArea();
		descField.setBounds(84, 107, 210, 82);
		panel_2.add(descField);
		descField.setColumns(10);
		descField.setLineWrap(true);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(141, 82, 86, 14);
		panel_2.add(lblDescription);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(163, 30, 46, 14);
		panel_2.add(lblNewLabel);
		
		final JComboBox ticketType = new JComboBox(ticketString);
		ticketType.setBounds(281, 42, 118, 20);
		panel_2.add(ticketType);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(330, 199, 89, 23);
		panel_2.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try(FileWriter ticketWriter = new FileWriter(LoginScreen.ticketsFile,true)) {
					final String LINEBREAK = System.lineSeparator();
					
					ticketWriter.write(ticketString[ticketType.getSelectedIndex()] + LINEBREAK);
					ticketWriter.write(titleField.getText() + LINEBREAK);
					ticketWriter.write(descField.getText() + LINEBREAK);
					ticketWriter.write(LINEBREAK);
				} catch (IOException e1) {
					System.err.println("Failed to write to tickets file");
				}
			}
		});
	}
}