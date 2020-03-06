/**
 * FileName: EnvironmentSelector
 * Author:   lzw
 * Date:     2020/2/18 22:16
 * Description:
 * History:
 */
package com.lzw.config;

import java.util.stream.Stream;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 〈选择条件注入处理器〉
 *
 * @author lzw
 * @create 2020/2/18
 * @since 1.0.0
 */
@Configuration
public class EnvironmentImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		EnvironmentImportSelector environmentImportSelector = new EnvironmentImportSelector();
		String[] selectImports = environmentImportSelector.selectImports(importingClassMetadata);
		Stream.of(selectImports).map(BeanDefinitionBuilder::genericBeanDefinition).map(BeanDefinitionBuilder::getBeanDefinition)
			  .forEach(beaDefinition -> BeanDefinitionReaderUtils.registerWithGeneratedName(beaDefinition, registry));
	}
}