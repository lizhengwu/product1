package com.lzw.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.lzw.properties.MasterMybatisProperties;

/**
 * 主数据库配置
 */
@Configuration
// 通过注解引入配置信息。不再用传统的类变量来引入
@EnableConfigurationProperties(MasterMybatisProperties.class)
@MapperScan(basePackages = "com.lzw.dao", sqlSessionFactoryRef = "masterSqlSessionFactory", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDbConfig {

	private final MasterMybatisProperties masterMybatisProperties;

	public MasterDbConfig(MasterMybatisProperties masterMybatisProperties) {
		this.masterMybatisProperties = masterMybatisProperties;
	}

	//
	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource masterDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean("masterSqlSessionFactory")
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTypeAliasesPackage(this.masterMybatisProperties.getTypeAliasesPackage());
		factory.setMapperLocations(this.masterMybatisProperties.resolveMapperLocations());
		return factory.getObject();
	}

	@Bean("masterSqlSessionTemplate")
	public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
