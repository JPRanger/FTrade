package FTrade;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.opencsv.CSVReader;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;

public class LoginScreen {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private CSVReader loginCheck;
	private boolean loginStatus = false;
	protected static String[] loginInfo = new String[3];
	protected static File accountsFile = new File("accounts/accounts.csv");
	protected static File ticketsFile = new File("tickets/tickets.csv");
	protected static File usersFolder = new File("accounts/users");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginScreen() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/* Create data storage files */
		try {
			File ticketsDir = new File("tickets");
			File accountsDir = new File("accounts");
			ticketsDir.mkdirs();
			accountsDir.mkdirs();
			usersFolder.mkdirs();
			accountsFile.createNewFile();
			ticketsFile.createNewFile();
		} catch (IOException ioe) {
			System.err.println("File initialization failed");
		}

		frame = new JFrame("FTrade");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblEnterUserName = new JLabel("F-Trade");
		lblEnterUserName.setBounds(0, 0, 450, 66);
		lblEnterUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUserName.setFont(new Font("Superclarendon", Font.PLAIN, 36));
		frame.getContentPane().add(lblEnterUserName);

		usernameField = new JTextField();
		usernameField.setBounds(171, 78, 131, 30);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(48, 76, 113, 26);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(48, 129, 113, 26);
		frame.getContentPane().add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(199, 172, 78, 26);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginStatus = false;
				/* Check login */
				String fieldPassword = new String(passwordField.getPassword()).trim();
				try {
					loginCheck = new CSVReader(new FileReader("accounts/accounts.csv"));
				} catch (FileNotFoundException fnfe) {
					System.err.println("Accounts file not found during login check");
					System.exit(1);
				}
				try {
					while ((loginInfo = loginCheck.readNext()) != null) {
						String checkUsername = loginInfo[0];
						
						if(usernameField.getText().equals("admin")){
							if(fieldPassword.equals("admin")){
								new AdminMainScreen();
								frame.dispose();
								loginStatus = true;
								break;
							}
						}
						
						if (checkUsername.equals(usernameField.getText())) {
							char[] passwordConvert = loginInfo[1].trim().toCharArray();
							for (int i = 0; i < passwordConvert.length; i++) {
								passwordConvert[i] -= i;
							}
							loginInfo[1] = new String(passwordConvert).trim();
							if (fieldPassword.equals(loginInfo[1])) {
								new MainScreen();
								frame.dispose();
								loginStatus = true;
								break;
							} 
							else {
								usernameField.setText("");
								passwordField.setText("");
								JOptionPane.showMessageDialog(null, "Username or password incorrect.",
										"Incorrect Login", JOptionPane.ERROR_MESSAGE);
							}
						} 
					}
					if(!loginStatus){
						usernameField.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(null, "Username or password incorrect.",
								"Incorrect Login", JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e1) {
					System.out.println("Headless Exception");
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnCreatePassword = new JButton("Create account");
		btnCreatePassword.setBounds(61, 213, 170, 26);
		frame.getContentPane().add(btnCreatePassword);
		btnCreatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUpPage();
				frame.dispose();
			}
		});

		// Forgot Password
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBounds(244, 213, 170, 26);
		frame.getContentPane().add(btnForgotPassword);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (true) {
					String input = JOptionPane.showInputDialog(null, "Please enter your Email");
					/* Close if cancel is pressed */
					if (input == null) {
						break;
					}
					if (input.contains("@")) {
						JFrame workingDialog = new JFrame("Please Wait");
						workingDialog.setSize(200, 100);
						JLabel workingLabel = new JLabel("Working...");
						workingDialog.add(workingLabel, BorderLayout.CENTER);
						workingDialog.setVisible(true);
						/*
						 * input is user Email, check Email in the file
						 */
						boolean wasSent = false;
						String to = null;
						String userPassword = null;
						String host = "smtp.gmail.com";
						String from = "ftradeas@gmail.com";
						String pass = "ftradeaccountsupport";

						Properties props = System.getProperties();
						props.put("mail.smtp.ssl.enable", "true"); // added this
																	// line
						props.put("mail.smtp.host", host);
						props.put("mail.smtp.user", from);
						props.put("mail.smtp.password", pass);
						props.put("mail.smtp.port", "465");
						props.put("mail.smtp.auth", "true");

						Session session = Session.getDefaultInstance(props, null);

						try {
							loginCheck = new CSVReader(new FileReader("accounts/accounts.csv"));
						} catch (FileNotFoundException e1) {
							System.out.println("Error opening accounts file");
							e1.printStackTrace();
						}

						String[] forgotPassInfo;
						try {
							while ((forgotPassInfo = loginCheck.readNext()) != null) {
								if ((to = forgotPassInfo[2]) != null) {
									if(to.trim().equals(input)){
										try {
											MimeMessage message = new MimeMessage(session);
	
											message.setFrom(new InternetAddress(from));
											message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
											message.setSubject("Forgot Password - FTrade");
	
											char[] userPassConvert = forgotPassInfo[1].trim().toCharArray();
											userPassword = "";
											for (int i = 0; i < userPassConvert.length; i++) {
												userPassConvert[i] -= i;
												userPassword += userPassConvert[i];
											}
											message.setText("Your password is: " + userPassword);
	
											Transport transport = session.getTransport("smtp");
											transport.connect(host, from, pass);
											transport.sendMessage(message, message.getAllRecipients());
											transport.close();
	
											wasSent = true;
	
										} catch (MessagingException me) {
											System.out.println("Failed to send message");
											System.out.println(me.getLocalizedMessage());
											me.printStackTrace();
										}
									}
									else{
										continue;
									}
								}
							} //end while
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						if (wasSent) {
							workingDialog.dispose();
							JOptionPane.showMessageDialog(null, "Password has been sent to your Email");
							break;
						} else { // No message sent
							JOptionPane.showMessageDialog(null, "Email not registered");
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "Invalid Email");

				} // end loop
			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(171, 131, 131, 30);
		frame.getContentPane().add(passwordField);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/image/bkgd.jpg")));
		label.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(label);
	}
}