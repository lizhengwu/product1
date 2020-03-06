/**
 * FileName: EnvironmentSelector
 * Author:   lzw
 * Date:     2020/2/18 22:16
 * Description:
 * History:
 */
package com.lzw.config;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.lzw.annotation.EnableEnvironment;
import com.lzw.service.impl.DevEnvironmentImpl;
import com.lzw.service.Environment;
import com.lzw.service.impl.ProEnvironmentImpl;

/**
 * 〈〉
 *
 * @author lzw
 * @create 2020/2/18
 * @since 1.0.0
 */
@Configuration
public class EnvironmentImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		// 读取所有的Annotation
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableEnvironment.class.getName());
		Environment.Type type = (Environment.Type) annotationAttributes.get("type");
		String[] importClass = new String[0];
		switch (type) {
		case DEV:
			importClass = new String[] { DevEnvironmentImpl.class.getName() };
			break;
		case PRO:
			importClass = new String[] { ProEnvironmentImpl.class.getName() };
			break;
		}

		return importClass;
	}
}