package com.lzw.util;

import java.util.Random;

/**
 * 雪花算法生成全局唯一ID
 * <p>
 * 0002A4E0A15C46AC8D3E2315A55A2214
 * 计划32位
 */
public class SnowFlake {

	private final static long START_STMP = 0L;

	/**
	 * 数据中心 2
	 */
	private static final int DATACENTER_BIT = 5;

	/**
	 * 机器标识 2
	 */
	private static final int MACHINE_BIT = 5;

	/**
	 * sequence
	 */
	private final static long SEQUENCE_BIT = 12L;

	/**
	 * data center 最大的
	 */
	private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);

	/**
	 * 机器最大ID
	 */
	private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);

	/**
	 * 序列最大
	 */
	private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);



	/**
	 *  time+ datacenter+ machine +sequence
	 * 每一部分向左的位移
	 */
	private final static long MACHINE_LEFT = SEQUENCE_BIT;
	private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
	private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;


	private static long LAST_TIME = 0L;

	private static long sequence = 1L;
	private static long dataCenterId = 1L;
	private static long machineId = 1L;


	public static void main(String[] args) {
		try {
			for(;;){
				long nextId = getNextId();
				System.out.println(nextId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	private static synchronized long getNextId() throws Exception {
		long currentTimeMillis = System.currentTimeMillis();
		if (currentTimeMillis < LAST_TIME) {
			throw new Exception();
		}

		if (currentTimeMillis == LAST_TIME) {
			sequence = (sequence + 1) & MAX_SEQUENCE;
			if (sequence == 0L) {
				// 序列号达到最大。
				throw new Exception();
			}

		}else{
			//不同毫秒内，序列号置为0
			sequence = 0L;
		}
		LAST_TIME = currentTimeMillis;
		return currentTimeMillis << TIMESTMP_LEFT | dataCenterId << DATACENTER_LEFT | machineId << MACHINE_LEFT | sequence ;
	}

}
