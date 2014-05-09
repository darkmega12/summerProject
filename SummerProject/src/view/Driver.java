package view;

import java.awt.EventQueue;

import model.DatabaseConnector;
import model.UserImplementation; 

import controller_LoginModule.LoginController;

/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Runs the system
 * 
*****/


public class Driver
{

	
	public static UserImplementation mUser;
	
	public static void main(String[] args) 
	{
		instantEverything();
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginScreen loginFrame = new LoginScreen();
					loginFrame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/*****
	 * Function Name: instantEverything
	 * Description:	instantiates all model classes
	*****/
	public static void instantEverything()
	{
		mUser=new UserImplementation();
	}

}