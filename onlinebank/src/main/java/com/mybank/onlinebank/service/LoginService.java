/**
 * 
 */
package com.mybank.onlinebank.service;

import com.mybank.onlinebank.beans.LoginBean;
import com.mybank.onlinebank.beans.UserProfileBean;

/**
 * @author Kashif
 *
 */
public interface LoginService {
		
	public UserProfileBean authenticateUser(LoginBean loginBean);
	
	public boolean authorizeUser(LoginBean loginBean);
}
