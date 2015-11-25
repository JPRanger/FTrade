import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.Timer;

import java.util.Random;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

import javax.swing.ImageIcon;

public class MainScreen {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtSearch;
	private JButton btnSearch;
	private String[] names = {"Coca-Cola","Apple","Google","Microsoft","Sony",
			"Florida Gulf Coast University","Dell","Hewlett-Packard","Toshiba",
			"Amazon","EBay","UPS","FedEx","Toyota","GMC","Tesla","Starbucks"};
	//Test cases: a,os
	private JButton[] results = new JButton[names.length];
	private JTextField textField;
	private JTextField textField_1;
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
		
		for(int i=0;i<results.length;i++){
			results[i]=new JButton(names[i]);
			results[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					final JFrame popup = new JFrame();
					popup.setBounds(100, 100, 330, 221);
					popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					popup.getContentPane().setLayout(null);
					popup.setLocationRelativeTo( null );

					
					JLabel lblHowManyStock = new JLabel("How much stock would you like to buy/sell?");
					lblHowManyStock.setHorizontalAlignment(SwingConstants.CENTER);
					lblHowManyStock.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblHowManyStock.setBounds(0, 11, 314, 43);
					popup.getContentPane().add(lblHowManyStock);
					
					final JTextField amountField = new JTextField();
					amountField.setBounds(56, 65, 189, 34);
					popup.getContentPane().add(amountField);
					amountField.setColumns(10);
					
					JButton btnBuy = new JButton("Buy");
					btnBuy.setBounds(28, 130, 89, 23);
					popup.getContentPane().add(btnBuy);
					btnBuy.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, "You bought " + amountField.getText() + " stock.");
							popup.dispose();
						}
						
					});
					
					JButton btnSell = new JButton("Sell");
					btnSell.setBounds(187, 130, 89, 23);
					popup.getContentPane().add(btnSell);
					
					popup.setVisible(true);
				}
			});
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				if(cb.getSelectedItem().equals("Name")){
					try{	
						panel_1.remove(txtSearch);
						panel_1.remove(btnSearch);
						for(JButton button : results)
							panel_1.remove(button);
						panel_1.revalidate();
						panel_1.repaint();
					}
					catch(NullPointerException npe){
						//Suppress warnings
					}
					
					txtSearch = new JTextField();
					txtSearch.setText("Params");
					txtSearch.setBounds(335, 38, 84, 20);
					panel_1.add(txtSearch);
					txtSearch.setColumns(10);
					txtSearch.addFocusListener(new FocusListener() {

						public void focusGained(FocusEvent arg0) {
							txtSearch.setText("");
						}

						public void focusLost(FocusEvent arg0) {/*Do nothing*/}
						
					});
				
					btnSearch = new JButton("Search");
					btnSearch.setBounds(335, 65, 83, 18);
					panel_1.add(btnSearch);
					btnSearch.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e1){
							for(JButton button : results)
								panel_1.remove(button);
							String searchParam = txtSearch.getText();
							int xPos=0, yPos=0;
							//Iterate through String array
							for(int i=0;i<names.length;i++){
								if(names[i].contains(searchParam)){
									results[i].setBounds(xPos,yPos,200,23);
									yPos+=23;
									panel_1.add(results[i]);
									panel_1.revalidate();
									panel_1.repaint();
								}
							}
						}
					});
				}
				else if(cb.getSelectedItem().equals("Volume")){
					try{	
						panel_1.remove(txtSearch);
						panel_1.remove(btnSearch);
						for(JButton button : results)
							panel_1.remove(button);
						panel_1.revalidate();
						panel_1.repaint();
					}
					catch(NullPointerException npe){
						//Suppress warnings
					}
						
				}
				else if(cb.getSelectedItem().equals("Price")){
					try{	
						panel_1.remove(txtSearch);
						panel_1.remove(btnSearch);
						for(JButton button : results)
							panel_1.remove(button);
						panel_1.revalidate();
						panel_1.repaint();
					}
					catch(NullPointerException npe){
						//Suppress warnings
					}
					
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Filter", "Price", "Volume", "Name"}));
		comboBox.setBounds(294, 11, 129, 20);
		panel_1.add(comboBox);
		
		JList list = new JList();
		list.setBounds(174, 191, -115, -85);
		panel_1.add(list);
		
		String [] ticketString = {"General Concern", "Payment Issue", "Account"}; 
		
		JPanel panel_3 = new JPanel();
		
		tabbedPane.addTab("Graph", null, panel_3, null);
		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(0, 0, 89, 23);
//		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tickets", null, panel_2, null);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(126, 51, 126, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(84, 107, 210, 82);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(141, 82, 86, 14);
		panel_2.add(lblDescription);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(163, 30, 46, 14);
		panel_2.add(lblNewLabel);
		JComboBox comboBox_1 = new JComboBox(ticketString);
		comboBox_1.setBounds(281, 42, 118, 20);
		panel_2.add(comboBox_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(330, 199, 89, 23);
		panel_2.add(btnSubmit);
	}
}