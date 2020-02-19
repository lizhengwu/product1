/**
 * FileName: ProEnvironmentImpl
 * Author:   lzw
 * Date:     2020/2/18 22:28
 * Description:
 * History:
 */
package com.lzw.service;

import org.springframework.stereotype.Component;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/2/18
 * @since 1.0.0
 */

@Component
public class ProEnvironmentImpl implements Environment {

	@Override
	public String getEnvirment() {
		return "生产环境";
	}
}