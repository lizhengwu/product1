/**
 * FileName: DevEnvironmentImpl
 * Author:   lzw
 * Date:     2020/2/18 22:27
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
public class DevEnvironmentImpl implements Environment {

	@Override
	public String getEnvirment() {
		return "测试环境";
	}
}