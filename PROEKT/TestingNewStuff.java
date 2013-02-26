package com.wordpress.bgiorev.sqliteTry.code;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestingNewStuff {
	public static void main(String[] args) throws ClassNotFoundException {
		DateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(dateFormat.format(calendar.getTime()));
		
		Diary diary = new Diary();
		Meal m = diary.searchMeal("лайна", 10);
		if(m == null) {
			System.out.println("The meal wasn't found");
		}
		m = diary.searchMeal("shit", 100);
		diary.saveTodaysMeals();
		System.out.println("Finished");
		diary.showTodaysSavedCalc();
	}
}
