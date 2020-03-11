package com.lzw.zookeeper;

import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Service;

/**
 * curator 框架使用
 */
@Service
public class CuratorFactory {

	int count = 0;

	/**
	 * zookeeper 实现分布式锁
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CuratorFactory curatorFactory = new CuratorFactory();
		// 模拟三台机器拿到三个锁
		InterProcessLock interProcessLock1 = curatorFactory.initZkClientLock();
		InterProcessLock interProcessLock2 = curatorFactory.initZkClientLock();
		InterProcessLock interProcessLock3 = curatorFactory.initZkClientLock();

		// 三个线程 代表三台服务器 , count 代表在数据库中存储的值，
		Thread thread1 = new Thread(() -> {
			try {
				interProcessLock1.acquire(1000, TimeUnit.MILLISECONDS);
				int count = curatorFactory.getCount();
				count++;
				curatorFactory.setCount(count);
				System.out.println(curatorFactory.getCount());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					interProcessLock1.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			try {
				interProcessLock2.acquire(1000, TimeUnit.MILLISECONDS);
				int count = curatorFactory.getCount();
				count++;
				curatorFactory.setCount(count);
				System.out.println(curatorFactory.getCount());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					interProcessLock2.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread thread3 = new Thread(() -> {
			try {
				interProcessLock3.acquire(1000, TimeUnit.MILLISECONDS);
				int count = curatorFactory.getCount();
				count++;
				curatorFactory.setCount(count);
				System.out.println(curatorFactory.getCount());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					interProcessLock3.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		/**
		 * 模拟三台机器来对一个账户进行加钱
		 */
		thread1.start();
		thread2.start();
		thread3.start();

	}

	/**
	 * 初始化一个可重入锁
	 * @return
	 * @throws Exception
	 */
	private InterProcessLock initZkClientLock() throws Exception {
		ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(1000, 4);
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", exponentialBackoffRetry);
		client.start();
		// 分布式锁
		return new InterProcessMutex(client, "/lock");

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
