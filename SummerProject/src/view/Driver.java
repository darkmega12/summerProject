package view;

import java.awt.EventQueue;

import model.DatabaseConnector;
import model.UserImplementation; 

import controller.UserController;

/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Runs the system
 * 
*****/


public class Driver
{

	
	static UserImplementation mUser;
	static UserController cUser;
	
	public static void main(String[] args) 
	{
		System.out.println("Hi");
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					initEverything();
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/*****
	 * Function Name: initEverything
	 * Description: initializes db and other things that i haven't foreseen
	*****/
	public static void initEverything()
	{
		DatabaseConnector db= new DatabaseConnector();
		mUser= new UserImplementation(db);
	}

}
