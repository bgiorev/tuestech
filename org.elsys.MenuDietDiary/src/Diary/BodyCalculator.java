package Diary;

public class BodyCalculator {
	private int height;
	private int weight;
	private int age;
	private String gender;
	private int physicalActivity;
	private double physicalActivityIndex;
	private int caloriesLimit;
	private String dietPerpose;
	private String name;
	
	public double getPhysicalActivityIndex() {
		return physicalActivityIndex;
	}

	public String getName() {
		return name;
	}

	public BodyCalculator(String name,int height, int weight, int age, String gender,
			int physicalActivity, String dietPerpose) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
		this.dietPerpose = dietPerpose;
		this.physicalActivity = physicalActivity;
		setPhysicalActivityIndex(physicalActivity);
		calculate();
		checkPerpose();
	}
	
	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public int getPhysicalActivity() {
		return physicalActivity;
	}

	private void setPhysicalActivityIndex(int physicalActivity) {
		switch (physicalActivity) {
		case 0:
			physicalActivityIndex = 1.2;
			break;
		case 1:
		case 2:
		case 3:
			physicalActivityIndex = 1.375;
			break;
		case 4:
		case 5:
			physicalActivityIndex = 1.55;
			break;
		case 6:
		case 7:
			physicalActivityIndex = 1.725;
			break;
		}

	}
	
	private void checkPerpose() {
		int perpose = 0;
		if(dietPerpose == null)
			System.out.println("Shit nigga");
		switch(dietPerpose){
			case "Сваля" : perpose = -500;
							break;
			case "Кача" : perpose = 500;
							break;
			case "Задържа": perpose = 0;
					break;
		}
		caloriesLimit +=  perpose;
	}

	private void calculate() {
		if (gender.equals("мъж")) {
			caloriesLimit = (int) (physicalActivityIndex * (66
					+ (13.7 * weight) + (5 * height) + (6.8 * age)));
		}
		if (gender.equals("жена")) {
			caloriesLimit = (int) (physicalActivityIndex * (655
					+ +(9.6 * weight) + (1.8 * height) + (4.7 * age)));
		}
	}

	public int getCaloriesLimit() {
		return caloriesLimit;
	}

	public String getDietPerpose() {
		return dietPerpose;
	}
}
