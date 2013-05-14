package com.wordpress.bgiorev.sqliteTry.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OpeningTable {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			String s = "Bojidar";
			String s1 = "'" + s + "'";
			ResultSet rs = statement.executeQuery("select * from person where name like " + s1);
			while(rs.next()) {
				System.out.println("number = " + rs.getString("number"));
				System.out.println("name = " + rs.getString("name"));
			}
		} catch (SQLException e) {
			System.err.println(e);
			e.printStackTrace();
		}finally{
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
