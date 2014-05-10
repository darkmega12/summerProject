package controller_createModule;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.RegistrarBean;
import model.RegistrarImplement;
import model.UserBean;
import model.UserImplement;
import view.CreateAccounts;

public class CreateRegistrarController implements ActionListener
{
	final static String REGISTRAR = "registrar";
	
	private RegistrarBean pRegBean;
	private RegistrarImplement pRegModel;
	private UserBean pUserBean;
	private UserImplement pUserModel;
	private CreateAccounts pCreate;
	
	public CreateRegistrarController(RegistrarImplement registrarModel, CreateAccounts registrarView)
	{
		pRegModel= registrarModel;
		pCreate=registrarView;
		pUserBean= new UserBean();
		pRegBean= new RegistrarBean();
		pUserModel= new UserImplement();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int choice= JOptionPane.showConfirmDialog(
				new JFrame(), 
				"Are you sure about the information given?", 
				"Confirm Add Account", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE);
		
		if(!errorHandling() && choice==JOptionPane.YES_OPTION)
		{
			setValues();
			createRegistrar();
			JOptionPane.showMessageDialog(
				new JFrame(),
				"Account Created Successfully! Your username is: "+pUserBean.getpUserName(),
				"Creation Success!",
				JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void setValues()
	{
		pRegBean.setpFirstName(pCreate.getRegFirstName());
		pRegBean.setpMiddleName(pCreate.getRegMiddleName());
		pRegBean.setpLastName(pCreate.getRegLastName());
		
		String[] lastName= pRegBean.getpLastName().split(" ");
		String userName= pRegBean.getpFirstName().toLowerCase().split(" ")[0]+".";
		for(int i=0;i<lastName.length; i++)
			userName+=lastName[i].toLowerCase();
		pUserBean.setpUserName(userName);
		pUserBean.setpUserPassword(pCreate.getRegPassword());
		pUserBean.setpUserType(REGISTRAR);
	}
	
	public void createRegistrar()
	{
		pUserModel.addUser(pUserBean);
		UserBean tempBean= pUserModel.getUser(pUserBean);
		if(tempBean.getpIdUser()!=0)
			pRegModel.insertRegistrar(tempBean, pRegBean);
	}
	
	public boolean errorHandling()
	{
		return false;
	}
}

