package com.kklimek.task1;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100000000; ++i)
			MainClass.counter--;
	}

}
