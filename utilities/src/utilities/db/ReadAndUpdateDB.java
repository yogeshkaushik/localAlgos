package utilities.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.socialtwist.common.security.pii.IPIISecurityInfo;
import com.socialtwist.common.security.pii.PIISecurityHelper;
import com.socialtwist.common.security.pii.loyalty.LoyaltyPIISecurityInfo;
import com.socialtwist.util.exceptions.STSecurityException;

public class ReadAndUpdateDB {

	//key : E5vfYiIXyM6mVvo2;
	//new String[] {"E5vfYiIXyM6mVvo2", "loyalty_core_0000000000", "root", "sh*pp@r"};
	private static final String GET_QUERY = "SELECT USER_ID, FIRST_NAME, LAST_NAME FROM CHATBOT_USER_PROFILES";
	private static final String UPDATE_QUERY = "UPDATE CHATBOT_USER_PROFILES SET FIRST_NAME = ?, LAST_NAME = ? WHERE USER_ID = ?";
	private static final String USER_ID = "USER_ID";
	private static final String F_NAME = "FIRST_NAME";
	private static final String L_NAME = "LAST_NAME";
	
	static IPIISecurityInfo piiSecurityInfo;
	static PIISecurityHelper piiHelper;

	private static String host;
	static String dbName = "loyalty_core_";
	private static String userName;
	private static String password;
	
	public static void main(String[] args) throws SQLException {
		if (args.length < 5) {
			System.out.println("To Run this Script, we must pass P2Security Key, hostName, customerId, username and password as argument.");
			return;
		}
		String key = null;
		try {
			key = args[0];
			host = args[1];
			dbName += args[2];
			userName = args[3];
			password = args[4];
		} catch (Throwable t) {
			System.out.println("*********** ERROR : args passed are not correct ***********");
		}
		
		System.out.println("Passed Key");
		
		piiSecurityInfo = new LoyaltyPIISecurityInfo();
        piiHelper = PIISecurityHelper.init(key, piiSecurityInfo);
		readAndUpdate();
	}
	
	static void readAndUpdate() throws SQLException {
		System.out.println("Loading Classes.....");
		Connection conn = null;
		PreparedStatement updatePS = null;
		PreparedStatement getPS = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/"+dbName, userName, password);
			System.out.println("Connected to the database");
			
			updatePS = conn.prepareStatement(UPDATE_QUERY);
			
			System.out.println("Query the DB : " + dbName);
			getPS = conn.prepareStatement(GET_QUERY);
			ResultSet rs = getPS.executeQuery();
			while (rs.next()) {
				String userId = rs.getString(USER_ID);
				String fName = rs.getString(F_NAME);
				String lName = rs.getString(L_NAME);
				int i=1;
				updatePS.setString(i++, encryptData(fName));
				updatePS.setString(i++, encryptData(lName));
				updatePS.setString(i++, userId);			
				updatePS.addBatch();
				System.out.println("Added update to Batch for USER_ID : " + userId);
			}
			updatePS.executeBatch();
		} catch (ClassNotFoundException e) {
			System.out.println("************* ERROR : Couldn't load JDBC Driver **************" + e);
		} catch (SQLException e1) {
			System.out.println("************* ERROR : SQLException occured **************" + e1);
		} finally {
			if (getPS == null) getPS.close();
			if (updatePS == null) updatePS.close();
			if (conn == null) conn.close();
		}
		System.out.println("############ SUCCESSFULLY UPDATED THE DB ###########");
	}
	
	@SuppressWarnings("static-access")
	private static String encryptData(String data) {
		try {
			return piiHelper.getInstance().encrypt(data);
		} catch (STSecurityException e) {
			System.out.println("***********ERROR : Unable to encrypt*********** => "+data);
			return null;
		}
	}
}
