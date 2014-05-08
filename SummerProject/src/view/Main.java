package view;

import java.awt.EventQueue;

import model.DatabaseConnector;
import controller.UserController;

public class Main 
{

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		DatabaseConnector db= new DatabaseConnector();
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					
					LoginScreen frame = new LoginScreen(uControl);
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

}
