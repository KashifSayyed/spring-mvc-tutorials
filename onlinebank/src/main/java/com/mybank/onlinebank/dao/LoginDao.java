package com.mybank.onlinebank.dao;

import com.mybank.onlinebank.beans.UserProfileBean;

public interface LoginDao {

	public UserProfileBean authenticateUser(String userName, String password);
	public boolean authorizeUser(String userName);
}
