package com.wordpress.bgiorev.sqliteTry.code;

import java.util.ArrayList;

public class DailyMeals{
	private ArrayList<Meal> mealList;
	private double allCalories;
	private double allCarbs;
	private double allProtein;
	private double allFat;
	
	public ArrayList<Meal> getMealList() {
		return mealList;
	}
	
	public double getAllCalories() {
		return allCalories;
	}

	public void setAllCalories(int allCalories) {
		this.allCalories = allCalories;
	}

	public double getAllCarbs() {
		return allCarbs;
	}

	public void setAllCarbs(int allCarbs) {
		this.allCarbs = allCarbs;
	}

	public double getAllProtein() {
		return allProtein;
	}

	public void setAllProtein(int allProtein) {
		this.allProtein = allProtein;
	}

	public double getAllFat() {
		return allFat;
	}

	public void setAllFat(int allFat) {
		this.allFat = allFat;
	}

	public DailyMeals() {
		mealList = new ArrayList<Meal>();
		allCalories = 0;
		allCarbs = 0;
		allProtein = 0;
		allFat = 0;
	}
	
	public void addMeal(Meal m) {
		mealList.add(m);
		calculate(m);
	}
	
	public void removeMeal(Meal m) {
		mealList.remove(m);
		negativeCalc(m);
	}

	private void negativeCalc(Meal m) {
		allCalories -= m.getCalories();
		allCarbs -= m.getCarbs();
		allProtein -= m.getProtein();
		allFat -= m.getFat();
	}

	private void calculate(Meal m) {
		allCalories += m.getCalories();
		allCarbs += m.getCarbs();
		allProtein += m.getProtein();
		allFat += m.getFat();
	}
	
	public void calculateDaily() {
		for(Meal m : mealList) {
			calculate(m);
		}
	}
	
}
