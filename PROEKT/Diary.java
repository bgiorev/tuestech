package com.wordpress.bgiorev.sqliteTry.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diary {
	private DailyMeals dailyMeals = new DailyMeals();
	
	public Meal searchMeal(String name, int amount) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		ResultSet rs;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/sample.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			String s = "'" + name + "'";
			System.out.println(s);
			try {
				rs = statement.executeQuery("select * from meal where name like "  + s);
				Meal meal = new Meal(rs.getString("name"), Double.parseDouble(rs.getString("calories"))*amount , Integer.parseInt(rs.getString("carbs"))*amount,
						Integer.parseInt(rs.getString("protein"))*amount, Integer.parseInt(rs.getString("fat"))*amount);
				dailyMeals.addMeal(meal);
				return meal;
			} catch(SQLException e) {
				return null;
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
		return null;
	}

	public void saveTodaysMeals() throws ClassNotFoundException {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/" + todayDate + ".db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate("drop table if exists meal");
			statement.executeUpdate("create table meal(name string, calories integer, carbs integer, protein integer, fat integer)");
			for(Meal m : dailyMeals.getMealList()) {
				statement.executeUpdate("insert into meal values(" + "'" +  m.getName() + "'" + ", " + m.getCalories() + ", " 
										+ m.getCarbs() + ", " + m.getProtein() + ", " + m.getFat() + ")");
			}
			statement.executeUpdate("insert into meal values(" + "'Daily Meals'" + "," + dailyMeals.getAllCalories() + ", " + dailyMeals.getAllCarbs() + ", "
									+ dailyMeals.getAllProtein() + ", " + dailyMeals.getAllFat() + ")");
		} catch (SQLException e) {
			System.out.println("Cant save dailyMeals");
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
	
	public void showTodaysSavedCalc() throws ClassNotFoundException {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/" + todayDate + ".db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			ResultSet rs = statement.executeQuery("select * from meal where name like 'Daily Meals'");
			while(rs.next()) {
				System.out.println("Today Calories = " + rs.getString("calories"));
				System.out.println("Today Carbs = " + rs.getString("carbs"));
				System.out.println("Today Protein = " + rs.getString("protein"));
				System.out.println("Today Fat = " + rs.getString("fat"));
			}
		}catch (SQLException e) {
			
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
