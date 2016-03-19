package org.meanturtle.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author rithvikgopishelke
 *
 */
public class DatabaseAssertion {

	
	/**
	 * 
	 * @param connectionURL
	 * @param userName
	 * @param password
	 * @param sql
	 * @param expectedValue
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * This is a count(*) query that will take the above mentioned params and return true if it matches expected value
	 */
	public boolean assertDatabaseCount(String connectionURL,String userName, String password,String sql,Integer expectedValue) throws ClassNotFoundException,	SQLException {
			
	// Create Oracle Connection
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(connectionURL,userName,password);
	Statement stat = con.createStatement();
	ResultSet rs =  stat.executeQuery(sql);
	rs.next();
	Integer result = rs.getInt(1);
	if(result.compareTo(expectedValue) == 0)
		return true;
	else
		return false;
	}
	
	
	public boolean assertDatabaseInteger(String connectionURL,String userName, String password,String sql,Integer expectedValue) throws ClassNotFoundException, SQLException {
		// Create Oracle Connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(connectionURL,userName,password);
		Statement stat = con.createStatement();
		ResultSet rs =  stat.executeQuery(sql);
		rs.next();
		Integer result = rs.getInt(1);
		if(result.compareTo(expectedValue) == 0)
			return true;
		else
			return false;
	}
	
	public boolean assertDatabaseString(String connectionURL,String userName, String password,String sql,String expectedValue, Boolean ignoreCase) throws ClassNotFoundException, SQLException {
		// Create Oracle Connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(connectionURL,userName,password);
		Statement stat = con.createStatement();
		ResultSet rs =  stat.executeQuery(sql);
		rs.next();
		String result = rs.getString(1);
		if(ignoreCase && result.compareToIgnoreCase(expectedValue) == 0)
			return true;
		else if(!ignoreCase && result.compareTo(result) == 0)
			return true;
		else
			return false;
	}

	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatabaseAssertion da = new DatabaseAssertion();
		Boolean result = da.assertDatabaseCount("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=somehost)", "abc", "abc", "select count(*) from orc_def",25);
		System.out.println(result);
	}*/
}
