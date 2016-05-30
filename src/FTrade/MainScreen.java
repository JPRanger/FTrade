package FTrade;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.opencsv.CSVReader;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.util.Arrays;
import java.util.Random;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;

import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;

public class MainScreen {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtSearch;
	private JButton btnSearch;
	private JTable table;
	private int row, column;
	private double price, funds;
	CSVReader fundsReader;
	private JTextField titleField;
	private JTextArea descField;
	private JPanel fundsPanel;
	private JButton logoutButton;
	// string stores news for JLabels
	private String headLines1 = "\u2022 American Airlines tops profit estimates";
	private String headLines2 = "\u2022 Microsoft to lay off 1,000 more workers: reports";
	private String headLines3 = "\u2022 Tesla to make cars in China within two years";
	private String headLines4 = "\u2022 Goldman: Euro could end 2015 at $1.05";
	private String headLines5 = "\u2022 Exxon Mobil (XOM) Stock Falls Along With Oil Prices";
	private String headLines6 = "\u2022 Report claims iPhone 6s isn�t selling as fast as Apple thought it would";
	private String headLines7 = "\u2022 Following sales slump Macy's may slash prices for Christmas";
	private String headLines8 = "\u2022 Oracle's Amazon-killer might really be 6 months away";
	private String headLines9 = "\u2022 Cyber Monday Set to be Bigger Driver of Online Holiday Sales \r\n";
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
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
		frame.setLocationRelativeTo(null);
		frame.setTitle("FTrade: " + LoginScreen.loginInfo[0]);

		JPanel newsPanel = new JPanel();
		newsPanel.setBackground(new Color(255, 255, 255));
		newsPanel.setToolTipText("");
		tabbedPane.addTab("News", null, newsPanel, null);
		newsPanel.setLayout(null);
//
//		try {
//			fundsReader = new CSVReader(
//					new FileReader("accounts/users/" + LoginScreen.loginInfo[0] + "/CurrentFunds.dat"));
//
//			fundsPanel = new JPanel();
//			fundsPanel.setLayout(new BorderLayout());
//			funds = Double.parseDouble(fundsReader.readNext()[0]);
//
//			logoutButton = new JButton("Logout");
//			logoutButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					new LoginScreen();
//					frame.dispose();
//				}
//			});
//
//			fundsPanel.add(logoutButton, BorderLayout.WEST);
//			fundsPanel.add(new JLabel(String.format("Current Funds: $%.2f", funds)), BorderLayout.EAST);
//
//			frame.getContentPane().add(fundsPanel, BorderLayout.SOUTH);
//		} catch (FileNotFoundException e3) {
//			System.err.println("Current funds reader failed to open");
//			e3.printStackTrace();
//		} catch (IOException e1) {
//			System.err.println("Failed to read current funds");
//			e1.printStackTrace();
//		} finally {
//			try {
//				fundsReader.close();
//			} catch (IOException e1) {
//				System.err.println("Failed to close funds reader");
//				e1.printStackTrace();
//			}
//		}

		JLabel lblNews = new JLabel("News");
		lblNews.setFont(new Font("Thames", Font.BOLD | Font.ITALIC, 25));
		lblNews.setBounds(38, 11, 91, 32);
		newsPanel.add(lblNews);

		final JLabel lblHeadLine1 = new JLabel();
		lblHeadLine1.setText(headLines1);
		lblHeadLine1.setBounds(23, 54, 381, 32);
		newsPanel.add(lblHeadLine1);

		final JLabel lblHeadLine2 = new JLabel();
		lblHeadLine2.setText(headLines2);
		lblHeadLine2.setBounds(23, 91, 381, 32);
		newsPanel.add(lblHeadLine2);

		final JLabel lblHeadLine3 = new JLabel();
		lblHeadLine3.setText(headLines3);
		lblHeadLine3.setBounds(23, 134, 381, 32);
		newsPanel.add(lblHeadLine3);

		final JLabel lblHeadLine4 = new JLabel();
		lblHeadLine4.setText(headLines4);
		lblHeadLine4.setBounds(23, 177, 381, 32);
		newsPanel.add(lblHeadLine4);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/image/bkgd.jpg")));
		lblNewLabel_2.setBounds(0, 0, 429, 233);
		newsPanel.add(lblNewLabel_2);
		Timer timer = new Timer(4000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				Random randomGenerator = new Random();
				int textChange = randomGenerator.nextInt(4);
				switch (textChange) {
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
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.start();

		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Trade", null, panel_1, null);

		final JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Name", "Volume", "Price" }));

		final Object[][] rowData = {};
		final Object[] columnNames = { "Name", "Price", "Volume" };

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		table = new JTable();
		scrollPane.setViewportView(table);
		final DefaultTableModel model;
		model = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int rowData, int columnNames) {
				return false;
			}
		};

		// default sorted by name
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("tickets/sorted_by_name.csv"), ',', '"');
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// Read CSV line by line and use the string array as you want
		String[] nextLine;
		try {
			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {
					String temp = Arrays.toString(nextLine);
					String[] tokens = temp.split(",");
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < tokens.length; i++)// checks for comma
					{

						if (i == tokens.length - 1) {
							/* Trim extra brackets */
							tokens[0] = tokens[0].substring(1);
							tokens[2] = tokens[2].substring(0, tokens[2].length() - 1);

							model.addRow(new Object[] { tokens[0], tokens[1], tokens[2] });
						}
					}

				}
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		table.setModel(model);
		
		JLabel label = new JLabel("New label");
		scrollPane.setRowHeaderView(label);
		panel_1.add(scrollPane);
		panel_1.add(comboBox);

		// starting sorting by price/volume/name/keyword
		// sorted by price
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				final DefaultTableModel model;
				model = new DefaultTableModel(rowData, columnNames) {
					public boolean isCellEditable(int rowData, int columnNames) {
						return false;
					}
				};
				// sorted by price
				if (comboBox.getSelectedItem().equals("Price")) {
					CSVReader reader = null;
					try {
						reader = new CSVReader(new FileReader("tickets/sorted_by_price.csv"), ',', '"');
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					// Read CSV line by line and use the string array as you
					// want
					String[] nextLine;
					try {
						while ((nextLine = reader.readNext()) != null) {
							if (nextLine != null) {
								String temp = Arrays.toString(nextLine);
								String[] tokens = temp.split(",");
								StringBuilder sb = new StringBuilder();
								for (int i = 0; i < tokens.length; i++)// checks
									// for
									// comma
								{

									if (i == tokens.length - 1) {
										/* Trim extra brackets */
										tokens[0] = tokens[0].substring(1);
										tokens[2] = tokens[2].substring(0, tokens[2].length() - 1);

										model.addRow(new Object[] { tokens[0], tokens[1], tokens[2] });
									}
								}

							}
						}
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					table.setModel(model);
				} // end price

				// sorted by volume
				if (comboBox.getSelectedItem().equals("Volume")) {
					CSVReader reader = null;
					try {
						reader = new CSVReader(new FileReader("tickets/sorted_by_volume.csv"), ',', '"');
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					// Read CSV line by line and use the string array as you
					// want
					String[] nextLine;
					try {
						while ((nextLine = reader.readNext()) != null) {
							if (nextLine != null) {
								String temp = Arrays.toString(nextLine);
								String[] tokens = temp.split(",");
								StringBuilder sb = new StringBuilder();
								for (int i = 0; i < tokens.length; i++)// checks
									// for
									// comma
								{

									if (i == tokens.length - 1) {
										/* Trim extra brackets */
										tokens[0] = tokens[0].substring(1);
										tokens[2] = tokens[2].substring(0, tokens[2].length() - 1);

										model.addRow(new Object[] { tokens[0], tokens[1], tokens[2] });
									}
								}

							}
						}
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					table.setModel(model);
				} // end volume

				// sorted by name
				if (comboBox.getSelectedItem().equals("Name")) {
					CSVReader reader = null;
					try {
						reader = new CSVReader(new FileReader("tickets/sorted_by_name.csv"), ',', '"');
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					// Read CSV line by line and use the string array as you
					// want
					String[] nextLine;
					try {
						while ((nextLine = reader.readNext()) != null) {
							if (nextLine != null) {
								String temp = Arrays.toString(nextLine);
								String[] tokens = temp.split(",");
								StringBuilder sb = new StringBuilder();
								for (int i = 0; i < tokens.length; i++)// checks
									// for
									// comma
								{

									if (i == tokens.length - 1) {
										/* Trim extra brackets */
										tokens[0] = tokens[0].substring(1);
										tokens[2] = tokens[2].substring(0, tokens[2].length() - 1);

										model.addRow(new Object[] { tokens[0], tokens[1], tokens[2] });
									}
								}

							}
						}
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					table.setModel(model);
				} // end name

				panel_1.revalidate();
				panel_1.repaint();
			}
		});// end sorting of price/volume/name/keyword

		// buy/sell stock
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					final JTable target = (JTable) e.getSource();
					row = target.getSelectedRow(); // the row number that user
					// clicks, you might need
					// this for the file

					// popup window for buying/selling stocks
					final JFrame popup = new JFrame();
					popup.setBounds(100, 100, 335, 221);
					popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					popup.getContentPane().setLayout(null);
					popup.setLocationRelativeTo(null);

					JLabel lblHowManyStock = new JLabel("How much stock would you like to buy/sell?");
					lblHowManyStock.setHorizontalAlignment(SwingConstants.CENTER);
					lblHowManyStock.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblHowManyStock.setBounds(3, 11, 330, 43);
					popup.getContentPane().add(lblHowManyStock);

					final JTextField amountField = new JTextField();
					amountField.setBounds(59, 65, 189, 34);
					popup.getContentPane().add(amountField);
					amountField.setColumns(10);

					JButton btnBuy = new JButton("Buy");
					btnBuy.setBounds(31, 130, 89, 23);
					popup.getContentPane().add(btnBuy);
					btnBuy.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							/*
							 * add stock amount from the file
							 */

							if (comboBox.getSelectedIndex() == 0) { // sorted by
								// name
								try (CSVReader priceReader = new CSVReader(
										new FileReader("tickets/sorted_by_name.csv"))) {
									String[] priceStr = null;
									while ((priceStr = priceReader.readNext()) != null) {
										if (priceStr[0].equals(target.getValueAt(row, 0))) {
											price = Double.parseDouble(priceStr[1]);
											price *= Double.parseDouble(amountField.getText());
											funds -= price;
											if (funds < 0) {
												funds += price;
												JOptionPane.showMessageDialog(null, "Not enough funds");
											} else {
												JOptionPane.showMessageDialog(null,
														"You bought " + amountField.getText() + " shares.");
											}
											fundsPanel.removeAll();
											fundsPanel.add(logoutButton, BorderLayout.WEST);
											fundsPanel.add(new JLabel(String.format("Current Funds: $%.2f", funds)),
													BorderLayout.EAST);
											fundsPanel.revalidate();
										}
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

							else if (comboBox.getSelectedIndex() == 1) { // sorted
								// by
								// price
								try (CSVReader priceReader = new CSVReader(
										new FileReader("tickets/sorted_by_price.csv"))) {
									String[] priceStr = null;
									while ((priceStr = priceReader.readNext()) != null) {
										if (priceStr[0].equals(target.getValueAt(row, 0))) {
											price = Double.parseDouble(priceStr[1]);
											price *= Double.parseDouble(amountField.getText());
											funds -= price;
											if (funds < 0) {
												funds += price;
												JOptionPane.showMessageDialog(null, "Not enough funds");
											} else {
												JOptionPane.showMessageDialog(null,
														"You bought " + amountField.getText() + " shares.");
											}
											fundsPanel.removeAll();
											fundsPanel.add(logoutButton, BorderLayout.WEST);
											fundsPanel.add(new JLabel(String.format("Current Funds: $%.2f", funds)),
													BorderLayout.EAST);
											fundsPanel.revalidate();
										}
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

							else if (comboBox.getSelectedIndex() == 2) { // sorted
								// by
								// volume
								try (CSVReader priceReader = new CSVReader(
										new FileReader("tickets/sorted_by_volume.csv"))) {
									String[] priceStr = null;
									while ((priceStr = priceReader.readNext()) != null) {
										if (priceStr[0].equals(target.getValueAt(row, 0))) {
											price = Double.parseDouble(priceStr[1]);
											price *= Double.parseDouble(amountField.getText());
											funds -= price;
											if (funds < 0) {
												funds += price;
												JOptionPane.showMessageDialog(null, "Not enough funds");
											} else {
												JOptionPane.showMessageDialog(null,
														"You bought " + amountField.getText() + " shares.");
											}
											fundsPanel.removeAll();
											fundsPanel.add(logoutButton, BorderLayout.WEST);
											fundsPanel.add(new JLabel(String.format("Current Funds: $%.2f", funds)),
													BorderLayout.EAST);
											fundsPanel.revalidate();
										}
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

							popup.dispose();
						}

					});

					JButton btnSell = new JButton("Sell");
					btnSell.setBounds(190, 130, 89, 23);
					popup.getContentPane().add(btnSell);
					btnSell.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							boolean canSell = false;
							/*
							 * reduce stock amount from the file
							 */
							if (comboBox.getSelectedIndex() == 0) { // sorted by
								// name
								try (CSVReader sharesReader = new CSVReader(new FileReader(String
										.format("accounts/users/%s/CurrentShares.csv", LoginScreen.loginInfo[0])))) {
									String[] sharesStr;
									while ((sharesStr = sharesReader.readNext()) != null) {
										if (sharesStr[0].equals(target.getValueAt(row, 0))) {
											if (Double.parseDouble(sharesStr[2]) > Double
													.parseDouble(amountField.getText())) {
												canSell = true;
											}
										}
									}

								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

								try (CSVReader priceReader = new CSVReader(
										new FileReader("tickets/sorted_by_name.csv"))) {
									String[] priceStr = null;
									while ((priceStr = priceReader.readNext()) != null) {
										if (priceStr[0].equals(target.getValueAt(row, 0))) {
											price = Double.parseDouble(priceStr[1]);
											price *= Double.parseDouble(amountField.getText());
											funds += price;
											fundsPanel.removeAll();
											fundsPanel.add(logoutButton, BorderLayout.WEST);
											fundsPanel.add(new JLabel(String.format("Current Funds: $%.2f", funds)),
													BorderLayout.EAST);
											fundsPanel.revalidate();
										}
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

							else if (comboBox.getSelectedIndex() == 1) { // sorted
								// by
								// price

								try (CSVReader sharesReader = new CSVReader(new FileReader(String
										.format("accounts/users/%s/CurrentShares.csv", LoginScreen.loginInfo[0])))) {
									String[] sharesStr;
									while ((sharesStr = sharesReader.readNext()) != null) {
										if (sharesStr[0].equals(target.getValueAt(row, 0))) {
											if (Double.parseDouble(sharesStr[2]) > Double
													.parseDouble(amountField.getText())) {
												canSell = true;
											}
										}
									}

								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

								try (CSVReader priceReader = new CSVReader(
										new FileReader("tickets/sorted_by_price.csv"))) {
									String[] priceStr = null;
									while ((priceStr = priceReader.readNext()) != null) {
										if (priceStr[0].equals(target.getValueAt(row, 0))) {
											price = Double.parseDouble(priceStr[1]);
											price *= Double.parseDouble(amountField.getText());
											funds += price;
											fundsPanel.removeAll();
											fundsPanel.add(logoutButton, BorderLayout.WEST);
											fundsPanel.add(new JLabel(String.format("Current Funds: $%.2f", funds)),
													BorderLayout.EAST);
											fundsPanel.revalidate();
										}
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}

							else if (comboBox.getSelectedIndex() == 2) { // sorted
								// by
								// volume

								try (CSVReader sharesReader = new CSVReader(new FileReader(String
										.format("accounts/users/%s/CurrentShares.csv", LoginScreen.loginInfo[0])))) {
									String[] sharesStr;
									while ((sharesStr = sharesReader.readNext()) != null) {
										if (sharesStr[0].equals(target.getValueAt(row, 0))) {
											if (Double.parseDouble(sharesStr[2]) > Double
													.parseDouble(amountField.getText())) {
												canSell = true;
											}
										}
									}

								} catch (IOException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

								try (CSVReader priceReader = new CSVReader(
										new FileReader("tickets/sorted_by_volume.csv"))) {
									String[] priceStr = null;
									while ((priceStr = priceReader.readNext()) != null) {
										if (priceStr[0].equals(target.getValueAt(row, 0))) {
											price = Double.parseDouble(priceStr[1]);
											price *= Double.parseDouble(amountField.getText());
											funds += price;
											fundsPanel.removeAll();
											fundsPanel.add(logoutButton, BorderLayout.WEST);
											fundsPanel.add(new JLabel(String.format("Current Funds: $%.2f", funds)),
													BorderLayout.EAST);
											fundsPanel.revalidate();
										}
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

							}

							JOptionPane.showMessageDialog(null, "You sold " + amountField.getText() + " shares.");

							popup.dispose();
						}

					});
					popup.setVisible(true); // end popup
				}
			}
		});

		final String[] ticketString = { "General Concern", "Payment Issue", "Account" };

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
		ticketType.setBounds(281, 42, 150, 20);
		panel_2.add(ticketType);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(330, 199, 89, 23);
		panel_2.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (FileWriter ticketWriter = new FileWriter(LoginScreen.ticketsFile, true)) {
					final String LINEBREAK = System.lineSeparator();

					String ticketSubmission = String.format("%s, %s, %s", ticketType.getSelectedIndex(),
							titleField.getText(), descField.getText());
					ticketWriter.write(ticketSubmission);
					ticketWriter.write(LINEBREAK);

					JOptionPane.showMessageDialog(null, "Ticket submitted");
					titleField.setText("");
					descField.setText("");

				} catch (IOException e1) {
					System.err.println("Failed to write to tickets file");
				}
			}
		});
	}
}