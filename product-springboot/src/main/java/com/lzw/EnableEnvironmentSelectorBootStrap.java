/**
 * FileName: EnableHelloWordBootStrap
 * Author:   lzw
 * Date:     2020/2/18 21:10
 * Description:
 * History:
 */
package com.lzw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.lzw.annotation.EnableEnvironment;
import com.lzw.service.Environment;

/**
 * 〈Enable design module 〉
 *
 * @author lzw
 * @create 2020/2/18
 * @since 1.0.0
 */
@Configuration
@EnableEnvironment(type = Environment.Type.PRO)
public class EnableEnvironmentSelectorBootStrap {

	public static void main(String[] args) {
		// 构建annotation 驱动
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

		annotationConfigApplicationContext.register(EnableEnvironmentSelectorBootStrap.class);

		annotationConfigApplicationContext.refresh();

		Environment environment = annotationConfigApplicationContext.getBean(Environment.class);
		System.out.println(environment.getEnvironment());

		annotationConfigApplicationContext.close();
	}

}