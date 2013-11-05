package com.kklimek.threads;

import com.kklimek.main.MainClass;

public class TwoThread implements Runnable {
	private int num;

	public TwoThread() {
		num = 2;
	}

	@Override
	public void run() {
		synchronized (MainClass.mutex2) {
			while (MainClass.lastNum != 1) {
				try {
					System.out.println("Drugi czeka...");
					MainClass.mutex2.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(num);
			MainClass.lastNum = num;
			// MainClass.mutex2.notifyAll();

		}
		synchronized (MainClass.mutex3) {
			MainClass.mutex3.notifyAll();
		}

	}
}
