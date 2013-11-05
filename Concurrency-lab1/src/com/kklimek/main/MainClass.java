package com.kklimek.main;

import com.kklimek.threads.OneThread;
import com.kklimek.threads.ThreeThread;
import com.kklimek.threads.TwoThread;

public class MainClass {

	public static int lastNum = 3;
	public final static Object mutex1 = new Object();
	public final static Object mutex2 = new Object();
	public final static Object mutex3 = new Object();

	public static void createAndRunThreads() {

		OneThread oneThread = new OneThread();
		TwoThread twoThread = new TwoThread();
		ThreeThread threeThread = new ThreeThread();

		Thread one = new Thread(oneThread);
		Thread two = new Thread(twoThread);
		Thread three = new Thread(threeThread);

		one.start();
		two.start();
		three.start();
	}

	public static void main(String[] args) {
		createAndRunThreads();
	}
}
