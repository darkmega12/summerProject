/*****
 * 
 * Author: Christian Kiel Abejuro
 * 
 * Description: Runs the system
 * 
*****/

package view;

import java.awt.EventQueue;

import model.DatabaseConnector;
import model.UserImplement; 

import controller_LoginModule.LoginController;


public class Driver
{	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginScreen loginFrame = new LoginScreen();
					loginFrame.setVisible(true);
					loginFrame.setLocationRelativeTo(null);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}