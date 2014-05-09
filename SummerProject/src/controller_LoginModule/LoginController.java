package controller_LoginModule;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.UserBean;
import model.UserImplementation;
import view.LoginScreen;

/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Handles the user models
 * 
*****/

public class LoginController implements ActionListener 
{

	/******
	 * pUbean- a user bean used as temporary storage
	 * pUmodel - implementation of user bean
	 * pLog- login screen
	 * pFaculty- main screen of Faculty
	******/
	
	private UserBean pUbean;
	private UserImplementation pUmodel;
	private LoginScreen pLog;
	
	
	public LoginController(UserImplementation userModel, LoginScreen loginView)
	{
		pUmodel=userModel;
		pLog=loginView;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		errorHandling();
		if(determineUser())
		{
			pLog.setVisible(false);
			pLog.determineModule(pUbean.getpUserType());
		}
	}
	
	/******
	 * Function Name: determineUser
	 * Description: verifies the user input (username and password) and checks for possible match in the database
	******/
	
	public boolean determineUser()
	{
		UserBean tempUser=new UserBean();
		pUmodel.getAllUsers();
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
	
	public void errorHandling()
	{
		/*if(pLog.getUserField().equals(""))
		{
			JOptionPane.showMessageDialog(frame,
				    "Eggs are not supposed to be green.",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);
		}*/
	}
}
