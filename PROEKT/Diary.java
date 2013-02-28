package com.wordpress.bgiorev.sqliteTry.code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Diary {
	private DailyMeals dailyMeals = new DailyMeals();
	private int mealsID = 0;
	private int daysID = 0;
	
	
	public Meal searchMeal(String name, int amount) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		ResultSet rs;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/Data.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			String s = "'" + name + "'";
			System.out.println(s);
			try {
				rs = statement.executeQuery("select * from Data where name like " + s);
				System.out.println("------------------------" + rs.getString("name"));
				
				Meal meal = new Meal(rs.getString("name"), rs.getDouble("calories"), rs.getDouble("carbs"), rs.getDouble("proteins"), rs.getDouble("fat"));
				
				dailyMeals.addMeal(meal);
				saveMeal(meal);
				System.out.println("----------------------------------------");
				System.out.println(meal.getName());
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

	private void saveMeal(Meal m) throws ClassNotFoundException {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/savedMeals.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			ResultSet rs = statement.executeQuery("select * from meals where name like " + "'" + m.getName() + "'");
			if(rs.next()){
				mealsID = rs.getInt("id");
			}else{
				statement.executeUpdate("insert into meals values(" + null + ", " + "'" + m.getName() + "'" + ", " + m.getCalories() 
						+ ", " + m.getCarbs() + ", " + m.getProtein() + ", " + m.getFat() + ")");
				rs = statement.executeQuery("select * from meals where name like " + "'" + m.getName() + "'");
				mealsID = rs.getInt("id");
			}
			
			
			rs = statement.executeQuery("select * from days where date like " + todayDate);
			if(rs.next()) {
				daysID = rs.getInt("id");
			}else{
				statement.executeUpdate("insert into days values(" + null + ", " + "'" + todayDate  + "'"  +")");
				rs = statement.executeQuery("select * from days where date like " + todayDate);
				daysID = rs.getInt("id");
			}
			
			statement.executeUpdate("insert into linkingTable values(" + null + ", " + mealsID + ", " + daysID + ")");
			
			 
		} catch (SQLException e) {
			System.out.println("Cant save dailyMeals");
			e.printStackTrace();
		}finally{
			try {
				if(connection!=null)
				connection.close();
				daysID = 0;
				mealsID = 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public ArrayList<Meal> findEatenMealsByDate(String date) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		ArrayList<Meal> mealsList = new ArrayList<Meal>();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:D:/Uchilishte/programi/com.wordpress.bgiorev.sqliteTry/savedMeals.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			ResultSet rs = statement.executeQuery("select * from days where date like " + date);
			if(rs.next()) {
				daysID = rs.getInt("id");
			}else{
				System.out.println("Try another day :)");
			}
			
			ArrayList<Integer> mealsIDs = new ArrayList<Integer>();
			rs = statement.executeQuery("select * from linkingTable where id_days like " + daysID);
			while(rs.next()) {
				System.out.println(rs.getInt("id_meals"));
				mealsIDs.add(rs.getInt("id_meals"));
			}
			
			for(int i : mealsIDs) {
				rs = statement.executeQuery("select * from meals where id like " + i);
				while(rs.next()) {
					mealsList.add(new Meal(rs.getString("name"), rs.getDouble("calories"), rs.getDouble("carbs"), rs.getDouble("protein"), rs.getDouble("fat")));
				}
			}
			
			 
		} catch (SQLException e) {
			System.out.println("Search failed");
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
		return mealsList;
	}

	
}
