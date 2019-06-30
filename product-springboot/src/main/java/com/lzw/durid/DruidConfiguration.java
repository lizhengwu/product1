/**
 * FileName: DruidConfiguration
 * Author:   lzw
 * Date:     2019/6/30 19:12
 * Description:
 * History:
 */
package com.lzw.durid;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2019/6/30
 * @since 1.0.0
 */
@Configuration
public class DruidConfiguration {
	private static final Logger log = LoggerFactory.getLogger(DruidConfiguration.class);

	/**
	 * 注册一个servlet
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {
		log.info("init Durid servlet");
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new StatViewServlet());
		servletRegistrationBean.setUrlMappings(Collections.singleton("/druid/*"));

		Map<String, String> params = new HashMap<String, String>();
		params.put("loginUsername", "admin");
		params.put("loginPassword", "admin");
		params.put("resetEnable", "false");
		servletRegistrationBean.setInitParameters(params);

		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean druidFilter() {
		log.info("init Durid Filter");
		FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
		WebStatFilter webStatFilter = new WebStatFilter();
		filterFilterRegistrationBean.setFilter(webStatFilter);
		filterFilterRegistrationBean.addUrlPatterns("/*");
		filterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");

		return filterFilterRegistrationBean;
	}

}