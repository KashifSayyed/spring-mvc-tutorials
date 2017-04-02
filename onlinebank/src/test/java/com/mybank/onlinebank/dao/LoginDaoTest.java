/**
 * 
 */
package com.mybank.onlinebank.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybank.onlinebank.AppConfig;
import com.mybank.onlinebank.beans.UserProfileBean;

/**
 * @author Kashif
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class LoginDaoTest {

	@Resource
	@Qualifier("simpleLoginDao")
	private LoginDao loginDao;
	
	@Test
	public void testSuccessLogin(){
		UserProfileBean userProfileBean = loginDao.authenticateUser("johnsmith", "test");
		
		Assert.assertNotNull(userProfileBean);
		Assert.assertEquals(userProfileBean.getUserId(), "johnsmith");
		Assert.assertEquals(userProfileBean.getFirstName(), "John");
		Assert.assertEquals(userProfileBean.getLastName(), "Smith");
		Assert.assertEquals(userProfileBean.getEmail(), "john.smith@gmail.com");
	}
	
	@Test
	public void testFailLogin(){
		UserProfileBean userProfileBean = loginDao.authenticateUser("william", "test");
		
		Assert.assertNull(userProfileBean);
	}
}
