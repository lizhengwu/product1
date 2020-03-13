package com.lzw.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	static int i = 1;

	public static void main(String[] args) {

	}

	public static void increment() throws InterruptedException {
		ReentrantLock reentrantLock = new ReentrantLock();

		if (reentrantLock.tryLock(100, TimeUnit.MILLISECONDS)) {
			try {
				i++;
			} catch (Exception e) {

			} finally {
				reentrantLock.unlock();
			}
		}
	}



}
