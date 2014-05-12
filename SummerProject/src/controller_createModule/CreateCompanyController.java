/*******
 *
 * Author: Christian Kiel Abejuro
 * 
 * Description: Handles the account creation for Company
 *
 *******/

package controller_createModule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.CreateAccounts;
import view.Driver;
import model.CompanyBean;
import model.CompanyImplement;
import model.UserBean;
import model.UserImplement;
import java.sql.Date;

public class CreateCompanyController implements ActionListener
{

	final static String COMPANY = "company";
	final static Color DEFAULTBG_COLOR = new JTextField().getBackground();
	final static Color DEFAULTFG_COLOR = new JTextField().getForeground();
	
	private CompanyBean pCompanyBean;
	private CompanyImplement pCompanyModel;
	private UserBean pUserBean;
	private UserImplement pUserModel;
	private CreateAccounts pCreate;
	
	/****
	 * missingDataList- used for storing the fields that are empty
	 * normalList- used for storing the fields that are filled up 
	 ****/
	private LinkedList<JTextField> missingDataList;
	private LinkedList<JTextField> normalList;
	
	public CreateCompanyController(CompanyImplement model, CreateAccounts view)
	{
		pCompanyModel= model;
		pCreate= view;
		pUserBean=new UserBean();
		pUserModel= new UserImplement();
		pCompanyBean= new CompanyBean();
		missingDataList=new LinkedList<JTextField>();
		normalList=new LinkedList<JTextField>();
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
			createCompany();
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
		pCompanyBean.setpCompanyName(pCreate.getNameField().getText());
		pCompanyBean.setpContactNumber(pCreate.getNumberField().getText());
		pCompanyBean.setpStreet(pCreate.getStreetField().getText());
		if(!pCreate.getZipField().getText().equals(""))
			pCompanyBean.setpZipCode(Integer.parseInt(pCreate.getZipField().getText()));
		pCompanyBean.setpCity(pCreate.getCityField().getText());
		pCompanyBean.setCompanyStatus("active");
		
		/******
		 * Date is added by getting the values from the JCalendar and formats it to yyyy-mm-dd in a string
		 ******/
		String date= new String();
		String[] parsedDate= pCreate.getLblDate().getText().split("/");
		date+=parsedDate[2]+"-"+parsedDate[0]+"-"+parsedDate[1];
		pCompanyBean.setpRegistrationDate(Date.valueOf(date));
		
		/****
		 * +Creates a username with the format companyname_zipcode where companyname contains
		 * the full name of the company and zipcode contains the zipcode of the company
		 * +the company name is formatted to lower case and spaces are removed 
		 * eg name: Kiel Corp
		 * 	  zipcode: 1221
		 * 	  username: kielcorp_1221
		 ****/
		String[] companyName= pCreate.getNameField().getText().split(" ");
		String username= new String();
		for(String i: companyName)
			username+=i.toLowerCase();
		username+="_"+pCompanyBean.getpZipCode();
		
		pUserBean.setpUserName(username);
		pUserBean.setpUserPassword(new String(pCreate.getCompanyPassword().getPassword()));
		pUserBean.setpUserType(COMPANY);
	}
	
	/*******
	 * Function Name: createCompany
	 *  
	 * Description: Adds the locally stored beans to the database
	 *******/
	
	public void createCompany()
	{
		pUserModel.addUser(pUserBean);
		UserBean tempBean= pUserModel.getUser(pUserBean);
		if(tempBean.getpIdUser()!=0)
			pCompanyModel.insertCompany(pCompanyBean, tempBean);
	}
	
	/******
	 * Function Name: errorHandling
	 * 
	 * Description: checks the user inputs if there are errors
	 ******/
	
	public boolean errorHandling()
	{
		boolean error = false;
		if(checkMissingData())
		{
			JOptionPane.showMessageDialog(
					new JFrame(),
					"Missing data on required fields",
					"Incomplete Data",
					JOptionPane.ERROR_MESSAGE);
			error= true;
		}
		else if(checkDuplicate())
		{
			JOptionPane.showMessageDialog(
					new JFrame(),
					"The company you entered is already in the database",
					"Duplicate Data",
					JOptionPane.ERROR_MESSAGE);
			error= true;
		}
		//checks if the passwords entered are the identical
		else if(!new String(pCreate.getCompanyPassword().getPassword()).equals(new String(pCreate.getCompanyConfirmPassword().getPassword())))
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
	
	public boolean checkDuplicate()
	{
		return pCompanyModel.searchDuplicate(pCompanyBean);
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
		if(pCreate.getNameField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getNameField());
		}
		else
			normalList.add(pCreate.getNameField());
		if(pCreate.getNumberField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getNumberField());
		}
		else
			normalList.add(pCreate.getNumberField());
		if(new String(pCreate.getCompanyPassword().getPassword()).equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getCompanyPassword());
		}
		else
			normalList.add(pCreate.getCompanyPassword());
		if(new String(pCreate.getCompanyConfirmPassword().getPassword()).equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getCompanyConfirmPassword());
		}
		else
			normalList.add(pCreate.getCompanyConfirmPassword());
		if(pCreate.getZipField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getZipField());
		}
		else
			normalList.add(pCreate.getZipField());
		if(pCreate.getStreetField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getStreetField());
		}
		else
			normalList.add(pCreate.getStreetField());
		if(pCreate.getCityField().getText().equals(""))
		{
			missingData=true;
			missingDataList.add(pCreate.getCityField());
		}
		else
			normalList.add(pCreate.getCityField());
		if(!pCreate.getLblDate().isVisible())
		{
			missingData=true;
			pCreate.getLblDate().setVisible(true);
			pCreate.getLblDate().setForeground(Color.red);
		}
		
		//If a field is empty, the field will be colored red
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



