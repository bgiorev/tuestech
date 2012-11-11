package com.wordpress.bgiorev.homework11.code;

public class Human {
	private String name;
	private String gender;
	
	public Human() {
		int gends;
		RandomString names = new RandomString();
		String[] genders = {"Male", "Female"};
		setName(names.random());
		gends = (int)((Math.random() * 10)%2);
		setGender(genders[gends]);
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
