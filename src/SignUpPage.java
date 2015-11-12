import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.StandardOpenOption;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SignUpPage {

	private JFrame frame;
	private JTextField emailTextField;

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
							String newAccount = new String(String.format("%s %s %s\n", userNameTextField.getText(),
									passwordField.getPassword().toString(), emailTextField.getText()));
							File accountsFile = new File("accounts/accounts.dat");

							try (PrintWriter accountWriter = new PrintWriter(
									new BufferedWriter(new FileWriter(accountsFile, true)));) {
								if (!accountsFile.exists()) {
									accountsFile.createNewFile();
								}

								accountWriter.write(newAccount);

							} catch (IOException e1) {
								System.err.println("newAccount format failed");
								e1.printStackTrace();
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
		label.setIcon(new ImageIcon("image/bkgd.jpg"));
		label.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(label);
	}
}
