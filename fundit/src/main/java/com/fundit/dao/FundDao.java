/**
 * 
 */
package com.fundit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.fundit.beans.FundingBean;

/**
 * @author Kashif
 * 
 */
public class FundDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public boolean addFund(FundingBean fundingBean) {
		boolean isSuccess = false;
		String query = "INSERT INTO FUNDING ( USER_ID , PROJECT_ID , FUND_ADDED) VALUES (?,?,?)";
		String selectQuery = "SELECT SUM(FUND_ADDED) AS TOTAL_FUND FROM FUNDING WHERE PROJECT_ID =? AND USER_ID NOT IN (SELECT USER_ID FROM PROJECT WHERE PROJECT_ID =?)";
		String updateOwnerQuery = "UPDATE PROJECT  SET PROJECT_MY_FUND = PROJECT_MY_FUND + ? WHERE PROJECT_ID= ? AND USER_ID=?";
		String updateQuery = "UPDATE PROJECT  SET PROJECT_FUND_RECEIVED = PROJECT_MY_FUND + ? WHERE PROJECT_ID= ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = dataSource.getConnection().prepareStatement(query);
			System.out.println("query= "+ query);
			
			pstmt.setString(1, fundingBean.getUser_id());
			pstmt.setInt(2, fundingBean.getProject_id());
			pstmt.setInt(3, fundingBean.getFund_added());
			pstmt.executeUpdate();
			
			pstmt = dataSource.getConnection().prepareStatement(selectQuery);
			System.out.println("selectQuery= "+ selectQuery);
			pstmt.setInt(1, fundingBean.getProject_id());
			pstmt.setInt(2, fundingBean.getProject_id());
			ResultSet rs = pstmt.executeQuery();
			int totalFund = 0;
			if(rs.next()){
				totalFund = rs.getInt("TOTAL_FUND");
				System.out.println("Total Funds= "+ totalFund);
			}
			
			pstmt = dataSource.getConnection().prepareStatement(updateOwnerQuery);
			System.out.println("updateOwnerQuery= "+ updateOwnerQuery);
			pstmt.setInt(1, fundingBean.getFund_added());
			pstmt.setInt(2, fundingBean.getProject_id());
			pstmt.setString(3, fundingBean.getUser_id());
			pstmt.executeUpdate();
			
			pstmt = dataSource.getConnection().prepareStatement(updateQuery);
			System.out.println("updateQuery= "+ updateQuery);
			pstmt.setInt(1, totalFund);
			pstmt.setInt(2, fundingBean.getProject_id());
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
