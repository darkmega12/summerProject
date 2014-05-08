package controller;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.UserBean;
import model.UserImplementation;
import view.LoginScreen;
import view.FacultyMain;

public class UserController implements ActionListener 
{

	/**
	 * @param args
	 */
	private UserBean pBuser;
	private UserImplementation pIuser;
	private LoginScreen pLog;
	private FacultyMain pFaculty;
	
	public UserController(UserImplementation userModel, LoginScreen loginView)
	{
		pIuser=userModel;
		pLog=loginView;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		Object source = evt.getSource();
		System.out.println("Listened!");
		if(source==pLog.getLogbtn())
		{
			System.out.println("Reached inside");
			determineUser();
			pLog.setVisible(false);
			switch(pBuser.getpUserType())
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
	
	public void determineUser()
	{
		UserBean tempUser=new UserBean();
		tempUser.setpUserName(pLog.getUserField());
		tempUser.setpUserPassword(pLog.getPassField());
		pBuser= pIuser.getUser(tempUser);
	}
}
