/*******
 *
 * Author: Christian Kiel Abejuro
 * 
 * Description: Handles the account creation for Company
 *
 *******/

package controller_createModule;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.RegistrarBean;
import model.RegistrarImplement;
import model.UserBean;
import model.UserImplement;
import view.CreateAccounts;
import view.Driver;

public class CreateRegistrarController implements ActionListener
{
	final static String REGISTRAR = "registrar";
	final static Color DEFAULTBG_COLOR = new JTextField().getBackground();
	final static Color DEFAULTFG_COLOR = new JTextField().getForeground();
	
	private RegistrarBean pRegBean;
	private RegistrarImplement pRegModel;
	private UserBean pUserBean;
	private UserImplement pUserModel;
	private CreateAccounts pCreate;
	
	/****
	 * missingDataList- used for storing the fields that are empty
	 * normalList- used for storing the fields that are filled up 
	 ****/
	private LinkedList<JTextField> missingDataList;
	private LinkedList<JTextField> normalList;
	
	public CreateRegistrarController(CreateAccounts registrarView)
	{
		pRegModel= new RegistrarImplement();
		pCreate=registrarView;
		pUserBean= new UserBean();
		pRegBean= new RegistrarBean();
		pUserModel= new UserImplement();
		missingDataList= new LinkedList<JTextField>();
		normalList= new LinkedList<JTextField>();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		setValues();
		if(errorHandling())
			return;
		
		int confirm= JOptionPane.showConfirmDialog(
				new JFrame(), 
				"Are you sure about the information given?", 
				"Confirm Add Account", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE);
		
		if(confirm==JOptionPane.YES_OPTION)
		{
			createRegistrar();
			int choice = JOptionPane.showConfirmDialog(
						 new JFrame(),
						 "<html>Account Created Successfully! Your username is: "+pUserBean.getpUserName()+
						 " </br> Would you like to go back to LoginScreen?</html>",
						 "Creation Success!",
						 JOptionPane.YES_NO_OPTION,
						 JOptionPane.QUESTION_MESSAGE);
			if(choice==JOptionPane.YES_OPTION)
			{
				pCreate.setVisible(false);
				Driver.loginFrame.setVisible(true);
			}
			if(choice==JOptionPane.NO_OPTION)
			{
				pCreate.lblSelect.setVisible(true);
				pCreate.panelLayer.show(pCreate.layerPanel, CreateAccounts.SELECTION_PANEL);
			}
		}
	}
	
	/******
	 * Function Name: setValues
	 * 
	 * Description: gets all the values from the user input and stores them in their respective beans
	 ******/
	
	public void setValues()
	{
		pRegBean.setpFirstName(pCreate.getRegFirstNameField().getText());
		pRegBean.setpMiddleName(pCreate.getRegMiddleNameField().getText());
		pRegBean.setpLastName(pCreate.getRegLastNameField().getText());
		
		/****
		 * +Creates a username with the format firstname.lastname where first name contains 
		 *  the first name of the user while the lastname contains the last name
		 * +the names are formatted to lower case and last name spaces are removed 
		 * eg name: Juan Lorenzo dela Cruz 
		 * 	  username: juan.delacruz
		 ****/
		String[] lastName= pRegBean.getpLastName().split(" ");
		String userName= pRegBean.getpFirstName().toLowerCase().split(" ")[0]+".";
		for(int i=0;i<lastName.length; i++)
			userName+=lastName[i].toLowerCase();
		pUserBean.setpUserName(userName);
		
		pUserBean.setpUserPassword(new String(pCreate.getRegPasswordField().getPassword()));
		pUserBean.setpUserType(REGISTRAR);
	}
	
	/*******
	 * Function Name: createRegistrar
	 *  
	 * Description: Adds the locally stored beans to the database
	 *******/
	
	public void createRegistrar()
	{
		pUserModel.addUser(pUserBean);
		UserBean tempBean= pUserModel.getUser(pUserBean);
		if(tempBean.getpIdUser()!=0)
			pRegModel.insertRegistrar(tempBean, pRegBean);
	}
	
	/******
	 * Function Name: errorHandling
	 * 
	 * Description: checks the user inputs if there are errors
	 ******/
	
	public boolean errorHandling()
	{
		boolean error= false;
		if(checkMissingData())
		{
			JOptionPane.showMessageDialog(
					new JFrame(),
					"Missing data on required fields",
					"Incomplete Data",
					JOptionPane.ERROR_MESSAGE);
			error= true;
		}
		else if(checkDuplicateData())
		{
			JOptionPane.showMessageDialog(
					new JFrame(),
					"The name you entered is already in the database",
					"Duplicate Data",
					JOptionPane.ERROR_MESSAGE);
			error= true;
		}
		//checks if the passwords entered are the identical
		else if(!new String(pCreate.getRegPasswordField().getPassword()).equals(new String(pCreate.getRegConfirmPasswordField().getPassword())))
		{
			JOptionPane.showMessageDialog(
					new JFrame(),
					"The passwords you entered did not match",
					"Password Mismatch",
					JOptionPane.ERROR_MESSAGE);
			error= true;
		}
		return error;
	}

	/******
	 * Function Name: checkDuplicateData
	 * 
	 * Description: checks if there are similar data of the registrar is already in the database.
	 * 	
	 * Return Type: boolean; returns true if there is duplicate data, otherwise false
	 ******/
	
	public boolean checkDuplicateData()
	{
		return pRegModel.searchDuplicate(pRegBean);
	}
	
	/******
	 * Function Name: checkMissingData
	 * 
	 * Description: checks all input fields if they are filled up
	 * 				if an input field is empty, it's added to missingDataList, otherwise it is added to normalList
	 * 
	 * Return Type: boolean; returns true if there are fields not filled up, otherwise false
	 ******/
	
	public boolean checkMissingData()
	{
		missingDataList.clear();
		normalList.clear();
		boolean missingData= false;
		if(pCreate.getRegFirstNameField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getRegFirstNameField());
		}
		else
			normalList.add(pCreate.getRegFirstNameField());
		if(pCreate.getRegMiddleNameField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getRegMiddleNameField());
		}
		else
			normalList.add(pCreate.getRegMiddleNameField());
		if(pCreate.getRegLastNameField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getRegLastNameField());
		}
		else
			normalList.add(pCreate.getRegLastNameField());
		if(new String(pCreate.getRegPasswordField().getPassword()).equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getRegPasswordField());
		}
		else
			normalList.add(pCreate.getRegPasswordField());
		if(new String(pCreate.getRegConfirmPasswordField().getPassword()).equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getRegConfirmPasswordField());
		}
		else
			normalList.add(pCreate.getRegConfirmPasswordField());
		for(JTextField e: missingDataList)
		{
			e.setBackground(Color.red);
			e.setForeground(Color.white);
		}
		for(JTextField e: normalList)
		{
			e.setBackground(DEFAULTBG_COLOR);
			e.setForeground(DEFAULTFG_COLOR);
		}
		return missingData;
	}
	
}

