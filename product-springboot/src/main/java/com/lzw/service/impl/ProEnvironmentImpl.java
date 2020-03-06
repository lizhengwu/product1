/**
 * FileName: ProEnvironmentImpl
 * Author:   lzw
 * Date:     2020/2/18 22:28
 * Description:
 * History:
 */
package com.lzw.service.impl;

import org.springframework.stereotype.Component;

import com.lzw.service.Environment;

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
	public String getEnvironment() {
		return "生产环境";
	}
}