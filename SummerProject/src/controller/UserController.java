package controller;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.UserBean;
import model.UserImplementation;
import view.LoginScreen;
import view.FacultyMain;

/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Handles the user models
 * 
*****/

public class UserController implements ActionListener 
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
	private FacultyMain pFaculty;
	
	
	public UserController(UserImplementation userModel, LoginScreen loginView)
	{
		pUmodel=userModel;
		pLog=loginView;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		Object source = evt.getSource();
		if(source==pLog.getLogbtn())
		{
			determineUser();
			pLog.setVisible(false);
			switch(pUbean.getpUserType())
			{
				case "registrar":
				pFaculty= new FacultyMain();
					break;
				case "company":
					break;
				case "agent":
					break;
			}
		}
	}
	
	/******
	 * Function Name: determineUser
	 * Description: verifies the user input (username and password) and checks for possible match in the database
	******/
	
	public void determineUser()
	{
		UserBean tempUser=new UserBean();
		tempUser.setpUserName(pLog.getUserField());
		tempUser.setpUserPassword(pLog.getPassField());
		pUbean= pUmodel.getUser(tempUser);
	}
}
