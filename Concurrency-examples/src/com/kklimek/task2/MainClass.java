package com.kklimek.task2;

public class MainClass {

	public static int counter = 0;
	public static Object mutex = new Object();

	public static void main(String[] args) throws InterruptedException {

		Thread1 th1 = new Thread1();
		Thread2 th2 = new Thread2();
		
		Thread t1 = new Thread(th1);
		Thread t2 = new Thread(th2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

		System.out.println(counter);
	}
}
