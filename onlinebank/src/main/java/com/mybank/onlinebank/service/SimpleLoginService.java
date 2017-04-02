/**
 * 
 */
package com.mybank.onlinebank.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.mybank.onlinebank.beans.LoginBean;
import com.mybank.onlinebank.beans.UserProfileBean;
import com.mybank.onlinebank.dao.LoginDao;

/**
 * @author Kashif
 *
 */
@Component
public class SimpleLoginService implements LoginService {

	@Resource
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

	public boolean authorizeUser(LoginBean loginBean) {
		return loginDao.authorizeUser(loginBean.getUsername());
	}
}
