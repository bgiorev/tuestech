package com.wordpress.bgiorev.sqliteTry.code;

public class Meal {
	private String name;
	private double calories;
	private double carbs;
	private double protein;
	private double fat;
	
	public Meal(String name, double calories, double carbs, double protein, double fat) {
		this.name = name;
		this.calories = calories;
		this.carbs = carbs;
		this.protein = protein;
		this.fat = fat;
	}
	
	public String getName() {
		return name;
	}
	public double getCalories() {
		return calories;
	}
	public double getCarbs() {
		return carbs;
	}
	public double getProtein() {
		return protein;
	}
	public double getFat() {
		return fat;
	}
}
