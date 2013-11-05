package com.kklimek.task2;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000000; ++i)
			synchronized (MainClass.mutex) {
				MainClass.counter++;
			}
	}
}
