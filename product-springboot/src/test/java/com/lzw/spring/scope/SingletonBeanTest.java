package com.lzw.spring.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

@Configuration
@ComponentScan("com.lzw.spring.scope")
class SingletonBeanTest {

	@Test
	void printPrototypeBeanHashCode() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(SingletonBeanTest.class);
		annotationConfigApplicationContext.refresh();
		// SingletonBean singletonBean = annotationConfigApplicationContext.getBean("singletonBean", SingletonBean.class);
		// singletonBean.printPrototypeBeanHashCode();
		// SingletonBean2 singletonBean2 = annotationConfigApplicationContext.getBean("singletonBean2", SingletonBean2.class);
		// singletonBean2.printPrototypeBeanHashCode();
		PrototypeBean prototypeBean = annotationConfigApplicationContext.getBean("prototypeBean", PrototypeBean.class);
		PrototypeBean2 prototypeBean2 = annotationConfigApplicationContext.getBean("prototypeBean2", PrototypeBean2.class);
		prototypeBean.printSingletonBeanBeanHashCode();
		prototypeBean2.printSingletonBeanBeanHashCode();
	}
}