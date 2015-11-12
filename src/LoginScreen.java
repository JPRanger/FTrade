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
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

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
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
				new MainScreen();
				frame.dispose();
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
			public void actionPerformed(ActionEvent arg0) {
				while(true) {
					String input = JOptionPane.showInputDialog(null, "Please enter your Email");
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