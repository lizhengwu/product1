/**
 * FileName: SpringWebMvcConfiguration
 * Author:   lzw
 * Date:     2020/2/20 16:45
 * Description:
 * History:
 */
package com.lzw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 〈spring MVC注解配置类〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
@Configuration
@EnableWebMvc
public class SpringWebMvcConfiguration implements WebMvcConfigurer {

}