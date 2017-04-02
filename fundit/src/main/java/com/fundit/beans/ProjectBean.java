package com.fundit.beans;

import java.io.Serializable;

public class ProjectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer project_id = 0;
	
	private String project_title;
	
	private String project_description;
	
	private String project_purpose;
	
	private String project_global_business;
	
	private String project_country;
	
	private String project_planned_finish_date;
	
	private Integer project_fund_required  = 0;
	
	private Integer project_fund_received  = 0;
	
	private Integer project_my_fund  = 0;
	
	private String user_id;
	
	private String video_url;

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public String getProject_title() {
		return project_title;
	}

	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public String getProject_purpose() {
		return project_purpose;
	}

	public void setProject_purpose(String project_purpose) {
		this.project_purpose = project_purpose;
	}

	public String getProject_global_business() {
		return project_global_business;
	}

	public void setProject_global_business(String project_global_business) {
		this.project_global_business = project_global_business;
	}

	public String getProject_planned_finish_date() {
		return project_planned_finish_date;
	}

	public void setProject_planned_finish_date(String project_planned_finish_date) {
		this.project_planned_finish_date = project_planned_finish_date;
	}

	public Integer getProject_fund_required() {
		return project_fund_required;
	}

	public void setProject_fund_required(Integer project_fund_required) {
		this.project_fund_required = project_fund_required;
	}

	public Integer getProject_fund_received() {
		return project_fund_received;
	}

	public void setProject_fund_received(Integer project_fund_received) {
		this.project_fund_received = project_fund_received;
	}

	public Integer getProject_my_fund() {
		return project_my_fund;
	}

	public void setProject_my_fund(Integer project_my_fund) {
		this.project_my_fund = project_my_fund;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public void setProject_country(String project_country) {
		this.project_country = project_country;
	}

	public String getProject_country() {
		return project_country;
	}
	
	
	
}
