/**
 * FileName: ExtendThreadProcessor
 * Author:   lzw
 * Date:     2020/3/11 22:04
 * Description:
 * History:
 */
package com.lzw.thread;

/**
 * 〈继承thread实现创建线程〉
 *
 * @author lzw
 * @create 2020/3/11
 * @since 1.0.0
 */
public class ExtendThreadProcessor extends Thread {

	@Override
	public void run() {
		System.out.println("继承自Thread");
	}
}