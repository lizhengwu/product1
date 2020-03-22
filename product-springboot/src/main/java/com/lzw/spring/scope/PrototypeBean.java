/**
 * FileName: PrototypeBean
 * Author:   lzw
 * Date:     2020/3/22 23:35
 * Description:
 * History:
 */
package com.lzw.spring.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 〈多例子〉
 *
 * @author lzw
 * @create 2020/3/22
 * @since 1.0.0
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

	private String  name = "多例1" ;


	@Autowired
	private SingletonBean singletonBean;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printSingletonBeanBeanHashCode() {
		System.out.println(singletonBean.hashCode());
	}
}