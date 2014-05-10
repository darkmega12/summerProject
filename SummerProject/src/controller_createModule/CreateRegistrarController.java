package controller_createModule;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.RegistrarBean;
import model.RegistrarImplement;
import model.UserBean;
import model.UserImplement;
import view.CreateAccounts;

public class CreateRegistrarController implements ActionListener
{
	private RegistrarBean pRegBean;
	private RegistrarImplement pRegModel;
	private UserBean pUserBean;
	private UserImplement pUserImplement;
	private CreateAccounts pCreate;
	
	public CreateRegistrarController(RegistrarImplement registrarModel, CreateAccounts registrarView)
	{
		pRegModel= registrarModel;
		pCreate=registrarView;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
