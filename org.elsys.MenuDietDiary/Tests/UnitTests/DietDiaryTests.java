package UnitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Diary.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;

public class DietDiaryTests {
	
	private Diary d;
	private Meal m;
	private String testDate;
	private BodyCalculator bc;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	ResultSet rs;
	Connection con=null;
	@Before
	public void setUp() throws ClassNotFoundException{
		
		Class.forName("org.sqlite.JDBC");
		
		
		d=new Diary();
		d.loadCalculator("Kiril Mitov");
		m = new Meal("test", 0, 0, 0, 0);
		testDate="12/04/2013";
		bc = new BodyCalculator("name",180,75,20,"мъж",3,"Задържа");
	}
	
	@Test
	public void testDiaryGetAllProducts() throws ClassNotFoundException {
		assertEquals(d.getAllProducts()[0],"Агнешки-мозък суров");
	}
	
	@Test
	public void testDiarySearchProduct() throws ClassNotFoundException{
		Meal m = d.searchMeal("Агнешки-мозък суров",100,"12/04/2013");
		assertEquals(m.getName(),"Агнешки-мозък суров");
		assertEquals(m.getCalories(),122.0,0.00);
		assertNull(d.searchMeal("asd", 10, testDate));
		d.deleteMeal(m, testDate);
	}
	
	@Test
	public void testDiarySaveMeal() throws ClassNotFoundException{
		
		d.saveMeal(m,testDate);
		
		int mealId=0;
		int dayId=0;
		
		try {
			con=DriverManager.getConnection("jdbc:sqlite:Kiril Mitov-savedMeals.db");
			Statement statement = con.createStatement();
			
			rs=statement.executeQuery("select * from meals where name like "+"'"+m.getName()+"'");
			if(rs.next()){
				mealId=rs.getInt("id");
			}
			rs=statement.executeQuery("select * from days where date like "+"'"+testDate+"'");
			if(rs.next()){
				dayId=rs.getInt("id");
			}
			
			rs=statement.executeQuery("select * from linkingTable where mealsID="+"'"+mealId+"'"+" and daysID="+"'"+dayId+"'");
			assertTrue(rs.next());
			
			//close connection -> otherwise the database will be locked when d.saveMeal() is called
			con.close();
			Meal m1 = new Meal("test", 1, 1, 1, 1);
			d.saveMeal(m1, testDate);
			
			con = DriverManager.getConnection("jdbc:sqlite:Kiril Mitov-savedMeals.db");
			statement = con.createStatement();
			rs = statement.executeQuery("select * from meals where name like "+"'"+m1.getName()+"'");
			assertEquals(rs.getInt("carbs"),1);
			assertEquals(rs.getInt("calories"),1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("cant close con");
			}
		}
		
		
		
		
	}
	
	@Test
	public void testDiaryFindEatenByDate() throws ClassNotFoundException{
		
		ArrayList<Meal> a = d.findEatenMealsByDate(testDate);
		assertEquals(a.size(),1);
	}

	@Test
	public void testDiaryDeleteMeal() throws ClassNotFoundException{
		d.deleteMeal(m,testDate);
		
		/*Class.forName("org.sqlite.JDBC");
		ResultSet rs;
		Connection con=null;*/
		int mealId=0;
		int dayId=0;
		try {
			con=DriverManager.getConnection("jdbc:sqlite:Kiril Mitov-savedMeals.db");
			Statement statement = con.createStatement();
			rs = statement.executeQuery("select meals.*, days.date,days.id from meals join linkingTable on meals.id = linkingTable.mealsID and meals.name =" +"'"+m.getName()+"'" + " join days on linkingTable.daysID = days.id and days.date = " +"'"+testDate+"'");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("cant close con");
			}
		}
		
	}
	
	private boolean selectNameFromCalculator(String name){
		boolean retVal=false;
		try {
			con=DriverManager.getConnection("jdbc:sqlite:calculator.db");
			Statement statement = con.createStatement();
			rs = statement.executeQuery("select * from calculator where name like " +"'"+name+"'");
			if(rs.next()){
				retVal=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//System.out.println("cant close con");
				
			}
		}
		
		return retVal;
	}
	
	@Test
	public void testDiarySaveCalc() throws ClassNotFoundException{
		d.saveCalculator(bc);
		assertTrue(selectNameFromCalculator(bc.getName()));
		
		BodyCalculator a = new BodyCalculator("name2",180,75,20,"жена",5,"Кача");
		d.saveCalculator(a);
		assertTrue(selectNameFromCalculator(a.getName()));
		d.deleteCalculator(a.getName());
		
		a = new BodyCalculator("name3",180,75,20,"мъж",7,"Задържа");
		d.saveCalculator(a);
		assertTrue(selectNameFromCalculator(a.getName()));
		d.deleteCalculator(a.getName());
	}
	
	@Test
	public void testDiaryGetAllUsers(){
		try {
			ArrayList<String> a = d.getAllUsers();
			assertEquals(a.get(2),"name");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Test 
	public void testDiaryDeleteCalc() throws ClassNotFoundException{
		d.deleteCalculator(bc.getName());
		assertFalse(selectNameFromCalculator(bc.getName()));
	}
	
	@Test
	public void testDBrowser(){
		DBrowser b = new DBrowser();
		Display d = Display.getDefault();
		Shell sh = new Shell();
		b.Start( d, sh);
		
	}
	
}
