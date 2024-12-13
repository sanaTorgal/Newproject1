package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility1 {

	Connection con = null;

	public void getDataBaseconnection(String url, String username, String password) throws Throwable {
		try {

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

		}
	}


	

	public void closeConnection() throws SQLException {
		con.close();
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			result = stat.executeQuery(query);

		} catch (Exception e) {

		}
		return result;
	}

	   public int executenNonSelectQuery(String query)
	   {
		   int result1 = 0;
		   try {
			   Statement stat = con.createStatement();
			   result1 = stat.executeUpdate(query);
		   } catch (Exception e) {

		   }
		   return result1;

	   }
}
