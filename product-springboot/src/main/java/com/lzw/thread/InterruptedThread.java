package com.lzw.thread;

public class InterruptedThread {

	/**
	 * interrupt的核心就是设置一个状态，如果不在Runnable中就会抛出一个异常，如果在的话，就会标记为成已经失效的状态
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		MyInterruptedThread myInterruptedThread = new MyInterruptedThread();
		myInterruptedThread.start();
		// 当标记interrupt之后，线程内就收到信号了，其实用一个变量传进去也应该可以。
		myInterruptedThread.interrupt();

		MyInterruptedThread2 myInterruptedThread2 = new MyInterruptedThread2();
		myInterruptedThread2.start();
		myInterruptedThread2.interrupt();
	}

	static class MyInterruptedThread extends Thread {
		@Override
		public void run() {
			while (!interrupted()) {
				System.out.println("还在执行");
			}
			System.out.println("thread end");
		}
	}

	/**
	 * sleep 等IO的Block状态下会抛出其他异常
	 */
	static class MyInterruptedThread2 extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("thread end");
		}
	}
}
