package com.fundit.beans;

import java.io.Serializable;

public class FundingBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String user_id;
	
	private Integer project_id;
	
	private Integer fund_added;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public Integer getFund_added() {
		return fund_added;
	}

	public void setFund_added(Integer fund_added) {
		this.fund_added = fund_added;
	}
	
}
