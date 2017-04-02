/**
 * 
 */
package com.fundit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.fundit.beans.UserProfileBean;

/**
 * @author Kashif
 * 
 */
public class LoginDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public UserProfileBean authenticateUser(String userName, String password) {
		//createTables();
		String query = "Select USER_ID, FIRST_NAME, LAST_NAME,BUSINESS_FUNCTION, EMAIL from USERPROFILE where USER_ID = ? and PASSWORD = ?";
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		UserProfileBean userProfileBean = null;
		try {
			pstmt = dataSource.getConnection().prepareStatement(query);

			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next()){
				userProfileBean = new UserProfileBean();
				userProfileBean.setUserId(resultSet.getString("USER_ID"));
				userProfileBean.setFirstName(resultSet.getString("FIRST_NAME"));
				userProfileBean.setLastName(resultSet.getString("LAST_NAME"));
				userProfileBean.setBusinessFunction(resultSet.getString("BUSINESS_FUNCTION"));
				userProfileBean.setEmail(resultSet.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return userProfileBean;
	}
	
	public void createTables(){
		String dropUserProfiletable = "DROP TABLE USERPROFILE";
		String dropProjecttable = "DROP TABLE PROJECT";
		String dropFundingtable = "DROP TABLE FUNDING";
		String ddlUserProfile = "CREATE TABLE USERPROFILE(USER_ID VARCHAR(20) NOT NULL, PASSWORD VARCHAR(20) NOT NULL, FIRST_NAME VARCHAR(40) NOT NULL, LAST_NAME VARCHAR(40) NOT NULL, BUSINESS_FUNCTION VARCHAR(40), EMAIL VARCHAR(40), PRIMARY KEY (USER_ID))";
		String ddlProject = "CREATE TABLE PROJECT (PROJECT_ID INT NOT NULL AUTO_INCREMENT, PROJECT_TITLE VARCHAR(100) NOT NULL, PROJECT_DESCRIPTION VARCHAR(500), PROJECT_CATEGORY VARCHAR(200) NOT NULL, PROJECT_GLOBAL_BUSINESS VARCHAR(40), PROJECT_COUNTRY VARCHAR(40), PROJECT_PLANNED_FINISH_DATE VARCHAR(40), PROJECT_FUND_REQUIRED INT DEFAULT 0, PROJECT_FUND_RECEIVED INT DEFAULT 0, USER_ID VARCHAR(20) NOT NULL, PROJECT_MY_FUND INT DEFAULT 0, VIDEO_URL VARCHAR(500), PRIMARY KEY (PROJECT_ID, USER_ID))";
		String ddlFunding = "CREATE TABLE FUNDING(USER_ID VARCHAR(20) NOT NULL, PROJECT_ID INT NOT NULL, FUND_ADDED INT DEFAULT 0)";
		
		String insertUser1 = "INSERT INTO USERPROFILE VALUES ('kevin', 'kevin', 'Kevin','Goodbody', 'MANAGER', 'kevin.goodbody@xyz.com')";
		String insertUser2 = "INSERT INTO USERPROFILE VALUES ('peter', 'peter', 'Peter','Clark', 'COO', 'peter.clark@xyz.com')";
		String insertUser3 = "INSERT INTO USERPROFILE VALUES ('chris', 'chris', 'Chris','Rogers', 'CENTER HEAD', 'chris.rogers@xyz.com')";
		String insertUser4 = "INSERT INTO USERPROFILE VALUES ('david', 'david', 'David','Kolb', 'HEAD DEPT', 'david.kolb@gmail.com')";
		String insertUser5 = "INSERT INTO USERPROFILE VALUES ('christophe', 'christophe', 'Christophe','Chazot', 'GROUP HEAD', 'christophe.chazot@xyz.com')";
		String insertUser6 = "INSERT INTO USERPROFILE VALUES ('manjula', 'manjula', 'Manjula','Muthukrishnan', 'REGION HEAD', 'manjula.muthukrishnan@xyz.com')";
		String insertUser7 = "INSERT INTO USERPROFILE VALUES ('sateen', 'sateen', 'Sateen','Bailur', 'DEPT HEAD', 'sateen.bailur@xyz.com')";
		String insertUser8 = "INSERT INTO USERPROFILE VALUES ('devesh', 'devesh', 'Devesh','Rana', 'DEPT HEAD', 'devesh.rana@xyz.com')";
		String insertUser9 = "INSERT INTO USERPROFILE VALUES ('patrick', 'patrick', 'Patrick','Mang', 'LEAD', 'patrick.mang@xyz.com')";
		String insertUser10 = "INSERT INTO USERPROFILE VALUES ('andy', 'andy', 'Andy','Manguire', 'OPERATING OFFICER', 'andy.maguire@xyz.com')";
		String insertUser11 = "INSERT INTO USERPROFILE VALUES ('mangesh', 'mangesh', 'Mangesh','Paunikar', 'SCRUM MASTER', 'mangesh.paunikar@xyz.com')";
		
		String insertProject1 = "INSERT INTO PROJECT (PROJECT_TITLE,PROJECT_DESCRIPTION,PROJECT_CATEGORY,PROJECT_GLOBAL_BUSINESS,PROJECT_COUNTRY,PROJECT_PLANNED_FINISH_DATE,PROJECT_FUND_REQUIRED,PROJECT_FUND_RECEIVED,USER_ID,PROJECT_MY_FUND,VIDEO_URL) " +
				"VALUES ('Fund IT', 'A simple collaboration tool for business and IT to log their investment priorities at any point in time. Pledge funding and endorse their investments.', 'Business', 'Investment', 'INDIA', '08/25/2016', 100000, 10000, 'kevin', 10000, 'https://youtu.be/8b5-iEnW70k')"; 
		String insertProject2 = "INSERT INTO PROJECT (PROJECT_TITLE,PROJECT_DESCRIPTION,PROJECT_CATEGORY,PROJECT_GLOBAL_BUSINESS,PROJECT_COUNTRY,PROJECT_PLANNED_FINISH_DATE,PROJECT_FUND_REQUIRED,PROJECT_FUND_RECEIVED,USER_ID,PROJECT_MY_FUND,VIDEO_URL) " +
				" VALUES ('Pay Me Now', 'A simple multi-social payment application, that can be used by Bank customers, that lets them send/ask for money or simply recharge their mobile.', 'Business', 'Investment', 'UAE', '04/17/2016', 100000, 10000, 'devesh', 10000, 'https://youtu.be/iUYdEUWtYg0')";
		String insertProject3 = "INSERT INTO PROJECT (PROJECT_TITLE,PROJECT_DESCRIPTION,PROJECT_CATEGORY,PROJECT_GLOBAL_BUSINESS,PROJECT_COUNTRY,PROJECT_PLANNED_FINISH_DATE,PROJECT_FUND_REQUIRED,PROJECT_FUND_RECEIVED,USER_ID,PROJECT_MY_FUND,VIDEO_URL) " +
				"VALUES ('Reward Our Best', 'Crowdsourcing for employees using a portal to enable employees to find and create opportunities.', 'Business', 'Private', 'CANADA', '09/01/2016', 100000, 80000, 'peter', 80000, 'https://youtu.be/l0y9LPl8Uuw')";
		String insertProject4 = "INSERT INTO PROJECT (PROJECT_TITLE,PROJECT_DESCRIPTION,PROJECT_CATEGORY,PROJECT_GLOBAL_BUSINESS,PROJECT_COUNTRY,PROJECT_PLANNED_FINISH_DATE,PROJECT_FUND_REQUIRED,PROJECT_FUND_RECEIVED,USER_ID,PROJECT_MY_FUND,VIDEO_URL) " +
				"VALUES ('On Demand Tools', 'When an employee is on boarded to Bank, they receive their technology configured based on role. A software portal where you could download/rent software on demand with no wait time or middle person.', 'Business', 'Commercial', 'HONG KONG', '05/10/2016', 100000, 20000, 'manjula', 20000, 'https://youtu.be/VYFD19jAnAc')";
		String insertProject5 = "INSERT INTO PROJECT (PROJECT_TITLE,PROJECT_DESCRIPTION,PROJECT_CATEGORY,PROJECT_GLOBAL_BUSINESS,PROJECT_COUNTRY,PROJECT_PLANNED_FINISH_DATE,PROJECT_FUND_REQUIRED,PROJECT_FUND_RECEIVED,USER_ID,PROJECT_MY_FUND,VIDEO_URL) " +
				"VALUES ('Got PIN?', 'A global way to get card PINs to customers and maintain them via smart phones - no more mails!', 'Business', 'Retail', 'UNITED STATES', '09/16/2016', 100000, 60000, 'chris', 60000, 'https://youtu.be/zbB2EXtZl44')";
		String insertProject6 = "INSERT INTO PROJECT (PROJECT_TITLE,PROJECT_DESCRIPTION,PROJECT_CATEGORY,PROJECT_GLOBAL_BUSINESS,PROJECT_COUNTRY,PROJECT_PLANNED_FINISH_DATE,PROJECT_FUND_REQUIRED,PROJECT_FUND_RECEIVED,USER_ID,PROJECT_MY_FUND,VIDEO_URL) " +
				"VALUES ('People@Bank', 'Global resource organization across all business lines to achieve our efficiency and transformation goals.', 'Business', 'Private', 'UNITED KINGDOM', '10/12/2016', 100000, 10000, 'mangesh', 10000, 'https://youtu.be/-QcHVDyQdvI')";
		Statement pstmt = null;
		try {
			pstmt = dataSource.getConnection().createStatement();
			pstmt.addBatch(dropUserProfiletable);
			pstmt.addBatch(dropProjecttable);
			pstmt.addBatch(dropFundingtable);
			
			pstmt.addBatch(ddlUserProfile);
			pstmt.addBatch(ddlProject);
			pstmt.addBatch(ddlFunding);
			
			pstmt.addBatch(insertUser1);
			pstmt.addBatch(insertUser2);
			pstmt.addBatch(insertUser3);
			pstmt.addBatch(insertUser4);
			pstmt.addBatch(insertUser5);
			pstmt.addBatch(insertUser6);
			pstmt.addBatch(insertUser7);
			pstmt.addBatch(insertUser8);
			pstmt.addBatch(insertUser9);
			pstmt.addBatch(insertUser10);
			pstmt.addBatch(insertUser11);
			pstmt.addBatch(insertProject1);
			pstmt.addBatch(insertProject2);
			pstmt.addBatch(insertProject3);
			pstmt.addBatch(insertProject4);
			pstmt.addBatch(insertProject5);
			pstmt.addBatch(insertProject6);
			pstmt.executeBatch();
			System.out.println("Table created and record inserted...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
