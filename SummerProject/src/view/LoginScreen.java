package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import controller_LoginModule.LoginController;

/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Login screen design
*****/

public class LoginScreen extends JFrame 
{

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private LoginController pLoginCtrl;
	/**
	 * Create the frame.
	 */
	public LoginScreen() 
	{
		pLoginCtrl= new LoginController(Driver.mUser, this);
		
		setTitle("E-CALL PLACEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 589, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(132, 193, 76, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(132, 230, 76, 32);
		panel.add(lblNewLabel_1);
		
		userField = new JTextField();
		userField.setBounds(249, 195, 242, 28);
		panel.add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 234, 242, 28);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(187, 300, 251, 50);
		btnLogin.addActionListener(pLoginCtrl);
		panel.add(btnLogin);
		
		JButton btnCreate = new JButton("CREATE ACCOUNT");
		btnCreate.setForeground(new Color(0, 0, 0));
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreate.setBounds(313, 407, 150, 27);
		btnCreate.setOpaque(false);
		btnCreate.setBorderPainted(false);
		panel.add(btnCreate);
		
		JLabel lblDontHaveAn = new JLabel("Don't Have an Account?");
		lblDontHaveAn.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDontHaveAn.setBounds(139, 405, 164, 31);
		panel.add(lblDontHaveAn);
	}
	
	public Object getLogbtn()
	{
		return btnLogin;
	}
	
	public String getUserField()
	{
		return userField.getText();
	}
	public String getPassField()
	{
		return new String(passwordField.getPassword());
	}
	
	public void determineModule(String userType)
	{
		switch(userType)
		{
			case "registrar":
			case "admin":
				EventQueue.invokeLater(new Runnable() 
				{
					public void run() 
					{
						try 
						{
							FacultyMain facultyFrame = new FacultyMain();
							facultyFrame.setVisible(true);
						} catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				});
				break;
			case "company":
				break;
			case "agent":
				break;
		}
	}
}
