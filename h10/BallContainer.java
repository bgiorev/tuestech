package com.wordpress.bgiorev.homework10.code;
import java.util.ArrayList;

public class BallContainer {
	private int capacity = 10;
	private ArrayList<Ball> bc = new ArrayList<Ball>(capacity);
	
	public void add (Ball a) {
		if(bc.size() != capacity) {
			if(!bc.contains(a)){
				bc.add(a);
			} else {
				System.out.println("This ball is already in the box");
			}
		} else {
			System.out.println("The box is full");
		}
	}
	
	public void remove (Ball a) {
		if(!bc.isEmpty()) {
			if(!bc.contains(a)) {
				System.out.println("This ball is not in the container");
			} else {
				bc.remove(a);
			}
		} else {
			System.out.println("The box is empty");
		}
	}
	
	public void clear() {
		bc.clear();
	}
	
	public boolean contains(Ball a) {
		return bc.contains(a);
	}
	
	public int size() {
		return capacity -  bc.size();
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void print() {
		for(Ball p:bc) {
			System.out.println(p.getName());
		}
	}
}
