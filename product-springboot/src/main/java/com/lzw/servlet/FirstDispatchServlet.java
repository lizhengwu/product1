/**
 * FileName: FirstDispatchServlet
 * Author:   lzw
 * Date:     2020/2/20 16:38
 * Description:
 * History:
 */
package com.lzw.servlet;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.lzw.config.SpringWebMvcConfiguration;

/**
 * 〈基于注解实现web的自动装备〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
@Component
public class FirstDispatchServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 初始化ApplicationContext
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{ SpringWebMvcConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*.first" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return super.getServletFilters();
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		super.customizeRegistration(registration);
	}
}