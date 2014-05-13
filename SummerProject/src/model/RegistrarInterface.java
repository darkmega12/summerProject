/************

Author: Patricia Anne Eugenio

Description: Interface of the Registrar related queries implemented by RegistrarImplement
Date: 5/13/2014
************/
package model;

import java.util.ArrayList;

public interface RegistrarInterface 
{
	public void insertRegistrar(UserBean userBean, RegistrarBean registrarBean);
	public ArrayList<UserBean> getAllUsers();
	public boolean searchDuplicate(RegistrarBean registrarBean);
	public boolean updateRegistrar(RegistrarBean newRegistrarBean, RegistrarBean oldRegistrarBean);
	public int searchIdUserByName(RegistrarBean registrarBean);
	public int searchIdRegistrarByName(RegistrarBean registrarBean);
}
