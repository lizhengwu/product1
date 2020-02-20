package com.lzw.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

import com.lzw.condition.OnSystemPropertiesCondition;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertiesCondition.class)
public @interface OnSystemPropertyConditon {

	/**
	 * 属性名称
	 *
	 * @return
	 */
	String name();

	/**
	 * 属性值
	 *
	 * @return
	 */
	String value();

}
