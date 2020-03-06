/**
 * FileName: DevEnvironmentImpl
 * Author:   lzw
 * Date:     2020/2/18 22:27
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
public class DevEnvironmentImpl implements Environment {

	@Override
	public String getEnvirment() {
		return "测试环境";
	}
}