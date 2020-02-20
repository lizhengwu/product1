/**
 * FileName: SpringWebMvcConfiguration
 * Author:   lzw
 * Date:     2020/2/20 16:45
 * Description:
 * History:
 */
package com.lzw.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
@EnableWebMvc
@Configuration
public class SpringWebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2CborHttpMessageConverter());
	}


}