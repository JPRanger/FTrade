package FTrade;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.commons.io.FileUtils;

import com.opencsv.CSVReader;

public class SignUpPage {

	private JFrame frame;
	private JTextField emailTextField;
	private String currentUser = LoginScreen.loginInfo[0];
	CSVReader newUserReader;
	FileWriter newUserCreator, newUserFunds;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUpPage window = new SignUpPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SignUpPage() {
			initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() {
			
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo( null );
	
		JLabel lblEnterUserName = new JLabel("Sign up");
		lblEnterUserName.setBounds(0, 0, 450, 66);
		lblEnterUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUserName.setFont(new Font("Superclarendon", Font.PLAIN, 36));
		frame.getContentPane().add(lblEnterUserName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(95, 66, 119, 26);
		frame.getContentPane().add(lblUsername);

		//userName textField
		final JTextField userNameTextField = new JTextField();
		userNameTextField.setBounds(202, 67, 162, 30);
		frame.getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(101, 108, 113, 26);
		frame.getContentPane().add(lblPassword);
		
		//password textField
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(202, 109, 162, 30);
		frame.getContentPane().add(passwordField);

		
		
		final JLabel lblRePassword = new JLabel("Confirm password:");
		lblRePassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRePassword.setBounds(26, 150, 177, 26);
		frame.getContentPane().add(lblRePassword);
		
		//confirmPassword textField
		final JPasswordField confirmPassword = new JPasswordField();
		confirmPassword.setBounds(202, 151, 162, 30);
		frame.getContentPane().add(confirmPassword);
		
		JButton btnCreatePassword = new JButton("Create account");
		btnCreatePassword.setBounds(240, 233, 131, 26);
		frame.getContentPane().add(btnCreatePassword);
		btnCreatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] checkUsername;
				try(CSVReader usernameCheck = new CSVReader(new FileReader("accounts/accounts.csv"))){
					while((checkUsername = usernameCheck.readNext()) != null){
						if(checkUsername[0].equals(userNameTextField.getText())){
							JOptionPane.showMessageDialog(null, "Username already exists", 
									"Invalid Username", JOptionPane.ERROR_MESSAGE);
							userNameTextField.setText("");
							passwordField.setText("");
							confirmPassword.setText("");
							emailTextField.setText("");
							return;
						}
					}
				}
				catch(FileNotFoundException fnfe){
					System.err.println("Accounts file not found during login check");
					System.exit(1);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				//checking input validation
				if(userNameTextField.getText().length()>0 && passwordField.getText().length()>0 &&
						lblRePassword.getText().length()>0){
					if(passwordField.getText().equals(confirmPassword.getText())) {
						if(emailTextField.getText().contains("@")){
							JOptionPane.showMessageDialog(null, "Account created:\nYour username: " + 
									userNameTextField.getText() + "\nYour password: " + passwordField.getText());
								/*
								 * store user info to a file in here
								 */
							char[] newPassword = passwordField.getPassword();
							for(int i=0; i<newPassword.length; i++){
								newPassword[i]+=i;
							}
							String storePassword = new String(newPassword);
							System.out.println(newPassword);
							String newAccount = new String(String.format("%s, %s, %s\n", userNameTextField.getText(),
									storePassword, emailTextField.getText()));

							try (PrintWriter accountWriter = new PrintWriter(
									new BufferedWriter(new FileWriter(LoginScreen.accountsFile, true)));) {
								

							accountWriter.write(newAccount);

							} catch (IOException e1) {
								System.err.println("newAccount format failed");
								e1.printStackTrace();
							} 
							
							try {
								/*Create directory and files for new user*/
								File dir = new File("accounts/users/" + userNameTextField.getText());
								dir.mkdirs();
								String numSharesInitStr = String.format("accounts/users/%s/CurrentShares.csv", 
										userNameTextField.getText());
								File numSharesInit = new File(numSharesInitStr);
								numSharesInit.createNewFile();
								String fundsInitStr = String.format("accounts/users/%s/CurrentFunds.dat",
										userNameTextField.getText());
								File fundsInit = new File(fundsInitStr);
								fundsInit.createNewFile();
								
								/*Set starting funds to $500*/
								newUserFunds = new FileWriter(fundsInit);
								String initFunds = "500";
								newUserFunds.write(initFunds);
								newUserFunds.flush();
								
								/*Update sorted_by_name.csv to store number of shares, not volume*/
								File source = new File("tickets/sorted_by_name.csv");
								File dest = numSharesInit;
								
								newUserReader = new CSVReader(new FileReader(source));
								newUserCreator = new FileWriter(dest, true);
								String[] userInfo;
								
								while((userInfo = newUserReader.readNext()) != null){
									userInfo[2] = "0";
									String currentStockLine = String.format("%s, %s, %s", userInfo[0], 
											userInfo[1], userInfo[2]);
									newUserCreator.write(currentStockLine);
									newUserCreator.write(System.lineSeparator());
									newUserCreator.flush();
								}
								
								
								
							} catch (IOException e1) {
								System.err.println("Account file creation failed");
								e1.printStackTrace();
							} finally{
								try {
									newUserReader.close();
									newUserCreator.close();
								} catch (IOException e1) {
									System.err.println("Failed to close file creation read/write");
									e1.printStackTrace();
								}
								
							}
							
							new LoginScreen();
							frame.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Invalid Email address");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Password doesn't match");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill up all required information");
				}
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(80, 233, 131, 26);
		frame.getContentPane().add(cancelButton);
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new LoginScreen();
				frame.dispose();
			}
			
		});
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(136, 191, 113, 30);
		frame.getContentPane().add(lblEmail);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(202, 193, 162, 28);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/image/bkgd.jpg")));
		label.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(label);
	}
}
