/************

Author: Patricia Anne Eugenio

Description: Interface of the User related queries implemented by UserImplement
Date: 5/13/2014
************/
package model;

import java.util.ArrayList;

public interface UserInterface 
{
	public ArrayList<UserBean> getAllUsers();
	public void addUser(UserBean newUser);
	public UserBean getUser(UserBean uBean);
	public boolean updateUser(UserBean newUserBean, UserBean oldUserBean);
	public ArrayList<UserBean> searchUserByUser(UserBean userBean); // get user by user details
}
