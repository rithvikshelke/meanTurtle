package org.meanturtle.main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.ibatis.jdbc.ScriptRunner;

 
/**
 *This class allows for connecting to oracle database and running a script file 
 * ScriptFile - contains sql statements that are to be executed
 *
 *@author rithvikshelke
 *
 *
 */
public class ScriptFileExec {
	
	
	/***
	 * 
	 * @param scriptPath
	 * @param connectionURL
	 * @param userName
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void connectAndExecuteScript(String scriptPath,String connectionURL,String userName, String password) throws ClassNotFoundException,
		SQLException {
 
		
		// Create Oracle Connection
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(connectionURL,userName,password);
		
 
		try {
			// Initialize object for ScripRunner
			ScriptRunner sr = new ScriptRunner(con);
 
			// Give the input file to Reader
			Reader reader = new BufferedReader(
                               new FileReader(scriptPath));
 
			// Execute script
			sr.runScript(reader);
 
		} catch (Exception e) {
			System.err.println("Failed to Execute" + scriptPath
					+ " The error is " + e.getMessage());
		}
	}
}