package com.lzw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedThread {
	/**
	 * synchronized 不同的方法快入参，作用域是不同的
	 * @param args
	 */
	public static void main(String[] args) {

		SyncClazz synchronizedThread = new SyncClazz();
		SyncClazz synchronizedThread1 = new SyncClazz();

		// SyncThis synchronizedThread = new SyncThis();
		// SyncThis synchronizedThread1 = new SyncThis();

		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.execute(synchronizedThread::func1);
		executorService.execute(synchronizedThread1::func1);

	}

	static class SyncThis {

		/**
		 * 这个方法的作用域是当前方法块，不同的对象不会阻塞
		 */
		public void func1() {
			synchronized (this) {
				try {
					System.out.println("11111");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		}
	}

	static class SyncClazz {
		/**
		 * 这个方法锁的是整个CLass，无论内存中多少个实例，都会被阻塞
		 */
		public void func1() {
			synchronized (ThreadPoolFactory.class) {
				try {
					System.out.println("11111");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		}
	}
}
