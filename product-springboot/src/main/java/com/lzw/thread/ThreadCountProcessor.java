package com.lzw.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ThreadCountProcessor {

	public static void main(String[] args) {
		ThreadCountProcessor threadCountProcessor = new ThreadCountProcessor();
		// threadCountProcessor.countDownTest();
		threadCountProcessor.cyclicBarrier();

	}

	/**
	 *
	 */
	private void countDownTest() {
		int count = 10 ;
		CountDownLatch countDownLatch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread(()->{
				System.out.println("伞兵" + Thread.currentThread().getName().replaceAll("Thread-","") + "号跳下去了");
				countDownLatch.countDown();
				System.out.println("伞兵" + Thread.currentThread().getName().replaceAll("Thread-","") + "号尖叫了出来");
			}).start();
		}

		try {
			countDownLatch.await();
			System.out.println("轰炸");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * CyclicBarrier 是需要等待所有线程都执行到await上，然后再接着向下执行，用于所有线程内部的执行时机
	 */
	private void cyclicBarrier() {
		int count = 10;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count);

		for (int i = 0; i < count; i++) {
			new Thread(()->{
				try {
					System.out.println("伞兵" + Thread.currentThread().getName().replaceAll("Thread-","") + "号准备就绪");
					cyclicBarrier.await();
					System.out.println("伞兵" + Thread.currentThread().getName().replaceAll("Thread-","") + "跳伞完毕");
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}

			}).start();
		}

	}



}
