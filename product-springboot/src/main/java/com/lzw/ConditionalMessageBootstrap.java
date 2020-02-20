/**
 * FileName: ConditionalMessageBootstrap
 * Author:   lzw
 * Date:     2020/2/20 22:31
 * Description:
 * History:
 */
package com.lzw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lzw.config.ConditionalMessageConfiguration;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
public class ConditionalMessageBootstrap {

	public static void main(String[] args) {
		System.setProperty("language", "english");
		// 构建annotation 驱动
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

		annotationConfigApplicationContext.register(ConditionalMessageConfiguration.class);

		annotationConfigApplicationContext.refresh();

		String message = annotationConfigApplicationContext.getBean("message",String.class);

		System.out.println(message);

		annotationConfigApplicationContext.close();
	}

}