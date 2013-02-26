package com.wordpress.bgiorev.sqliteTry.code;

public class Meal {
	private String name;
	private double calories;
	private int carbs;
	private int protein;
	private int fat;
	
	public Meal(String name, double calories, int carbs, int protein, int fat) {
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
	public int getCarbs() {
		return carbs;
	}
	public int getProtein() {
		return protein;
	}
	public int getFat() {
		return fat;
	}
}
