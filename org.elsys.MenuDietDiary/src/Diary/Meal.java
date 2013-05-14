package Diary;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


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
		return convert(calories);
	}
	public double getCarbs() {
		return convert(carbs);
	}
	public double getProtein() {
		return convert(protein);
	}
	public double getFat() {
		return convert(fat);
	}
	
	private double convert(double d){													//Converting double to some format
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("#.##",symbols); 
		return  Double.valueOf(df.format(d));
	}
}
