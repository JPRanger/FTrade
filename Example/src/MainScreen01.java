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
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class MainScreen01 {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtSearch;
	private JButton btnSearch;
	private String[] names = {"Coca-Cola","Apple","Google","Microsoft","Sony",
			"Florida Gulf Coast University","Dell","Hewlett-Packard","Toshiba",
			"Amazon","EBay","UPS","FedEx","Toyota","GMC","Tesla","Starbucks"};
	//Test cases: a,os
	private JButton[] results = new JButton[names.length];

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
	 */
	public MainScreen01() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setToolTipText("");
		tabbedPane.addTab("News", null, panel, null);
		panel.setLayout(null);
		
		JTextArea txtNewsFeed = new JTextArea();
		txtNewsFeed.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtNewsFeed.setBounds(10, 54, 409, 157);
		txtNewsFeed.setLineWrap(true);
		txtNewsFeed.setText("\u2022 American Airlines tops profit estimates \r\n\u2022 Microsoft to lay off 1,000 more workers: reports\r\n\u2022 Tesla to make cars in China within two years \r\n\u2022 Goldman: Euro could end 2015 at $1.05 ");
		panel.add(txtNewsFeed);
		
		JLabel lblNews = new JLabel("News");
		lblNews.setFont(new Font("Thames", Font.BOLD | Font.ITALIC, 25));
		lblNews.setBounds(38, 11, 91, 32);
		panel.add(lblNews);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Trade", null, panel_1, null);
		panel_1.setLayout(null);
		
		for(int i=0;i<results.length;i++){
			results[i]=new JButton(names[i]);
			results[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JFrame popup = new JFrame();
					popup.setBounds(100, 100, 330, 221);
					popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					popup.getContentPane().setLayout(null);
					
					JLabel lblHowManyStock = new JLabel("How much stock would you like to buy/sell?");
					lblHowManyStock.setHorizontalAlignment(SwingConstants.CENTER);
					lblHowManyStock.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblHowManyStock.setBounds(0, 11, 314, 43);
					popup.getContentPane().add(lblHowManyStock);
					
					JTextField amountField = new JTextField();
					amountField.setBounds(56, 65, 189, 34);
					popup.getContentPane().add(amountField);
					amountField.setColumns(10);
					
					JButton btnBuy = new JButton("Buy");
					btnBuy.setBounds(28, 130, 89, 23);
					popup.getContentPane().add(btnBuy);
					
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
		comboBox.setBounds(335, 11, 84, 20);
		panel_1.add(comboBox);
		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(0, 0, 89, 23);
//		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tickets", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Graph", null, panel_3, null);
	}
}
