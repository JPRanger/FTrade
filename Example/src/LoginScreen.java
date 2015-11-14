import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class LoginScreen {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField adminUserName;
	private JPasswordField adminPassword;
	

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
		frame.setLocationRelativeTo( null );
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		

		
		tabbedPane.setBounds(0, 0, 444, 20);
		frame.getContentPane().add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Regular User", null, panel, null);
			panel.setLayout(null);
		
			
			JLabel lblEnterUserName = new JLabel("F-Trade");
			panel.add(lblEnterUserName);
			lblEnterUserName.setBounds(138, 11, 189, 40);
			lblEnterUserName.setHorizontalAlignment(SwingConstants.CENTER);
			lblEnterUserName.setFont(new Font("Superclarendon", Font.PLAIN, 36));
			
			textField = new JTextField();
			panel.add(textField);
			textField.setBounds(171, 78, 131, 30);
			textField.setColumns(10);
			
			JLabel lblUsername = new JLabel("Username:");
			panel.add(lblUsername);
			lblUsername.setBounds(48, 76, 113, 26);
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JLabel lblPassword = new JLabel("Password:");
			panel.add(lblPassword);
			lblPassword.setBounds(48, 129, 113, 26);
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
			JButton btnLogin = new JButton("Login");
			panel.add(btnLogin);
			btnLogin.setBounds(199, 172, 78, 26);
			
			JButton btnCreatePassword = new JButton("Create account");
			panel.add(btnCreatePassword);
			btnCreatePassword.setBounds(61, 213, 131, 26);
			
			//Forgot Password
			JButton btnForgotPassword = new JButton("Forgot Password?");
			panel.add(btnForgotPassword);
			btnForgotPassword.setBounds(244, 213, 146, 26);
			
			passwordField = new JPasswordField();
			panel.add(passwordField);
			passwordField.setBounds(171, 131, 131, 30);
			
			JLabel lblRegularUser = new JLabel("Regular User");
			panel.add(lblRegularUser);
			lblRegularUser.setBounds(199, 61, 68, 15);
			lblRegularUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
			btnCreatePassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SignUpPage();
					frame.dispose();
				}
			});
			btnLogin.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new MainScreen();
					frame.dispose();
				}
			});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Admin", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("F-Trade");
		label_2.setBounds(138, 11, 189, 40);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 36));
		panel_1.add(label_2);
		
		JLabel label = new JLabel("Username:");
		label.setBounds(48, 76, 113, 26);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(label);
		
		adminUserName = new JTextField();
		adminUserName.setBounds(171, 78, 131, 30);
		adminUserName.setColumns(10);
		panel_1.add(adminUserName);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setBounds(48, 129, 113, 26);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(label_1);
		
		adminPassword = new JPasswordField();
		adminPassword.setBounds(171, 131, 131, 30);
		panel_1.add(adminPassword);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminMainScreen();
				frame.dispose();
			}
		});
		button.setBounds(199, 172, 78, 26);
		panel_1.add(button);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdmin.setBounds(199, 61, 68, 15);
		panel_1.add(lblAdmin);
		
		
		JLabel picLabel = new JLabel("");
		picLabel.setIcon(new ImageIcon("image/bkgd.jpg"));
		picLabel.setBounds(0, 0, 450, 278);
		panel.add(picLabel);
		
		JLabel picLabel2 = new JLabel("");
		picLabel2.setIcon(new ImageIcon("image/bkgd.jpg"));
		picLabel2.setBounds(0, 0, 450, 278);
		panel_1.add(picLabel2);
		
	}
}