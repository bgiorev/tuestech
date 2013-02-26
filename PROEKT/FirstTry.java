package com.wordpress.bgiorev.sqliteTry.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstTry {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/sample.db");
			
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists meal");
			statement.executeUpdate("create table meal(name string, calories real, carbs int, protein int, fat int)");
			statement.executeUpdate("insert into meal values ('shit', 16.7, 1, 1, 1)");
			statement.executeUpdate("insert into meal values('лайна',10,2,3,4)");
			
			System.out.println("Finished");
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		} finally
	    {
		      try
		      {
		        if(connection != null)
		          connection.close();
		      }
		      catch(SQLException e)
		      {
		        // connection close failed.
		        System.err.println(e);
		      }
		    }
	}
}
