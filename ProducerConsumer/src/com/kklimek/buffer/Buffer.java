package com.kklimek.buffer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

	private static final int DEFAULT_BUFFER_SIZE = 10;
	private int bufferSize = DEFAULT_BUFFER_SIZE;
	private int freeSlots = bufferSize;

	private Object consumerMonitor = new Object();
	private Object producerMonitor = new Object();
	private Lock producers = new ReentrantLock(true);
	private Lock consumers = new ReentrantLock(true);

	public void put(int numOfItems) throws InterruptedException {
		producers.lock();
		try {
			while (freeSlots < numOfItems) {
				synchronized (producerMonitor) {
					producerMonitor.wait();
				}
			}

			freeSlots -= numOfItems;
			System.out.println("Put: " + numOfItems);
			synchronized (consumerMonitor) {
				consumerMonitor.notify();
			}
		} finally {
			producers.unlock();
		}
	}

	public void get(int numOfItems) throws InterruptedException {
		consumers.lock();
		try {
			while (bufferSize - freeSlots < numOfItems) {
				synchronized (consumerMonitor) {
					consumerMonitor.wait();
				}
			}

			freeSlots += numOfItems;
			System.out.println("Got: " + numOfItems);
			synchronized (producerMonitor) {
				producerMonitor.notify();
			}

		} finally {
			consumers.unlock();
		}
	}

	public int getBufferSize() {
		return bufferSize;
	}

}