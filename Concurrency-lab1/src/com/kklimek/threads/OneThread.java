package com.kklimek.threads;

import com.kklimek.main.MainClass;

public class OneThread implements Runnable {

	private int num;

	public OneThread() {
		num = 1;
	}

	@Override
	public void run() {
		synchronized (MainClass.mutex1) {
			while (MainClass.lastNum != 3) {
				try {
					System.out.println("Pierwszy czeka...");
					MainClass.mutex1.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(num);
			MainClass.lastNum = num;
			// MainClass.mutex1.notifyAll();

		}
		synchronized (MainClass.mutex2) {
			MainClass.mutex2.notifyAll();
		}

	}
}