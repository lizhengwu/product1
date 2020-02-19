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

import com.lzw.annotation.EnableHelloWord;

/**
 * 〈Enable design module 〉
 *
 * @author lzw
 * @create 2020/2/18
 * @since 1.0.0
 */
@Configuration
@EnableHelloWord
public class EnableHelloWordBootStrap {

	public static void main(String[] args) {
		// 构建annotation 驱动
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

		annotationConfigApplicationContext.register(EnableHelloWordBootStrap.class);

		annotationConfigApplicationContext.refresh();

		String helloWord = annotationConfigApplicationContext.getBean("helloWord", String.class);
		System.out.println(helloWord);

		annotationConfigApplicationContext.close();
	}

}