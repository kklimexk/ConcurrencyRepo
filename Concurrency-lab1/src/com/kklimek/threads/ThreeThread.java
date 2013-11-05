package com.kklimek.threads;

import com.kklimek.main.MainClass;

public class ThreeThread implements Runnable {
	private int num;

	public ThreeThread() {
		num = 3;
	}

	@Override
	public void run() {
		synchronized (MainClass.mutex3) {
			while (MainClass.lastNum != 2) {
				try {
					System.out.println("Trzeci czeka...");
					MainClass.mutex3.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(num);
			MainClass.lastNum = num;
			// MainClass.mutex3.notifyAll();

		}
		synchronized (MainClass.mutex1) {
			MainClass.mutex1.notifyAll();
		}

	}
}