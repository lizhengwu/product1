/**
 * FileName: ConditionalMessageConfiguration
 * Author:   lzw
 * Date:     2020/2/20 22:28
 * Description:
 * History:
 */
package com.lzw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lzw.annotation.OnSystemPropertyConditon;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
@Configuration
public class ConditionalMessageConfiguration {

	@Bean("message")
	@OnSystemPropertyConditon(name = "language", value = "chinese")
	public String chineseMessage() {
		return "chinese";
	}

	@Bean("message")
	@OnSystemPropertyConditon(name = "language", value = "english")
	public String englishMessage() {
		return "english";
	}

}