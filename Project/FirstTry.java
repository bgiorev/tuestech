package com.wordpress.bgiorev.sqliteTry.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstTry {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		Connection savedConnection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/sample.db");
			savedConnection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/savedMeals.db");
			
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists meal");
			statement.executeUpdate("create table meal(name string, calories real, carbs real, protein real, fat real)");
			statement.executeUpdate("insert into meal values ('bob', 16.7, 1, 1, 1)");
			statement.executeUpdate("insert into meal values('лайна',10,2,3,4)");
			statement.executeUpdate("insert into meal values('shit', 10,15,20,25)");
			
		/*	statement = savedConnection.createStatement();
			statement.executeUpdate("drop table if exists meals");
			statement.executeUpdate("create table meals(id integer primary key, name text, calories real, carbs real, protein real, fat real)");
			
			statement.executeUpdate("drop table if exists days");
			statement.executeUpdate("create table days(id integer primary key, date text)");
			
			statement.executeUpdate("drop table if exists linkingTable");
			statement.executeUpdate("create table linkingTable(id integer primary key, id_meals integer, id_days integer)");*/
			System.out.println("Finished");
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		} finally
	    {
		      try
		      {
		        if(connection != null && savedConnection != null)
		        	connection.close();
		        	savedConnection.close();
		      }
		      catch(SQLException e)
		      {
		        // connection close failed.
		        System.err.println(e);
		      }
		    }
	}
}
