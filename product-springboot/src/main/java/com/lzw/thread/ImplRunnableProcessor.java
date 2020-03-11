/**
 * FileName: ImplRunnableProcessor
 * Author:   lzw
 * Date:     2020/3/11 22:06
 * Description:
 * History:
 */
package com.lzw.thread;

/**
 * 〈实现Runnable接口〉
 *
 * @author lzw
 * @create 2020/3/11
 * @since 1.0.0
 */
public class ImplRunnableProcessor implements Runnable{

	@Override
	public void run() {
		System.out.println("实现Runnable接口");
	}
}