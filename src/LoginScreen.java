import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class LoginScreen {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private Scanner loginCheck;
	protected static String[] loginInfo = new String[3];

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
		frame = new JFrame("FTrade");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo( null );
		
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
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ 
				/*Check password*/
				String fieldPassword = new String(passwordField.getPassword()).trim();
				try{
					loginCheck = new Scanner(new File("accounts/accounts.dat"));
				}
				catch(FileNotFoundException fnfe){
					System.err.println("Accounts file not found during login check");
					System.exit(1);
				}
				while(loginCheck.hasNext()){
					String checkUsername = loginCheck.next();
					if(checkUsername.equals(usernameField.getText())){
						System.out.println("Username check success");
						loginInfo[0] = checkUsername;
						char[] passwordConvert = loginCheck.next().toCharArray();
						for(int i=0; i<passwordConvert.length; i++){
							passwordConvert[i]-=i;
						}
						loginInfo[1] = new String(passwordConvert).trim();
						loginInfo[2] = loginCheck.next();
						if(fieldPassword.equals(loginInfo[1])){
							new MainScreen();
							frame.dispose();
							break;
						}
						else{
							usernameField.setText("");
							passwordField.setText("");
							JOptionPane.showMessageDialog(null, "Username or password incorrect.", "Incorrect Login", 
									JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						if(loginCheck.hasNext()){
							continue;
						}
						System.out.println("username check fail");
						usernameField.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(null, "Username not found", "No Such User", 
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton btnCreatePassword = new JButton("Create account");
		btnCreatePassword.setBounds(61, 213, 131, 26);
		frame.getContentPane().add(btnCreatePassword);
		btnCreatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUpPage();
				frame.dispose();
			}
		});
		
		//Forgot Password
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBounds(244, 213, 146, 26);
		frame.getContentPane().add(btnForgotPassword);
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(true) {
					String input = JOptionPane.showInputDialog(null, "Please enter your Email");
					/*Close if cancel is pressed*/
					if(input==null){
						break;
					}
					if(input.contains("@")){
						/*
						 * input is user Email, check Email in the file
						 */
						JOptionPane.showMessageDialog(null, "Password has been sent to your Email");
						break;
					} 
						JOptionPane.showMessageDialog(null, "Invalid Email");
						
				}//end loop				
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 131, 131, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image/bkgd.jpg"));
		label.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(label);
	}
}