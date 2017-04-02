/**
 * 
 */
package com.fundit.services;

import com.fundit.beans.LoginBean;
import com.fundit.beans.UserProfileBean;
import com.fundit.dao.LoginDao;

/**
 * @author Kashif
 *
 */
public class LoginService {
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}
	
	public UserProfileBean authenticateUser(LoginBean loginBean){
		return loginDao.authenticateUser(loginBean.getUsername(), loginBean.getPassword());
	}
	
	public void createTables() {
		 loginDao.createTables();
	}
}
