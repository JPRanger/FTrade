import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginScreen {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterUserName = new JLabel("FTrade");
		lblEnterUserName.setBounds(0, 0, 434, 44);
		lblEnterUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUserName.setFont(new Font("Tahoma", Font.PLAIN, 36));
		frame.getContentPane().add(lblEnterUserName);
		
		textField = new JTextField();
		textField.setBounds(171, 78, 131, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
				new MainScreen01();
				frame.dispose();
			}
		});
		
		JButton btnCreatePassword = new JButton("Create Account");
		btnCreatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreatePassword.setBounds(48, 213, 162, 26);
		frame.getContentPane().add(btnCreatePassword);
		
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnForgotPassword.setBounds(244, 213, 162, 26);
		frame.getContentPane().add(btnForgotPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 131, 131, 30);
		frame.getContentPane().add(passwordField);
	}
}
