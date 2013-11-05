package com.kklimek.threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.kklimek.buffer.Buffer;

public class Consumer implements Runnable {

	private Buffer buffer;
	private static Random rand = new Random();

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				buffer.get(rand.nextInt(buffer.getBufferSize() / 2) + 1);
				consume();
			}
		} catch (InterruptedException e) {
			System.err.println("Consumer interrupted!!!");
		}

	}

	public void consume() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
	}

}