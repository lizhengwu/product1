/**
 * FileName: Environment
 * Author:   lzw
 * Date:     2020/2/18 22:19
 * Description:
 * History:
 */
package com.lzw.service;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/2/18
 * @since 1.0.0
 */
public interface Environment {

	String getEnvironment();

	enum Type{
		DEV,
		PRO

	}
}