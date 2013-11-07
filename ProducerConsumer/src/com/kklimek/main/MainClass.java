package com.kklimek.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.kklimek.buffer.Buffer;
import com.kklimek.threads.Consumer;
import com.kklimek.threads.Producer;

public class MainClass {

	public static void createAndStartThreads(int numOfProducers,
			int numOfConsumers, int secondsTime) {
		Buffer buffer = new Buffer();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < numOfProducers; ++i)
			exec.execute(new Producer(buffer));
		for (int i = 0; i < numOfConsumers; ++i)
			exec.execute(new Consumer(buffer));
		try {
			TimeUnit.SECONDS.sleep(secondsTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exec.shutdownNow();
	}

	public static void main(String[] args) {
		createAndStartThreads(3, 3, 10);
	}
}
