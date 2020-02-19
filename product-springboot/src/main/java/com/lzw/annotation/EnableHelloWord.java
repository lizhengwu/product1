package com.lzw.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.lzw.config.HelloWordConfiguration;

/**
 * @Link{EnableHelloWord} Enable  Design module
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import(HelloWordConfiguration.class)
public @interface EnableHelloWord {
}
