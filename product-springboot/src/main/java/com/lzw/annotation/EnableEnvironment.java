package com.lzw.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.lzw.config.EnvironmentImportBeanDefinitionRegistrar;
import com.lzw.config.EnvironmentImportSelector;
import com.lzw.service.Environment;

/**
 * 环境枚举，Enable模块来决定
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// @Import(EnvironmentImportSelector.class)
@Import(EnvironmentImportBeanDefinitionRegistrar.class)
public @interface EnableEnvironment {

	Environment.Type type();

}
