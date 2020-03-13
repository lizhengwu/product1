package com.lzw.thread.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

	StampedLock stampedLock = new StampedLock();

	private Integer count = 0;

	public static void main(String[] args) {

	}

	private void getWriteLock(StampedLockTest stampedLockTest) {
		long l = stampedLock.writeLock();
		try {
			this.setCount(this.getCount() + 1);
		} catch (Exception e) {

		} finally {
			stampedLock.unlockWrite(l);
		}
	}

	private void getReadLock() {
		// 获取一个乐观锁
		long l = stampedLock.tryOptimisticRead();
		// 读取数据
		Integer count = this.getCount();
		// 验证乐观锁
		if (!stampedLock.validate(l)) {
			long l1 = stampedLock.readLock();
			try {
				count = this.getCount();
			} catch (Exception e) {

			} finally {
				stampedLock.unlockRead(l1);
			}
		}
		System.out.println(count);

	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
