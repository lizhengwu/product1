package com.lzw.zookeeper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class Node {

	// 自动以每个节点的状态
	private Status status;
	// 节点路径
	private String nodeForLeaderInfo;
	// zookeeper实例
	private ZooKeeper zooKeeper;

	public Node(String nodeForLeaderInfo) throws IOException {
		this.nodeForLeaderInfo = nodeForLeaderInfo;
		zooKeeper = new ZooKeeper("127.0.0.1:2181", 1000, event -> {
			// 收到通知
			System.out.println("收到更改通知" + event.getState());
		});
		lookingForLeader();

	}

	/**
	 * 抢leader方法
	 */
	private void lookingForLeader() {
		// 设置自己的状态为
		status = Status.LOOKING;
		String leaderInfo = Thread.currentThread().getName();

		try {
			String s = zooKeeper.create(nodeForLeaderInfo, leaderInfo.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			status = Status.LEADER;
			System.out.println(Thread.currentThread().getName() + " is leader");
		} catch (KeeperException.NodeExistsException e) {
			status = Status.FOLLOWER;
			try {
				byte[] data = zooKeeper.getData(nodeForLeaderInfo, event -> {
					if (event.getType() == Watcher.Event.EventType.NodeDeleted) {
						lookingForLeader();
					}
				}, null);
				String logMsg = Thread.currentThread().getName() + " is follower, master is " + new String(data, "UTF-8");
				System.out.println(logMsg);
			} catch (KeeperException | UnsupportedEncodingException | InterruptedException e1) {
				e1.printStackTrace();
			}

		} catch (InterruptedException | KeeperException e) {
			e.printStackTrace();
		}

	}

	public void shutdown() {
		try {
			if (zooKeeper != null) {
				zooKeeper.close();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Status getStatus() {
		return status;
	}

	public enum Status {
		LOOKING, // 选举中
		LEADER, // 选举完毕，当前节点为leader
		FOLLOWER; // 选举完毕，当前节点为follower
	}

}
