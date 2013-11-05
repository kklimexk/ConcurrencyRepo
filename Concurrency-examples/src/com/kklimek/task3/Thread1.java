package com.kklimek.task3;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100000000; ++i) {
			MainClass.lock.lock();
			try {
				MainClass.counter++;
			} finally {
				MainClass.lock.unlock();
			}
		}
	}
}
