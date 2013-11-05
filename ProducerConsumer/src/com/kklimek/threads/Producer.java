package com.kklimek.threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.kklimek.buffer.Buffer;

public class Producer implements Runnable {

	private Buffer buffer;
	private static Random rand = new Random();

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				buffer.put(produce());
			}
		} catch (InterruptedException e) {
			System.err.println("Producer interrupted!!!");
		}
	}

	public int produce() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(1000));
		return rand.nextInt(buffer.getBufferSize() / 2) + 1;
	}

}
