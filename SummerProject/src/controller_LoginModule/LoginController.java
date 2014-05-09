/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Handles the user models
 * 
*****/
package controller_LoginModule;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.UserBean;
import model.UserImplement;
import view.LoginScreen;



public class LoginController implements ActionListener 
{

	/******
	 * pUbean- a user bean used as temporary storage
	 * pUmodel - implementation of user bean
	 * pLog- login screen
	 * pFaculty- main screen of Faculty
	******/
	
	private UserBean pUbean;
	private UserImplement pUmodel;
	private LoginScreen pLog;
	
	
	public LoginController(UserImplement userModel, LoginScreen loginView)
	{
		pUmodel=userModel;
		pLog=loginView;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		if(errorHandling())
			return;
		if(determineUser())
		{
			pLog.setVisible(false);
			pLog.determineModule(pUbean.getpUserType());
		}
		else
			JOptionPane.showMessageDialog(new JFrame(),
				    "Username and Password is invalid.",
				    "",
				    JOptionPane.ERROR_MESSAGE);
	}
	
	/******
	 * Function Name: determineUser
	 * Description: verifies the user input (username and password) and checks for possible match in the database
	******/
	
	public boolean determineUser()
	{
		UserBean tempUser=new UserBean();
		System.out.println("performed");
		tempUser.setpUserName(pLog.getUserField());
		tempUser.setpUserPassword(pLog.getPassField());
		pUbean= pUmodel.getUser(tempUser);
		/* If user type is null, the function getUser returned the parameter indicating that the user is not in the database*/
		if(pUbean.getpUserType()==null)
		{
			System.out.println("No user in database");
			return false;
		}
		return true;
	}
	
	public boolean errorHandling()
	{
		if(pLog.getUserField().equals(""))
		{
			JOptionPane.showMessageDialog(new JFrame(),
				    "Please input username.",
				    "Login Error",
				    JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}
}
