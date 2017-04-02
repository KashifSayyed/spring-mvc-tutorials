/**
 * 
 */
package com.fundit.beans;

import java.io.Serializable;

/**
 * @author Kashif
 * 
 */
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
