package com.kklimek.task1;

public class MainClass {

	public static int counter = 0;

	public static void main(String[] args) {

		Thread1 th1 = new Thread1();
		Thread2 th2 = new Thread2();
		new Thread(th1).start();
		new Thread(th2).start();

		System.out.println(counter);
	}

}
