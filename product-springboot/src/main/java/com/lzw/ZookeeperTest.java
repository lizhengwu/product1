package com.lzw;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.lzw.zookeeper.Node;

public class ZookeeperTest {

	public static void main(String[] args) {
		final String LEADER_INFO_NODE = "/leader-info";

		int nodeNum = 10;
		AtomicLong idGenerator = new AtomicLong();
		AtomicInteger activeNodeCount = new AtomicInteger();

		while (true) {
			if (activeNodeCount.get() >= nodeNum) {
				sleep(10);
				continue;
			}

			activeNodeCount.incrementAndGet();

			new Thread(() -> {
				try {
					Node node = new Node(LEADER_INFO_NODE);
					while (true) {
						sleep(1000);
						if (node.getStatus() == Node.Status.LEADER && Math.random() < 0.3) {
							String logMsg = "----------------------------- " + Thread.currentThread().getName() + " shutdown -----------------------------";
							System.out.println(logMsg);
							node.shutdown();
							break;
						}
					}

				} catch (Exception e) {

				} finally {
					activeNodeCount.decrementAndGet();
				}

			}, "node-" + idGenerator.getAndIncrement()).start();

		}

	}

	private static void sleep(long mils) {
		try {
			TimeUnit.MILLISECONDS.sleep(mils);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
