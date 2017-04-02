/**
 * 
 */
package com.mybank.onlinebank.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mybank.onlinebank.beans.UserProfileBean;

/**
 * @author Kashif
 *
 */
@Component("simpleLoginDao")
public class SimpleLoginDao implements LoginDao {

	private List<UserProfileBean> userList;

	{
		userList = new ArrayList<UserProfileBean>();
		
		UserProfileBean userProfileBean = new UserProfileBean();
		userProfileBean.setUserId("johnsmith");
		userProfileBean.setFirstName("John");
		userProfileBean.setLastName("Smith");
		userProfileBean.setEmail("john.smith@gmail.com");
		
		userList.add(userProfileBean);
		
		userProfileBean = new UserProfileBean();
		userProfileBean.setUserId("bendiaz");
		userProfileBean.setFirstName("Ben");
		userProfileBean.setLastName("Diaz");
		userProfileBean.setEmail("ben.diaz@gmail.com");
		
		userList.add(userProfileBean);
	}
	
	public UserProfileBean authenticateUser(String userName, String password) {
		for(UserProfileBean userProfileBean: userList){
			if(userProfileBean.getUserId().equalsIgnoreCase(userName)){
				return userProfileBean;
			}
		}
		return null;
	}

	public boolean authorizeUser(String userName) {
		// TODO Auto-generated method stub
		return false;
	}
}
