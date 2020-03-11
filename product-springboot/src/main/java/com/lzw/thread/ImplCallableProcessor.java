/**
 * FileName: ImplCallableProcessor
 * Author:   lzw
 * Date:     2020/3/11 22:07
 * Description:
 * History:
 */
package com.lzw.thread;

import java.util.concurrent.Callable;

/**
 * 〈实现Callable接口〉
 *
 * @author lzw
 * @create 2020/3/11
 * @since 1.0.0
 */
public class ImplCallableProcessor<T> implements Callable<T> {

	@Override
	public  T call() throws Exception {
		return (T) "实现Callable接口";
	}
}