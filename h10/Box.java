﻿/*
 * 	Технологично училище "Електронни системи"
 * www.elsys-bg.org
 * 11Б клас
 * Божидар ивов Гьорев
 * Номер 6
 * Задача - да се направи програма, която да слага топчета в кутия
 * */
package com.wordpress.bgiorev.homework10.code;

public class Box {
	public static void main(String[] args) {
		BallContainer box = new BallContainer();
		Ball b1 = new Ball();
		b1.setName("b1");
		box.add(b1);
		box.print();
		System.out.println(box.contains(b1));
		Ball b2 = new Ball();
		b2.setName("b2");
		box.add(b2);
		Ball b3 = new Ball();
		b3.setName("b3");
		box.add(b3);
		Ball b4 = new Ball();
		b4.setName("b4");
		box.add(b4);
		Ball b5 = new Ball();
		b5.setName("b5");
		box.add(b5);
		Ball b6 = new Ball();
		b6.setName("b6");
		box.add(b6);
		Ball b7 = new Ball();
		b7.setName("b7");
		box.add(b7);
		Ball b8 = new Ball();
		b8.setName("b8");
		box.add(b8);
		Ball b9 = new Ball();
		b9.setName("b9");
		box.add(b9);
		Ball b10 = new Ball();
		b10.setName("b10");
		box.add(b10);
		System.out.println(box.getCapacity());
		System.out.println(box.size());
		System.out.println(box.contains(b10));
		Ball b11 = new Ball();
		b11.setName("b11");
		box.add(b11);
		System.out.println(box.contains(b11));
		box.print();
		System.out.println("###################");
		box.remove(b6);
		box.print();
		
	}

}
