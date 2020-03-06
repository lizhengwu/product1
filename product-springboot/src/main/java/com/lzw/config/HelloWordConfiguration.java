/**
 * FileName: HelloWordConfiguration
 * Author:   lzw
 * Date:     2020/2/18 20:59
 * Description:
 * History:
 */
package com.lzw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lzw.aspect.TimeAspect;

/**
 * 〈@Enable design module〉
 *
 * @author lzw
 * @create 2020/2/18
 * @since 1.0.0
 */
@Configuration
public class HelloWordConfiguration {

	/**
	 * create  a bean, name is helloWord
	 * @return
	 */
	@Bean
	public String helloWord() {
		return "hello Word";
	}

}