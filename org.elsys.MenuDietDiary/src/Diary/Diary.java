package Diary;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Diary {
	private int mealsID = 0;
	private int daysID = 0;
	private String username;
	
	private double convert(double d){													//Converting double to some format
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setDecimalSeparator('.');
		d/=100.0;
		DecimalFormat df = new DecimalFormat("#.##",symbols); 
		return  Double.valueOf(df.format(d));
	}
		
	public static String[] getAllProducts() throws ClassNotFoundException{				//Method that is used for the auto complete
		Class.forName("org.sqlite.JDBC");
		ArrayList<String> names = new ArrayList<String>();
		Connection connection = null;
		ResultSet rs;
		try{
			connection = DriverManager.getConnection("jdbc:sqlite:Data.db");
			Statement st=connection.createStatement();
			rs=st.executeQuery("select name from Data");
			while(rs.next()){
			names.add(rs.getString("name"));
			}
		}catch(SQLException e){
			System.err.println(e);
			
		}finally{
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return names.toArray(new String[names.size()]);
	}
	
	public Meal searchMeal(String name, int amount,String date) throws ClassNotFoundException {		//Searching meal in the database of foods		
		
		
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		ResultSet rs;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Data.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			String s = "'" + name + "'";
			
			try {
				rs = statement.executeQuery("select * from Data where name like " + s);
				Meal meal = new Meal(rs.getString("name"), amount*convert(rs.getDouble("calories")), amount*convert(rs.getDouble("carbs")), 
										amount*convert(rs.getDouble("proteins")), amount*convert(rs.getDouble("fat")));
				saveMeal(meal,date);
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

	public void saveMeal(Meal m,String date) throws ClassNotFoundException {						//Saving meal in database file
		
		System.out.println("saveMeal date="+date);
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + username + "-savedMeals.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			
			//create neccessary tables
			statement.executeUpdate("create table if not exists meals(id integer primary key, name text, calories real, carbs real, protein real, fat real)");
			statement.executeUpdate("create table if not exists days(id integer primary key, date text)");
			statement.executeUpdate("create table if not exists linkingTable(id integer primary key, mealsID integer, daysID integer)");
			
			//ResultSet rs = statement.executeQuery("select *  from meals where name like " + "'" + m.getName() + "'");
			//alex
			
			ResultSet rs = statement.executeQuery("select * from days where date like " +"'"+date+"'" );
			
			if(rs.next()) {
				daysID = rs.getInt("id");
			
			}else{
				statement.executeUpdate("insert into days values(" + null + ", " + "'" + date  + "'"  +")");
				ResultSet rs1 = statement.executeQuery("select * from days where date like "  +"'"+date+"'");
				if(rs1.next())
				daysID = rs1.getInt("id");
				
				
			}
			
			rs = statement.executeQuery("select meals.*, days.date,days.id from meals join linkingTable on meals.id = linkingTable.mealsID and meals.name =" +"'"+m.getName()+"'" + " join days on linkingTable.daysID = days.id and days.date = " +"'"+date+"'");
			//int dateId = rs.getInt("8");
			//System.out.println("dateid= "+dateId);
			//ResultSet rs1 = statement.executeQuery("select days.* from days join linkingTable on days.id = linkingTable.daysID and linkingTable.mealsID = "+"'"+mealsID+"'");
			//ResultSet rs = statement.executeQuery("select meals.* from meals join linkingTable on linkingTable.daysID = "+"'"+dateId+"'" + "and meals.name = " + "'"+m.getName()+"'"+" and linkingTable.mealsID = meals.id" );
			
			if(rs.next()){
				mealsID = rs.getInt(1);
				System.out.println("mealsId= "+mealsID);
				//update existing meals
				statement.executeUpdate("update meals set " 
							+"calories=calories+"+"'"+m.getCalories()+"'"+", "  
							+"carbs=carbs+"  +"'"+m.getCarbs()+"'"+", "
							+"protein=protein+"+ "'"+m.getProtein()+"'"+", "
							+"fat=fat+"+"'"+m.getFat()+"'"
							+"where id="+"'"+mealsID+"'" 
							
				);
			}else{
				System.out.println("asd");
				statement.executeUpdate("insert into meals values(" + null + ", " + "'" + m.getName() + "'" + ", " + m.getCalories() 
						+ ", " + m.getCarbs() + ", " + m.getProtein() + ", " + m.getFat() + ")");
				System.out.println("asd");
				rs = statement.executeQuery("select meals.* from meals where name like "+"'"+m.getName()+"'"+" order by id desc limit 1");
				mealsID = rs.getInt("id");
			}
			
			
			
			
			rs=statement.executeQuery("select * from linkingTable where mealsID like "+"'"+mealsID+"'");
			if(!rs.next())
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

	public void deleteMeal(Meal m, String date) throws ClassNotFoundException {			//Deleting meal from the saved meals database
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + username + "-savedMeals.db");
			Statement statement = connection.createStatement();
			int mealID = 0, dayID = 0;
			
			ResultSet rs = statement.executeQuery("select meals.*, days.date,days.id from meals join linkingTable on meals.id = linkingTable.mealsID and meals.name =" +"'"+m.getName()+"'" + " join days on linkingTable.daysID = days.id and days.date = " +"'"+date+"'");
			if(rs.next()){
				mealID = rs.getInt(1);
				dayID = rs.getInt(8);
				
				statement.executeUpdate("delete from linkingTable where mealsID like "+"'"+mealID+"'"+" and daysID like "+"'"+dayID+"'");
				statement.executeUpdate("delete from meals where id like "+"'"+mealID+"'");
				
			}
			/*ResultSet rs = statement.executeQuery("select * from meals where name like " + "'" + m.getName() + "'");
			if(rs.next())
				mealID = rs.getInt("id");
			rs = statement.executeQuery("select * from days where date like " + "'" + date + "'");
			if(rs.next())
				dayID = rs.getInt("id");
			statement.executeUpdate("delete from linkingTable where mealsID like " + mealID + " and daysID like " + dayID);
			statement.executeUpdate("delete from meals where id like "+"'"+mealID+"'");*/
		} catch (SQLException e) {
			System.out.println("The couldnt be deleted");
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
	
	public ArrayList<Meal> findEatenMealsByDate(String date) throws ClassNotFoundException {	//Searching all foods eaten in some day
		ArrayList<Meal> mealList = new ArrayList<Meal>();
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + username + "-savedMeals.db");
			Statement statement = connection.createStatement();
			statement.executeUpdate("create table if not exists meals(id integer primary key, name text, calories real, carbs real, protein real, fat real)");
			statement.executeUpdate("create table if not exists days(id integer primary key, date text)");
			statement.executeUpdate("create table if not exists linkingTable(id integer primary key, mealsID integer, daysID integer)");
			ResultSet rs = statement.executeQuery("select * from days where date like " + "'" + date + "'");
			int dayID = 0;
			if(rs.next()){
				dayID = rs.getInt("id");
			}
			rs = statement.executeQuery("select * from linkingTable where daysID like " + dayID);
			ArrayList<Integer> meals = new ArrayList<Integer>();
			Meal m = null;
			while(rs.next()) {
				meals.add(rs.getInt("mealsID"));
			}

			for(int i : meals){
				rs = statement.executeQuery("select * from meals where id like " + i);
				m = new Meal(rs.getString("name"),rs.getDouble("calories"), rs.getDouble("carbs"), rs.getDouble("protein"), rs.getDouble("fat"));
				mealList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mealList;
	}
	
	public void saveCalculator(BodyCalculator bc) throws ClassNotFoundException {		//Saving BodyCalculator
		username = bc.getName();
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:calculator.db");
			Statement statement = connection.createStatement();
			statement.executeUpdate("create table if not exists calculator(id integer primary key, name string,height int, weight int, age int, " +
									"gender string, physicalActivity int, dietPerpose string)");
			ResultSet rs = statement.executeQuery("select * from calculator where name like " + "'" + username + "'");
			if(!rs.next())
				statement.executeUpdate("insert into calculator values(" + null + ", " + "'" + bc.getName() + "'" + ", " + bc.getHeight() + ", " + bc.getWeight() + ", " 
									+ bc.getAge() + ", " + "'" + bc.getGender() + "'" + ", " + bc.getPhysicalActivity() + ", " + "'" + bc.getDietPerpose() + "'" + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public BodyCalculator loadCalculator(String name) throws ClassNotFoundException {				//Loading BodyCalculator from the database with calculators
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		BodyCalculator bc = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:calculator.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from calculator where name like " + "'" + name + "'");
			
			if(rs.next()) {
				bc = new BodyCalculator(name, rs.getInt("height"), rs.getInt("weight"), rs.getInt("age"),
						rs.getString("gender"), rs.getInt("physicalActivity"), rs.getString("dietPerpose"));
			}
			username = bc.getName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bc;
	}

	public void deleteCalculator(String name) throws ClassNotFoundException {			//Delete BodyCalculator from the database with calculators
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:calculator.db");
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from calculator where name like " + "'" + name + "'");
			File file = new File(name+"-savedMeals.db");
			file.delete();
		} catch (SQLException e) {
			System.out.println("Problem with calculator delete");
			e.printStackTrace();
		}finally{
			try {
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public ArrayList<String> getAllUsers() throws ClassNotFoundException {
		ArrayList<String> userList = new ArrayList<String>();
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:calculator.db");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from calculator");
			while(rs.next())
				userList.add(rs.getString("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}
}

// 12/04/2013