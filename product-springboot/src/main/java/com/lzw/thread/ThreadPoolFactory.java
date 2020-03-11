/**
 * FileName: ThreadPoolFactory
 * Author:   lzw
 * Date:     2020/3/11 22:15
 * Description:
 * History:
 */
package com.lzw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/3/11
 * @since 1.0.0
 */
public class ThreadPoolFactory {

	/**
	 * 创建单个线程
	 */
	private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();
	/**
	 * 创建线程带名称单线程池
	 */
	private static final ExecutorService EXECUTOR_SERVICE_NAME = Executors.newSingleThreadExecutor(new MyThreadFactory("TEST"));

	/**
	 * 缓存线程池
	 */
	private static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool(new MyThreadFactory("cachedThreadPool"));
	/**
	 * 固定线程池
	 */
	private static final ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2, new MyThreadFactory("cachedThreadPool"));

	/**
	 * 并行线程池
	 */
	private static final ExecutorService workStealingPool = Executors.newWorkStealingPool();
	/**
	 * 创建一个可以定时的线程池
	 */
	private static final ScheduledExecutorService singleThreadExecutor = Executors.newScheduledThreadPool(2, new MyThreadFactory("singleThreadExecutor"));

	public static void main(String[] args) throws InterruptedException {

		ScheduledFuture<?> scheduledFuture = singleThreadExecutor.scheduleAtFixedRate(() -> System.out.println("定时线程池"), 60L, 60L, TimeUnit.MILLISECONDS);

		Thread.sleep(6000L);
	}

}