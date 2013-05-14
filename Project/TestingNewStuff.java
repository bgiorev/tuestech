package com.wordpress.bgiorev.sqliteTry.code;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class TestingNewStuff {
	public static void main(String[] args) throws ClassNotFoundException {
		Diary diary = new Diary();
		Meal m = diary.searchMeal("Агнешки-език суров", 300);
		if(m == null) {
			System.out.println("The meal wasnot found");
		}
		
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date todayDate = new Date();
		String s = "Agneshko-vareno";
	
		String date = dateFormat.format(todayDate);
		ArrayList<Meal> mealList = diary.findEatenMealsByDate(date);
		if(mealList.size()>0) {
			for(Meal meal : mealList) {
				System.out.println(meal.getName());
			}
		}
		
	}
}
