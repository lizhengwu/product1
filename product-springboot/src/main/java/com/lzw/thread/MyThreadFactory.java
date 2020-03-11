/**
 * FileName: MyThreadFactory
 * Author:   lzw
 * Date:     2020/3/11 22:21
 * Description:
 * History:
 */
package com.lzw.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/3/11
 * @since 1.0.0
 */
public class MyThreadFactory implements ThreadFactory {


	protected static final AtomicInteger POOL_SEQ = new AtomicInteger(1);

	protected final AtomicInteger mThreadNum = new AtomicInteger(1);

	protected final String mPrefix;

	protected final boolean mDaemon;

	protected final ThreadGroup mGroup;

	public MyThreadFactory() {
		this("pool-" + POOL_SEQ.getAndIncrement(), false);
	}

	public MyThreadFactory(String prefix) {
		this(prefix, false);
	}

	/**
	 * 创建线程必须制定名称
	 * @param prefix
	 * @param daemon
	 */
	public MyThreadFactory(String prefix, boolean daemon) {
		mPrefix = prefix + "-thread-";
		mDaemon = daemon;
		SecurityManager s = System.getSecurityManager();
		mGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
	}

	@Override
	public Thread newThread(Runnable runnable) {
		String name = mPrefix + mThreadNum.getAndIncrement();
		Thread ret = new Thread(mGroup, runnable, name, 0);
		ret.setDaemon(mDaemon);
		return ret;
	}

	public ThreadGroup getThreadGroup() {
		return mGroup;
	}
}