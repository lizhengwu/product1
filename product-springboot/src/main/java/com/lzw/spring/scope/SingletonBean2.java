/**
 * FileName: SingletonBean
 * Author:   lzw
 * Date:     2020/3/22 23:34
 * Description:
 * History:
 */
package com.lzw.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 〈单例〉
 *
 * @author lzw
 * @create 2020/3/22
 * @since 1.0.0
 */
@Component
public class SingletonBean2 {

	private String name = "单例2";

	// @Autowired
	// private PrototypeBean prototypeBean;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public void printPrototypeBeanHashCode() {
	// 	System.out.println(prototypeBean.hashCode());
	// }
}