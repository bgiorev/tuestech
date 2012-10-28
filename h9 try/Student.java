import java.io.*;
class Homework{
	public String name;
	public String deadLine;
	public String timeStamp;
	public String link;
}

public class Student {
	private String clas;
	private String number;
	private String name;
	private String email;
	private String belt;
	private Homework[] homeworks = new Homework[9];
	
	public void set_clas(String value) {
		clas = value;
	}
	
	public void set_number(String value) {
		number = value;
	}
	
	public void set_name(String value) {
		name = value;
	}
	
	public void set_email(String value) {
		email = value;
	}
	
	public void set_belt(String value) {
		belt = value;
	}
	
	public void set_homeworks(Homework[] value) {
		homeworks = value;
	}
	
	public String get_clas() {
		return clas;
	}
	
	public String get_number() {
		return number;
	}
	
	public String get_name() {
		return name;
	}
	
	public String get_email() {
		return email;
	}
	
	
	public String get_belt() {
		return belt;
	}
	
	public Homework[] get_homeworks() {
		return homeworks;
	}
}