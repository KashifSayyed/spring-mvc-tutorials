/**
 * 
 */
package com.fundit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.fundit.beans.ProjectBean;

/**
 * @author Kashif
 * 
 */
public class ProjectDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public ProjectBean getProject(int projectId) {
		String query = "Select PROJECT_ID, PROJECT_TITLE , PROJECT_DESCRIPTION , PROJECT_CATEGORY, PROJECT_GLOBAL_BUSINESS,"
				+ " PROJECT_COUNTRY, PROJECT_PLANNED_FINISH_DATE , PROJECT_FUND_REQUIRED , PROJECT_FUND_RECEIVED ,"
				+ " USER_ID, PROJECT_MY_FUND , VIDEO_URL"
				+ " from PROJECT where PROJECT_ID = ? ";
		
		System.out.println("query: "+ query);
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ProjectBean projectBean = null;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);

			pstmt.setInt(1, projectId);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				projectBean = new ProjectBean();
				projectBean.setProject_id(resultSet.getInt("PROJECT_ID"));
				projectBean.setProject_title(resultSet
						.getString("PROJECT_TITLE"));
				projectBean.setProject_description(resultSet
						.getString("PROJECT_DESCRIPTION"));
				projectBean.setProject_purpose(resultSet
						.getString("PROJECT_CATEGORY"));
				projectBean.setProject_global_business(resultSet
						.getString("PROJECT_GLOBAL_BUSINESS"));
				projectBean.setProject_country(resultSet
						.getString("PROJECT_COUNTRY"));
				projectBean.setProject_planned_finish_date(resultSet
						.getString("PROJECT_PLANNED_FINISH_DATE"));
				projectBean.setProject_fund_required(resultSet
						.getInt("PROJECT_FUND_REQUIRED"));
				projectBean.setProject_fund_received(resultSet
						.getInt("PROJECT_FUND_RECEIVED"));
				projectBean.setUser_id(resultSet.getString("USER_ID"));
				projectBean.setProject_my_fund(resultSet
						.getInt("PROJECT_MY_FUND"));
				projectBean.setVideo_url(resultSet.getString("VIDEO_URL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return projectBean;
	}

	public List<ProjectBean> getAllProject() {
		String query = "Select PROJECT_ID, PROJECT_TITLE , PROJECT_DESCRIPTION , PROJECT_CATEGORY, PROJECT_GLOBAL_BUSINESS,"
				+ " PROJECT_COUNTRY, PROJECT_PLANNED_FINISH_DATE , PROJECT_FUND_REQUIRED , PROJECT_FUND_RECEIVED ,"
				+ " USER_ID, PROJECT_MY_FUND , VIDEO_URL"
				+ " from PROJECT";
		System.out.println("query: "+ query);
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ProjectBean projectBean = null;
		List<ProjectBean> projectList = new ArrayList<ProjectBean>();
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			resultSet = pstmt.executeQuery();
	
			while(resultSet.next()) {
				projectBean = new ProjectBean();
				projectBean.setProject_id(resultSet.getInt("PROJECT_ID"));
				projectBean.setProject_title(resultSet
						.getString("PROJECT_TITLE"));
				projectBean.setProject_description(resultSet
						.getString("PROJECT_DESCRIPTION"));
				if(projectBean.getProject_id() == 3){
					System.out.println("Length: "+ projectBean.getProject_description().length());
				}
				if(projectBean.getProject_description() != null && projectBean.getProject_description().length() > 75){
					projectBean.setProject_description(projectBean.getProject_description().substring(0, 75).concat("..."));
				}
				
				projectBean.setProject_purpose(resultSet
						.getString("PROJECT_CATEGORY"));
				projectBean.setProject_global_business(resultSet
						.getString("PROJECT_GLOBAL_BUSINESS"));
				projectBean.setProject_country(resultSet
						.getString("PROJECT_COUNTRY"));
				projectBean.setProject_planned_finish_date(resultSet
						.getString("PROJECT_PLANNED_FINISH_DATE"));
				projectBean.setProject_fund_required(resultSet
						.getInt("PROJECT_FUND_REQUIRED"));
				projectBean.setProject_fund_received(resultSet
						.getInt("PROJECT_FUND_RECEIVED"));
				projectBean.setUser_id(resultSet.getString("USER_ID"));
				projectBean.setProject_my_fund(resultSet
						.getInt("PROJECT_MY_FUND"));
				projectBean.setVideo_url(resultSet.getString("VIDEO_URL"));
				
				projectList.add(projectBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return projectList;
	}

	public boolean addProject(ProjectBean projectBean) {
		boolean isSuccess = false;
		String query = "INSERT INTO PROJECT ( PROJECT_TITLE , PROJECT_DESCRIPTION , PROJECT_CATEGORY, PROJECT_GLOBAL_BUSINESS, PROJECT_COUNTRY, PROJECT_PLANNED_FINISH_DATE , PROJECT_FUND_REQUIRED , PROJECT_FUND_RECEIVED , USER_ID, PROJECT_MY_FUND , VIDEO_URL) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date endDate = new java.util.Date(projectBean.getProject_planned_finish_date());
		String formatedDate = sdf.format(endDate);
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);

			pstmt.setString(1, projectBean.getProject_title());
			pstmt.setString(2, projectBean.getProject_description());
			pstmt.setString(3, projectBean.getProject_purpose());
			pstmt.setString(4, projectBean.getProject_global_business());
			pstmt.setString(5, projectBean.getProject_country());
			pstmt.setString(6, projectBean.getProject_planned_finish_date());
			pstmt.setInt(7, projectBean.getProject_fund_required());
			pstmt.setInt(8, projectBean.getProject_my_fund());
			pstmt.setString(9, projectBean.getUser_id());
			pstmt.setInt(10, projectBean.getProject_my_fund());
			pstmt.setString(11, projectBean.getVideo_url());

			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return isSuccess;
	}
}
